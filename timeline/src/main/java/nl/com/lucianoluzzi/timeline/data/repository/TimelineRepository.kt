package nl.com.lucianoluzzi.timeline.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.core.data.response.MessageResponse

interface TimelineRepository {

    fun getTimelineStream(): Flow<PagingData<MessageResponse>>
}