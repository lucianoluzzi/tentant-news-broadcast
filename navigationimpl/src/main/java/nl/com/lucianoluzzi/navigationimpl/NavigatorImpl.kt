package nl.com.lucianoluzzi.navigationimpl

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nl.com.lucianoluzzi.navigation.Navigator

class NavigatorImpl : Navigator {

    override fun navigateToMessage(fragment: Fragment) {
        val navController = fragment.findNavController()
        navController.navigate(R.id.messageFragment)
    }
}