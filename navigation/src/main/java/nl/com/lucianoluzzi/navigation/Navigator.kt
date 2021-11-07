package nl.com.lucianoluzzi.navigation

import androidx.fragment.app.Fragment
import nl.com.lucianoluzzi.core.domain.Message

interface Navigator {
    fun navigateToMessage(
        fragment: Fragment,
        message: Message
    )

    companion object {
        const val MESSAGE_ARGUMENT_KEY = "message"
    }
}