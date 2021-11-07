package nl.com.lucianoluzzi.message.data.repository

import nl.com.lucianoluzzi.message.data.service.IsInterestedService
import nl.com.lucianoluzzi.network.Response

class MessageRepositoryImpl(
    private val isInterestedService: IsInterestedService
) : MessageRepository {

    override suspend fun setAsInterested(messageId: String): Response {
        return try {
            val response = isInterestedService.setAsInterested(messageId)
            if (response.code() == 204) {
                Response.Completed
            } else {
                Response.Error(Exception("Error sending the request"))
            }
        } catch (exception: Exception) {
            Response.Error(exception)
        }
    }
}