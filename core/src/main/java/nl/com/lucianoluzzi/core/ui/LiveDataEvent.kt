package nl.com.lucianoluzzi.core.ui

open class LiveDataEvent<out T>(private val content: T) {

    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

val <T : Any> T.asLiveDataEvent: LiveDataEvent<T>
    get() = LiveDataEvent(this)
