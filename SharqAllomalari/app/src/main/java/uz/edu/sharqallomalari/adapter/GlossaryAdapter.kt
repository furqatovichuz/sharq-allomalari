package uz.edu.sharqallomalari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.edu.sharqallomalari.databinding.ItemGlossaryTermBinding
import uz.edu.sharqallomalari.model.GlossaryTerm

/**
 * Atamalar lug'atini ko'rsatish uchun RecyclerView adapteri.
 */
class GlossaryAdapter(
    private val items: List<GlossaryTerm>
) : RecyclerView.Adapter<GlossaryAdapter.GlossaryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): GlossaryViewHolder {
        val binding = ItemGlossaryTermBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GlossaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GlossaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class GlossaryViewHolder(
        private val binding: ItemGlossaryTermBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(term: GlossaryTerm) {
            binding.tvTerm.text = term.term
            binding.tvDefinition.text = term.definition
        }
    }
}
