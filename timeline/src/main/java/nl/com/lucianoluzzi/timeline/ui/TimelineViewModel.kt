package nl.com.lucianoluzzi.timeline.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.map
import nl.com.lucianoluzzi.timeline.data.repository.TimelineRepository
import nl.com.lucianoluzzi.timeline.domain.Message

class TimelineViewModel(
    timelineRepository: TimelineRepository
) : ViewModel() {

    val pagingData = timelineRepository.getTimelineStream().map { pagingData ->
        pagingData.map { messageResponse ->
            Message(
                id = messageResponse.id,
                title = messageResponse.title,
                description = messageResponse.content,
                isInterested = messageResponse.isInterested,
                image = messageResponse.image.firstOrNull()?.url ?: messageResponse.company.logo
            )
        }
    }.cachedIn(viewModelScope)
}