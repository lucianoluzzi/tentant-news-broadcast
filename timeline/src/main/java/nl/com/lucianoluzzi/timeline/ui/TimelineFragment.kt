package nl.com.lucianoluzzi.timeline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nl.com.lucianoluzzi.design.ItemMarginDecorator
import nl.com.lucianoluzzi.navigation.Navigator
import nl.com.lucianoluzzi.timeline.databinding.FragmentTimelineBinding
import nl.com.lucianoluzzi.timeline.ui.adapter.TimelineAdapter
import nl.com.lucianoluzzi.timeline.ui.model.TimelineState

class TimelineFragment(
    private val navigator: Navigator,
    private val viewModel: TimelineViewModel
) : Fragment() {
    private val binding by lazy {
        val layoutInflater = LayoutInflater.from(requireContext())
        FragmentTimelineBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
        viewModel.timelineState.observe(viewLifecycleOwner) {
            handleState(it)
        }
    }

    private fun setList() = with(binding) {
        if (messages.itemDecorationCount == 0) {
            messages.addItemDecoration(ItemMarginDecorator(16))
        }
    }

    private fun handleState(timelineState: TimelineState) {
        when (timelineState) {
            is TimelineState.Error -> TODO()
            TimelineState.Loading -> TODO()
            is TimelineState.MessageList -> binding.messages.adapter =
                TimelineAdapter(timelineState.messages)
        }
    }
}