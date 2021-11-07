package nl.com.lucianoluzzi.timeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import nl.com.lucianoluzzi.timeline.databinding.ViewMessageItemBinding
import nl.com.lucianoluzzi.timeline.domain.Message

class TimelineAdapter : PagingDataAdapter<Message, TimelineAdapter.TimelineViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewMessageItemBinding.inflate(layoutInflater, parent, false)
        return TimelineViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setViews(it)
        }
    }

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

    private companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(oldItem: Message, newItem: Message) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.description == newItem.description &&
                        oldItem.isInterested == newItem.isInterested &&
                        oldItem.image == newItem.image
            }
        }
    }
}