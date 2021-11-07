package nl.com.lucianoluzzi.message.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import nl.com.lucianoluzzi.core.domain.Message
import nl.com.lucianoluzzi.message.R
import nl.com.lucianoluzzi.message.databinding.FragmentMessageBinding
import nl.com.lucianoluzzi.message.ui.model.MessageEvents
import nl.com.lucianoluzzi.message.ui.model.MessageIntent
import nl.com.lucianoluzzi.message.ui.viewModel.MessageViewModel
import nl.com.lucianoluzzi.navigation.Navigator.Companion.MESSAGE_ARGUMENT_KEY

class MessageFragment(
    private val viewModel: MessageViewModel
) : Fragment() {
    private val binding by lazy {
        val layoutInflater = LayoutInflater.from(requireContext())
        FragmentMessageBinding.inflate(layoutInflater)
    }
    private val message by lazy<Message?> {
        requireArguments().getParcelable(MESSAGE_ARGUMENT_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        viewModel.messageEventLiveData.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                handleEvents(it)
            }
        }
    }

    private fun setViews() = with(binding) {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        message?.let { message ->
            title.text = message.title
            description.text =
                HtmlCompat.fromHtml(message.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
            favorite.isSelected = message.isInterested
            if (!message.isInterested) {
                favorite.setOnClickListener {
                    viewModel.onIntent(
                        MessageIntent.OnIsInterestedClicked(message.id)
                    )
                }
            }

            message.image?.let {
                image.load(it) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }
        }
    }

    private fun handleEvents(event: MessageEvents) {
        when (event) {
            MessageEvents.IsInterestedError -> {
                binding.favorite.isSelected = !binding.favorite.isSelected
            }
            MessageEvents.IsInterestedSuccess -> {
                binding.favorite.setOnClickListener(null)
                binding.favorite.isSelected = true
            }
        }
    }
}