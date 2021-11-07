package nl.com.lucianoluzzi.timeline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import nl.com.lucianoluzzi.design.ItemMarginDecorator
import nl.com.lucianoluzzi.navigation.Navigator
import nl.com.lucianoluzzi.timeline.databinding.FragmentTimelineBinding
import nl.com.lucianoluzzi.timeline.ui.adapter.TimelineAdapter

class TimelineFragment(
    private val navigator: Navigator,
    private val viewModel: TimelineViewModel
) : Fragment() {
    private val binding by lazy {
        val layoutInflater = LayoutInflater.from(requireContext())
        FragmentTimelineBinding.inflate(layoutInflater)
    }
    private val timelineAdapter = TimelineAdapter { message ->
        navigator.navigateToMessage(
            fragment = this,
            message = message
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pagingData.collect { pagingData ->
                timelineAdapter.submitData(pagingData)
            }
        }
    }

    private fun setList() = with(binding) {
        if (messages.itemDecorationCount == 0) {
            messages.addItemDecoration(ItemMarginDecorator(16))
        }
        messages.adapter = timelineAdapter
    }
}