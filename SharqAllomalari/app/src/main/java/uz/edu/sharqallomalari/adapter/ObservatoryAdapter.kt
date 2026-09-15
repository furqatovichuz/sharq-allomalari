package uz.edu.sharqallomalari.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.edu.sharqallomalari.databinding.ItemObservatoryBinding
import uz.edu.sharqallomalari.model.Observatory

/**
 * Rasadxonalar ro'yxatini ko'rsatish uchun RecyclerView adapteri.
 */
class ObservatoryAdapter(
    private val items: List<Observatory>,
    private val onItemClick: (Observatory) -> Unit
) : RecyclerView.Adapter<ObservatoryAdapter.ObservatoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ObservatoryViewHolder {
        val binding = ItemObservatoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ObservatoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObservatoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ObservatoryViewHolder(
        private val binding: ItemObservatoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(observatory: Observatory) {
            binding.tvName.text = observatory.name
            binding.tvLocation.text = "${observatory.location} • ${observatory.period}"
            binding.tvShortDesc.text = observatory.shortDesc
            binding.colorStripe.setBackgroundColor(Color.parseColor(observatory.colorHex))

            binding.root.setOnClickListener { onItemClick(observatory) }
        }
    }
}
