package nl.com.lucianoluzzi.timeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import nl.com.lucianoluzzi.timeline.databinding.ViewMessageItemBinding
import nl.com.lucianoluzzi.timeline.domain.Message

class TimelineAdapter(
    private val messages: List<Message>
) : RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewMessageItemBinding.inflate(layoutInflater, parent, false)
        return TimelineViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        holder.setViews(messages[position])
    }

    override fun getItemCount() = messages.size

    inner class TimelineViewHolder(private val binding: ViewMessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setViews(message: Message) = with(binding) {
            title.text = message.title
            description.text = message.description
            favorite.isSelected = message.isInterested
            favorite.setOnClickListener {
                it.isSelected = !it.isSelected
            }
            message.image?.let {
                image.load(it)
            }
        }
    }
}