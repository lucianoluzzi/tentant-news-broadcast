package nl.com.lucianoluzzi.timeline.data.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import nl.com.lucianoluzzi.core.data.response.MessageResponse
import nl.com.lucianoluzzi.timeline.data.service.TimelineService

class TimelinePagingSource(
    private val timelineService: TimelineService
) : PagingSource<Int, MessageResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MessageResponse>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey ?: anchorPage?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MessageResponse> {
        return try {
            val currentPageReference = params.key
            val timelinePage = timelineService.getTimeline(
                toReference = currentPageReference
            )
            LoadResult.Page(
                data = timelinePage,
                nextKey = getNextPageReference(
                    currentPageReference = currentPageReference,
                    messagesResponse = timelinePage
                ),
                prevKey = currentPageReference
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    private fun getNextPageReference(
        currentPageReference: Int?,
        messagesResponse: List<MessageResponse>
    ): Int? {
        return if (messagesResponse.lastOrNull()?.pagingReference == currentPageReference) {
            null
        } else {
            messagesResponse.lastOrNull()?.pagingReference
        }
    }
}