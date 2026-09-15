package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.edu.sharqallomalari.adapter.ObservatoryAdapter
import uz.edu.sharqallomalari.data.ObservatoryRepository
import uz.edu.sharqallomalari.databinding.ActivityObservatoriesBinding
import uz.edu.sharqallomalari.model.Observatory

/**
 * Bog'dod, Xorazm, Samarqand, Toshkent va Maydanak rasadxonalari
 * ro'yxatini ko'rsatuvchi ekran.
 */
class ObservatoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservatoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObservatoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val adapter = ObservatoryAdapter(ObservatoryRepository.observatories) { observatory ->
            openDetail(observatory)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun openDetail(observatory: Observatory) {
        val intent = Intent(this, ObservatoryDetailActivity::class.java)
        intent.putExtra(ObservatoryDetailActivity.EXTRA_OBSERVATORY_ID, observatory.id)
        startActivity(intent)
    }
}
