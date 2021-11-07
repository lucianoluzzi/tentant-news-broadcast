package nl.com.lucianoluzzi.timeline.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.map
import nl.com.lucianoluzzi.timeline.data.repository.TimelineRepository
import nl.com.lucianoluzzi.core.domain.mapper.MessageMapper

class TimelineViewModel(
    timelineRepository: TimelineRepository,
    messageMapper: MessageMapper
) : ViewModel() {

    val pagingData = timelineRepository.getTimelineStream().map { pagingData ->
        pagingData.map { messageResponse ->
            messageMapper.messageResponseToDomain(messageResponse)
        }
    }.cachedIn(viewModelScope)
}