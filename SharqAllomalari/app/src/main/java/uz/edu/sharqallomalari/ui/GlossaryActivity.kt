package uz.edu.sharqallomalari.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.edu.sharqallomalari.adapter.GlossaryAdapter
import uz.edu.sharqallomalari.data.GlossaryRepository
import uz.edu.sharqallomalari.databinding.ActivityGlossaryBinding

/**
 * Astronomiya va Sharq ilmiy merosiga oid asosiy atamalar ro'yxatini
 * ko'rsatuvchi ekran.
 */
class GlossaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGlossaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlossaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = GlossaryAdapter(GlossaryRepository.terms)
    }
}
