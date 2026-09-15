package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.edu.sharqallomalari.adapter.ScholarAdapter
import uz.edu.sharqallomalari.data.FavoritesManager
import uz.edu.sharqallomalari.data.ScholarRepository
import uz.edu.sharqallomalari.databinding.ActivityFavoritesBinding
import uz.edu.sharqallomalari.model.Scholar

/**
 * Foydalanuvchi yulduzcha bilan belgilagan (saralangan) allomalar
 * ro'yxatini ko'rsatuvchi ekran.
 */
class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding
    private lateinit var favoritesManager: FavoritesManager
    private lateinit var adapter: ScholarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoritesManager = FavoritesManager(this)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        adapter = ScholarAdapter(
            favoritesManager = favoritesManager,
            onItemClick = { scholar -> openDetail(scholar) },
            onFavoriteToggle = { scholar -> toggleFavorite(scholar) }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        loadFavorites()
    }

    override fun onResume() {
        super.onResume()
        loadFavorites()
    }

    private fun loadFavorites() {
        val favoriteIds = favoritesManager.getFavoriteIds()
        val favorites = ScholarRepository.scholars.filter { it.id in favoriteIds }
        adapter.submitList(favorites)

        binding.emptyState.visibility =
            if (favorites.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        binding.recyclerView.visibility =
            if (favorites.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
    }

    private fun openDetail(scholar: Scholar) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_SCHOLAR_ID, scholar.id)
        startActivity(intent)
    }

    private fun toggleFavorite(scholar: Scholar) {
        favoritesManager.toggleFavorite(scholar.id)
        loadFavorites()
    }
}
