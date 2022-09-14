package com.example.giupokedex.presentation.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.giupokedex.R

class SplashActivity : AppCompatActivity() {

    private val delayMillis: Long = 1030

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val shared = getSharedPreferences(
            getString(R.string.PREF_APP_NAME),
            Context.MODE_PRIVATE
        )

        shared.edit().putString(getString(R.string.PREF_HISTORIC_SEARCH), null).apply()

        Handler(Looper.getMainLooper()).postDelayed({
            goToHome()
        }, delayMillis)
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}