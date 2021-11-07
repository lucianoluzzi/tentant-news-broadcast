package nl.com.lucianoluzzi.timeline.domain.mapper

import nl.com.lucianoluzzi.timeline.data.response.MessageResponse
import nl.com.lucianoluzzi.timeline.domain.Message

class MessageMapper {
    fun messageResponseToDomain(messageResponse: MessageResponse) = Message(
        id = messageResponse.id,
        title = messageResponse.title,
        description = messageResponse.content,
        isInterested = messageResponse.isInterested,
        image = messageResponse.image.firstOrNull()?.url ?: messageResponse.company.logo
    )
}