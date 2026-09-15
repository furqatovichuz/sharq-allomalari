package uz.edu.sharqallomalari.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.edu.sharqallomalari.databinding.ActivityAboutBinding

/**
 * Ilova, uning maqsadi va foydalanilgan ilmiy manba haqida qisqacha
 * ma'lumot beruvchi statik ekran.
 */
class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}
