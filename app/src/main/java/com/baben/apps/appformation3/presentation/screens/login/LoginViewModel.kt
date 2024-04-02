package com.baben.apps.appformation3.presentation.screens.login
import android.content.Context
import androidx.lifecycle.ViewModel
import com.baben.apps.appformation3.core.app.AuthLocalStorage


class LoginViewModel(context: Context)  : ViewModel(){
    companion object {
        const val TOKEN_KEY: String = "com.baben.apps.appformation3.core.app.tokenKey"
        const val SHARD_PREFERENCE_KEY: String = "com.baben.apps.appformation3.core.app.sharedpreference"
    }
    private val sharedPreference = context.getSharedPreferences(SHARD_PREFERENCE_KEY, Context.MODE_PRIVATE)
    fun ValidUserName(username: String): Boolean {
       return true
    }










}