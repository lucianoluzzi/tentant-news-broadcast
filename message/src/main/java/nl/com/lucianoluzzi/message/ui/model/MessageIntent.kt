package nl.com.lucianoluzzi.message.ui.model

sealed class MessageIntent {
    data class OnIsInterestedClicked(
        val messageId: String
    ) : MessageIntent()
}
