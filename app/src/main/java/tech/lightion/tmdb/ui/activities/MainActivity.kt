package tech.lightion.tmdb.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.lightion.tmdb.R

/**
 * Single activity application, MainActivity is used as Navigation Host for multiple fragments
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
