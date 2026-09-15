package uz.edu.sharqallomalari.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

/**
 * Ilova ishga tushganda qisqa muddat ko'rsatiladigan boshlang'ich ekran.
 * Android 12 dan oldingi qurilmalarda ham androidx.core.splashscreen
 * kutubxonasi yordamida bir xil ko'rinish ta'minlanadi.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
