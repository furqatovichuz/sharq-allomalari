package uz.edu.sharqallomalari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.edu.sharqallomalari.databinding.ItemTopicBinding
import uz.edu.sharqallomalari.model.Topic

/**
 * "Mavzular" bo'limidagi mavzular ro'yxatini ko'rsatish uchun
 * RecyclerView adapteri.
 */
class TopicAdapter(
    private val items: List<Topic>,
    private val onItemClick: (Topic) -> Unit
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class TopicViewHolder(
        private val binding: ItemTopicBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(topic: Topic) {
            binding.tvNumber.text = topic.id.toString()
            binding.tvTitle.text = topic.title
            binding.root.setOnClickListener { onItemClick(topic) }
        }
    }
}
