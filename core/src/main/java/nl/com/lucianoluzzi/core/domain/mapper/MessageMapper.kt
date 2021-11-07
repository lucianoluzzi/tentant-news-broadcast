package nl.com.lucianoluzzi.core.domain.mapper

import nl.com.lucianoluzzi.core.domain.Message
import nl.com.lucianoluzzi.core.data.response.MessageResponse

class MessageMapper {
    fun messageResponseToDomain(messageResponse: MessageResponse) = Message(
        id = messageResponse.id,
        title = messageResponse.title,
        description = messageResponse.content,
        isInterested = messageResponse.isInterested,
        image = messageResponse.image.firstOrNull()?.url ?: messageResponse.company.logo
    )
}