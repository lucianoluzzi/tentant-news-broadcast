package nl.com.lucianoluzzi.timeline.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.timeline.data.dataSource.TimelinePagingSource
import nl.com.lucianoluzzi.core.data.response.MessageResponse
import nl.com.lucianoluzzi.timeline.data.service.TimelineService

class TimelineRepositoryImpl(
    private val service: TimelineService
) : TimelineRepository {

    override fun getTimelineStream(): Flow<PagingData<MessageResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                TimelinePagingSource(service)
            }
        ).flow
    }

    private companion object {
        private const val PAGE_SIZE = 30
    }
}