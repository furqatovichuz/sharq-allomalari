package uz.edu.sharqallomalari.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.data.FavoritesManager
import uz.edu.sharqallomalari.databinding.ItemScholarBinding
import uz.edu.sharqallomalari.model.Scholar
import uz.edu.sharqallomalari.ui.CategoryUi

/**
 * Asosiy va saralanganlar ro'yxatlarida allomalar kartochkalarini
 * ko'rsatish uchun RecyclerView adapteri.
 */
class ScholarAdapter(
    private val favoritesManager: FavoritesManager,
    private val onItemClick: (Scholar) -> Unit,
    private val onFavoriteToggle: (Scholar) -> Unit
) : ListAdapter<Scholar, ScholarAdapter.ScholarViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ScholarViewHolder {
        val binding = ItemScholarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ScholarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScholarViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ScholarViewHolder(
        private val binding: ItemScholarBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(scholar: Scholar) {
            val context = binding.root.context

            binding.ivPortrait.setImageResource(scholar.portraitRes)
            binding.tvName.text = scholar.shortName
            binding.tvYears.text = "${scholar.years} • ${scholar.birthPlace}"
            binding.tvShortBio.text = scholar.shortBio

            val categoryColor = ContextCompat.getColor(
                context, CategoryUi.colorRes(scholar.primaryCategory)
            )
            binding.tvCategory.text = scholar.primaryCategory.displayName
            binding.tvCategory.backgroundTintList = ColorStateList.valueOf(categoryColor)

            val isFavorite = favoritesManager.isFavorite(scholar.id)
            binding.btnFavorite.setImageResource(
                if (isFavorite) R.drawable.ic_star_filled else R.drawable.ic_star_outline
            )

            binding.root.setOnClickListener { onItemClick(scholar) }
            binding.btnFavorite.setOnClickListener { onFavoriteToggle(scholar) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Scholar>() {
            override fun areItemsTheSame(oldItem: Scholar, newItem: Scholar): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Scholar, newItem: Scholar): Boolean =
                oldItem == newItem
        }
    }
}
