package nl.com.lucianoluzzi.timeline.domain

data class Message(
    val id: String,
    val title: String,
    val description: String,
    val isInterested: Boolean,
    val image: String? = null
)
