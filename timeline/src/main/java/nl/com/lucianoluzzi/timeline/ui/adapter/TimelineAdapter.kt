package nl.com.lucianoluzzi.timeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import nl.com.lucianoluzzi.core.domain.Message
import nl.com.lucianoluzzi.timeline.R
import nl.com.lucianoluzzi.timeline.databinding.ViewMessageItemBinding

class TimelineAdapter(
    private val onClickListener: (message: Message) -> Unit
) : PagingDataAdapter<Message, TimelineAdapter.TimelineViewHolder>(DIFF_UTIL) {

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
            description.text =
                HtmlCompat.fromHtml(message.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
            favorite.isSelected = message.isInterested
            message.image?.let {
                image.load(it) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }
            binding.root.setOnClickListener {
                onClickListener(message)
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