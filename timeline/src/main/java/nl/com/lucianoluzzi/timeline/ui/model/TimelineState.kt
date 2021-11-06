package nl.com.lucianoluzzi.timeline.ui.model

import nl.com.lucianoluzzi.timeline.domain.Message

sealed class TimelineState {
    object Loading : TimelineState()
    data class Error(val message: String) : TimelineState()
    data class MessageList(val messages: List<Message>) : TimelineState()
}
