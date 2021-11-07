package nl.com.lucianoluzzi.navigationimpl

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nl.com.lucianoluzzi.core.domain.Message
import nl.com.lucianoluzzi.navigation.Navigator
import nl.com.lucianoluzzi.timeline.ui.TimelineFragmentDirections

class NavigatorImpl : Navigator {

    override fun navigateToMessage(
        fragment: Fragment,
        message: Message
    ) {
        val navController = fragment.findNavController()
        val toMessageFragment =
            TimelineFragmentDirections.actionTimelineFragmentToMessageFragment(
                message = message
            )
        navController.navigate(toMessageFragment)
    }
}