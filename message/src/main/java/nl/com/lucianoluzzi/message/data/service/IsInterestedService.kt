package nl.com.lucianoluzzi.message.data.service

import retrofit2.Response
import retrofit2.http.PUT
import retrofit2.http.Path

interface IsInterestedService {
    @PUT("messages/{msg_id}/interested")
    suspend fun setAsInterested(@Path("msg_id") messageId: String): Response<Unit>
}