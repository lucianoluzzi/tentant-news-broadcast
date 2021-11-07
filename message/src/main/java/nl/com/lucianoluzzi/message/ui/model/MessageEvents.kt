package nl.com.lucianoluzzi.message.ui.model

sealed class MessageEvents {
    object IsInterestedError : MessageEvents()
    object IsInterestedSuccess : MessageEvents()
}
