package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.data.FavoritesManager
import uz.edu.sharqallomalari.data.ScholarRepository
import uz.edu.sharqallomalari.databinding.ActivityDetailBinding
import uz.edu.sharqallomalari.databinding.ItemAchievementBinding
import uz.edu.sharqallomalari.databinding.ItemChipCategoryBinding
import uz.edu.sharqallomalari.databinding.ItemWorkBinding
import uz.edu.sharqallomalari.model.Scholar

/**
 * Tanlangan allomaning to'liq profili: tarjimai holi, asosiy asarlari,
 * ilmiy yutuqlari va (mavjud bo'lsa) mashhur iqtibosi shu yerda ko'rsatiladi.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var favoritesManager: FavoritesManager
    private lateinit var scholar: Scholar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoritesManager = FavoritesManager(this)

        val scholarId = intent.getIntExtra(EXTRA_SCHOLAR_ID, -1)
        val found = ScholarRepository.getById(scholarId)
        if (found == null) {
            finish()
            return
        }
        scholar = found

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        bindScholar()
        setupFavoriteButton()
        setupShareButton()
    }

    private fun bindScholar() {
        binding.tvHeaderName.text = scholar.shortName
        binding.tvHeaderYears.text = scholar.years
        binding.collapsingToolbar.title = scholar.shortName

        binding.ivAvatar.setImageResource(scholar.portraitRes)

        binding.tvBirthPlace.text = scholar.birthPlace
        binding.tvAcademy.text = scholar.academy

        if (scholar.honorTitle != null) {
            binding.tvHonorTitle.text = "\u201C${scholar.honorTitle}\u201D"
            binding.tvHonorTitle.visibility = android.view.View.VISIBLE
        } else {
            binding.tvHonorTitle.visibility = android.view.View.GONE
        }

        binding.tvBiography.text = scholar.biography

        binding.chipGroupCategories.removeAllViews()
        scholar.categories.forEach { category ->
            val chipBinding = ItemChipCategoryBinding.inflate(
                LayoutInflater.from(this), binding.chipGroupCategories, false
            )
            val chip: Chip = chipBinding.root
            chip.text = category.displayName
            chip.chipBackgroundColor = android.content.res.ColorStateList.valueOf(
                ContextCompat.getColor(this, CategoryUi.colorRes(category))
            )
            binding.chipGroupCategories.addView(chip)
        }

        binding.containerWorks.removeAllViews()
        scholar.works.forEach { workText ->
            val itemBinding = ItemWorkBinding.inflate(
                LayoutInflater.from(this), binding.containerWorks, false
            )
            itemBinding.tvText.text = workText
            binding.containerWorks.addView(itemBinding.root)
        }

        binding.containerAchievements.removeAllViews()
        scholar.achievements.forEach { achievementText ->
            val itemBinding = ItemAchievementBinding.inflate(
                LayoutInflater.from(this), binding.containerAchievements, false
            )
            itemBinding.tvText.text = achievementText
            binding.containerAchievements.addView(itemBinding.root)
        }

        if (scholar.quote != null) {
            binding.containerQuote.visibility = android.view.View.VISIBLE
            binding.tvQuote.text = "\u201C${scholar.quote}\u201D"
        } else {
            binding.containerQuote.visibility = android.view.View.GONE
        }
    }

    private fun setupFavoriteButton() {
        updateFavoriteIcon()
        binding.btnFavorite.setOnClickListener {
            favoritesManager.toggleFavorite(scholar.id)
            updateFavoriteIcon()
        }
    }

    private fun updateFavoriteIcon() {
        val isFavorite = favoritesManager.isFavorite(scholar.id)
        binding.btnFavorite.setImageResource(
            if (isFavorite) R.drawable.ic_star_filled else R.drawable.ic_star_outline
        )
    }

    private fun setupShareButton() {
        binding.btnShare.setOnClickListener {
            val shareText = getString(
                R.string.share_template,
                scholar.fullName,
                scholar.years,
                scholar.shortBio
            )
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(sendIntent, getString(R.string.action_share)))
        }
    }

    companion object {
        const val EXTRA_SCHOLAR_ID = "extra_scholar_id"
    }
}
