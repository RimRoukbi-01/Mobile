package com.baben.apps.appformation3.presentation.screens.splash

import android.annotation.SuppressLint
import android.content.Context
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        delayedSplash()
    }

    private fun delayedSplash() {
        Handler(Looper.getMainLooper()).postDelayed(
            { displayNextScreen() },
            AppConfig.SPLASH_DELAY_MILLIS
        )
    }

    private fun displayNextScreen() {
        if (isLoggedIn()) {
            navigateToHome()
        } else {
            navigateToLogin()
        }
        finish()
    }

    private fun isLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        return sharedPreferences.contains("user_id")
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}