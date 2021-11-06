package nl.com.lucianoluzzi.navigation

import androidx.fragment.app.Fragment

interface Navigator {
    fun navigateToMessage(fragment: Fragment)
}