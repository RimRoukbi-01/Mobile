package com.baben.apps.appformation3.presentation.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.baben.apps.appformation3.core.app.AppConfig
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivitySplashBinding
import com.baben.apps.appformation3.presentation.screens.home.HomeActivity
import com.baben.apps.appformation3.presentation.screens.login.LoginActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivities() {

    private lateinit var binding: ActivitySplashBinding
    private val sharedPreferences by lazy { getSharedPreferences("user_data", MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNextScreen()
    }


    override fun onResume() {
        super.onResume()
        delayedSplash()
    }

    private fun delayedSplash() {
        Handler(Looper.getMainLooper()).postDelayed(
            { this.displayNextScreen() },
            AppConfig.SPLASH_DELAY_MILLIS
        )
    }

    private fun displayNextScreen() {
        val isLoggedIn = isUserLoggedIn()
        val intent = Intent(this, if (isLoggedIn) HomeActivity::class.java else LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val accessToken = sharedPreferences.getString("access_token", null)
        return !accessToken.isNullOrEmpty()
    }
}
