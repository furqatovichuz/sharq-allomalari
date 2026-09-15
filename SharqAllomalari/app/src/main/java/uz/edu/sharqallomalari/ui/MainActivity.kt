package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import uz.edu.sharqallomalari.R
import uz.edu.sharqallomalari.adapter.ScholarAdapter
import uz.edu.sharqallomalari.data.FavoritesManager
import uz.edu.sharqallomalari.data.ScholarRepository
import uz.edu.sharqallomalari.databinding.ActivityMainBinding
import uz.edu.sharqallomalari.model.Scholar
import uz.edu.sharqallomalari.model.ScholarCategory

/**
 * Ilovaning asosiy ekrani: barcha allomalar ro'yxati, qidiruv maydoni
 * va soha bo'yicha filtr chip'lari shu yerda joylashgan.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var favoritesManager: FavoritesManager
    private lateinit var adapter: ScholarAdapter

    private var selectedCategory: ScholarCategory? = null
    private var currentQuery: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoritesManager = FavoritesManager(this)

        setSupportActionBar(binding.toolbar)

        setupRecyclerView()
        setupSearch()
        setupFilterChips()

        applyFilters()
    }

    override fun onResume() {
        super.onResume()
        // Saralanganlar ekranidan qaytganda yulduzcha holatlari yangilanishi uchun.
        adapter.notifyDataSetChanged()
    }

    private fun setupRecyclerView() {
        adapter = ScholarAdapter(
            favoritesManager = favoritesManager,
            onItemClick = { scholar -> openDetail(scholar) },
            onFavoriteToggle = { scholar -> toggleFavorite(scholar) }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                currentQuery = s?.toString().orEmpty()
                binding.btnClearSearch.visibility =
                    if (currentQuery.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
                applyFilters()
            }
        })

        binding.btnClearSearch.setOnClickListener {
            binding.etSearch.setText("")
        }
    }

    private fun setupFilterChips() {
        val chipCategoryMap = mapOf(
            binding.chipAll.id to null,
            binding.chipAstronomy.id to ScholarCategory.ASTRONOMY,
            binding.chipMathematics.id to ScholarCategory.MATHEMATICS,
            binding.chipMedicine.id to ScholarCategory.MEDICINE,
            binding.chipHistory.id to ScholarCategory.HISTORY,
            binding.chipState.id to ScholarCategory.STATE
        )

        binding.chipGroupFilters.setOnCheckedStateChangeListener { group, checkedIds ->
            val checkedId = checkedIds.firstOrNull() ?: group.findViewById<Chip>(binding.chipAll.id)?.id
            selectedCategory = chipCategoryMap[checkedId]
            applyFilters()
        }
    }

    private fun applyFilters() {
        val byCategory = ScholarRepository.getByCategory(selectedCategory)
        val result = if (currentQuery.isBlank()) {
            byCategory
        } else {
            val q = currentQuery.trim().lowercase()
            byCategory.filter {
                it.fullName.lowercase().contains(q) ||
                    it.shortName.lowercase().contains(q) ||
                    it.academy.lowercase().contains(q) ||
                    it.categories.any { c -> c.displayName.lowercase().contains(q) }
            }
        }

        adapter.submitList(result)
        binding.tvCount.text = getString(R.string.scholars_count_format, result.size)
        binding.emptyState.visibility =
            if (result.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        binding.recyclerView.visibility =
            if (result.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
    }

    private fun openDetail(scholar: Scholar) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_SCHOLAR_ID, scholar.id)
        startActivity(intent)
    }

    private fun toggleFavorite(scholar: Scholar) {
        favoritesManager.toggleFavorite(scholar.id)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorites -> {
                startActivity(Intent(this, FavoritesActivity::class.java))
                true
            }
            R.id.action_observatories -> {
                startActivity(Intent(this, ObservatoriesActivity::class.java))
                true
            }
            R.id.action_topics -> {
                startActivity(Intent(this, TopicsActivity::class.java))
                true
            }
            R.id.action_quiz -> {
                startActivity(Intent(this, QuizActivity::class.java))
                true
            }
            R.id.action_glossary -> {
                startActivity(Intent(this, GlossaryActivity::class.java))
                true
            }
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
