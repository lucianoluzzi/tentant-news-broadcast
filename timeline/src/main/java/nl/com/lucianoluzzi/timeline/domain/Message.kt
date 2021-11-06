package nl.com.lucianoluzzi.timeline.domain

data class Message(
    val title: String,
    val description: String,
    val isInterested: Boolean,
    val image: String? = null
)
