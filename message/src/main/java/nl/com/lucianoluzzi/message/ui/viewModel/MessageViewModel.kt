package nl.com.lucianoluzzi.message.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nl.com.lucianoluzzi.core.ui.LiveDataEvent
import nl.com.lucianoluzzi.core.ui.asLiveDataEvent
import nl.com.lucianoluzzi.message.data.repository.MessageRepository
import nl.com.lucianoluzzi.message.ui.model.MessageEvents
import nl.com.lucianoluzzi.message.ui.model.MessageIntent
import nl.com.lucianoluzzi.network.Response

class MessageViewModel(
    private val messageRepository: MessageRepository
) : ViewModel() {
    private val _messageEventLiveData = MutableLiveData<LiveDataEvent<MessageEvents>>()
    val messageEventLiveData: LiveData<LiveDataEvent<MessageEvents>> = _messageEventLiveData

    fun onIntent(messageIntent: MessageIntent) {
        when (messageIntent) {
            is MessageIntent.OnIsInterestedClicked -> handleIsInterestedClick(messageIntent.messageId)
        }
    }

    private fun handleIsInterestedClick(messageId: String) {
        viewModelScope.launch {
            val response = messageRepository.setAsInterested(messageId)
            when (response) {
                Response.Completed -> _messageEventLiveData.value =
                    MessageEvents.IsInterestedSuccess.asLiveDataEvent
                is Response.Error -> _messageEventLiveData.value =
                    MessageEvents.IsInterestedError.asLiveDataEvent
            }
        }
    }
}