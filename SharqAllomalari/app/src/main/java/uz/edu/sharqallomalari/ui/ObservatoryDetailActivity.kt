package uz.edu.sharqallomalari.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import uz.edu.sharqallomalari.data.ObservatoryRepository
import uz.edu.sharqallomalari.databinding.ActivityObservatoryDetailBinding
import uz.edu.sharqallomalari.databinding.ItemAchievementBinding

/**
 * Tanlangan rasadxonaning to'liq tavsifi, asosiy faktlari va u yerda
 * faoliyat yuritgan olimlar haqida ma'lumot ko'rsatadigan ekran.
 */
class ObservatoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservatoryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObservatoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val observatoryId = intent.getIntExtra(EXTRA_OBSERVATORY_ID, -1)
        val observatory = ObservatoryRepository.getById(observatoryId)
        if (observatory == null) {
            finish()
            return
        }

        binding.toolbar.title = observatory.name
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.colorHeader.setBackgroundColor(Color.parseColor(observatory.colorHex))
        binding.tvName.text = observatory.name
        binding.tvLocation.text = observatory.location
        binding.tvPeriod.text = observatory.period
        binding.tvDescription.text = observatory.description
        binding.tvScholars.text = observatory.scholars

        binding.containerFacts.removeAllViews()
        observatory.keyFacts.forEach { fact ->
            val itemBinding = ItemAchievementBinding.inflate(
                LayoutInflater.from(this), binding.containerFacts, false
            )
            itemBinding.tvText.text = fact
            binding.containerFacts.addView(itemBinding.root)
        }
    }

    companion object {
        const val EXTRA_OBSERVATORY_ID = "extra_observatory_id"
    }
}
