package nl.com.lucianoluzzi.timeline.data.response

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    val id: String,
    val title: String,
    val content: String,
    val company: CompanyResponse,
    @SerializedName("is_interested") val isInterested: Boolean,
    @SerializedName("attachments") val image: List<AttachmentResponse>,
    @SerializedName("score") val pagingReference: Int
) {
    data class AttachmentResponse(val url: String?)
    data class CompanyResponse(@SerializedName("logo_thumbnail") val logo: String?)
}
