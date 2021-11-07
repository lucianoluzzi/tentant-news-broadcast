package nl.com.lucianoluzzi.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val id: String,
    val title: String,
    val description: String,
    val isInterested: Boolean,
    val image: String? = null
) : Parcelable
