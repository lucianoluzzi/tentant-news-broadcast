package nl.com.lucianoluzzi.timeline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nl.com.lucianoluzzi.navigation.Navigator
import nl.com.lucianoluzzi.timeline.databinding.FragmentTimelineBinding

class TimelineFragment(
    private val navigator: Navigator
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
        binding.nessageButton.setOnClickListener {
            navigator.navigateToMessage(this)
        }
    }
}