package nl.com.lucianoluzzi.timeline.data.service

import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.timeline.data.response.MessageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TimelineService {

    @GET("companies/{communityId}/timeline")
    suspend fun getTimeline(
        @Path("communityId") communityId: String = DEFAULT_COMMUNITY_ID,
        @Query("from") fromReference: Int? = null,
        @Query("to") toReference: Int? = null
    ): List<MessageResponse>

    private companion object {
        private const val DEFAULT_COMMUNITY_ID = "111618919772361606"
    }
}