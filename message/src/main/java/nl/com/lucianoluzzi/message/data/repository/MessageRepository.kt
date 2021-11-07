package nl.com.lucianoluzzi.message.data.repository

import nl.com.lucianoluzzi.network.Response

interface MessageRepository {
    suspend fun setAsInterested(messageId: String): Response
}