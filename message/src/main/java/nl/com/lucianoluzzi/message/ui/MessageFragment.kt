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

class MessageFragment : Fragment() {
    private val binding by lazy {
        val layoutInflater = LayoutInflater.from(requireContext())
        FragmentMessageBinding.inflate(layoutInflater)
    }
    private val message by lazy<Message?> {
        requireArguments().getParcelable("message")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
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
            message.image?.let {
                image.load(it) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }
        }
    }
}