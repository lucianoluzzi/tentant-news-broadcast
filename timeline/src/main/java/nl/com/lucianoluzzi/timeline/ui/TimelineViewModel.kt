package nl.com.lucianoluzzi.timeline.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nl.com.lucianoluzzi.timeline.domain.Message
import nl.com.lucianoluzzi.timeline.ui.model.TimelineState

class TimelineViewModel : ViewModel() {
    private val _timelineState = MutableLiveData<TimelineState>()
    val timelineState: LiveData<TimelineState> = _timelineState

    init {
        _timelineState.value = TimelineState.MessageList(
            listOf(
                Message(
                    title = "Water maintenance",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in libero ipsum. Duis porttitor tempus tortor, vitae maximus lorem vulputate at. Praesent molestie porta lectus, nec dictum justo consequat ac. Morbi at magna a arcu pulvinar sollicitudin. Sed vel dignissim nulla. Phasellus est nibh, scelerisque vel leo et, ultrices bibendum lorem. Praesent blandit ut leo quis varius. Pellentesque vulputate vel ex in ultricies. Maecenas efficitur ex at libero volutpat, vitae hendrerit ligula sollicitudin. Nunc dictum fermentum nisl tempor pulvinar. Suspendisse nisl elit, blandit non neque id, ultrices mollis odio. Vivamus faucibus accumsan mi condimentum ullamcorper. Donec elementum dolor nec dolor vulputate condimentum. Aenean eu lorem sed elit egestas pulvinar eget nec leo. Aenean viverra auctor orci egestas tincidunt. Mauris eu suscipit est.",
                    isInterested = true
                ),
                Message(
                    title = "Light maintenance",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in libero ipsum. Duis porttitor tempus tortor, vitae maximus lorem vulputate at. Praesent molestie porta lectus, nec dictum justo consequat ac. Morbi at magna a arcu pulvinar sollicitudin. Sed vel dignissim nulla. Phasellus est nibh, scelerisque vel leo et, ultrices bibendum lorem. Praesent blandit ut leo quis varius. Pellentesque vulputate vel ex in ultricies. Maecenas efficitur ex at libero volutpat, vitae hendrerit ligula sollicitudin. Nunc dictum fermentum nisl tempor pulvinar. Suspendisse nisl elit, blandit non neque id, ultrices mollis odio. Vivamus faucibus accumsan mi condimentum ullamcorper. Donec elementum dolor nec dolor vulputate condimentum. Aenean eu lorem sed elit egestas pulvinar eget nec leo. Aenean viverra auctor orci egestas tincidunt. Mauris eu suscipit est.",
                    isInterested = false
                ),
                Message(
                    title = "Fire alarm test",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in libero ipsum. Duis porttitor tempus tortor, vitae maximus lorem vulputate at. Praesent molestie porta lectus, nec dictum justo consequat ac. Morbi at magna a arcu pulvinar sollicitudin. Sed vel dignissim nulla. Phasellus est nibh, scelerisque vel leo et, ultrices bibendum lorem. Praesent blandit ut leo quis varius. Pellentesque vulputate vel ex in ultricies. Maecenas efficitur ex at libero volutpat, vitae hendrerit ligula sollicitudin. Nunc dictum fermentum nisl tempor pulvinar. Suspendisse nisl elit, blandit non neque id, ultrices mollis odio. Vivamus faucibus accumsan mi condimentum ullamcorper. Donec elementum dolor nec dolor vulputate condimentum. Aenean eu lorem sed elit egestas pulvinar eget nec leo. Aenean viverra auctor orci egestas tincidunt. Mauris eu suscipit est.",
                    isInterested = false
                ),
                Message(
                    title = "Mice inspection",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in libero ipsum. Duis porttitor tempus tortor, vitae maximus lorem vulputate at. Praesent molestie porta lectus, nec dictum justo consequat ac. Morbi at magna a arcu pulvinar sollicitudin. Sed vel dignissim nulla. Phasellus est nibh, scelerisque vel leo et, ultrices bibendum lorem. Praesent blandit ut leo quis varius. Pellentesque vulputate vel ex in ultricies. Maecenas efficitur ex at libero volutpat, vitae hendrerit ligula sollicitudin. Nunc dictum fermentum nisl tempor pulvinar. Suspendisse nisl elit, blandit non neque id, ultrices mollis odio. Vivamus faucibus accumsan mi condimentum ullamcorper. Donec elementum dolor nec dolor vulputate condimentum. Aenean eu lorem sed elit egestas pulvinar eget nec leo. Aenean viverra auctor orci egestas tincidunt. Mauris eu suscipit est.",
                    isInterested = true
                )
            )
        )
    }
}