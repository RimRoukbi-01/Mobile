package com.baben.apps.appformation3.core.app

import android.content.Context
import android.content.SharedPreferences
// gere le stockage de token
class AuthLocalStorage(private val context: Context) {
    companion object {
        val SHARED_PREFERENCE_KEY="loginpreferences"
    }
    private val sharedPreference = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)


     fun saveToken(token: String?) {
        sharedPreference.edit().putString("token", token).apply()

    }

    fun getToken(): String? {
        return sharedPreference.getString("token", null)
    }

    fun isLoggedIn(): Boolean {
        return getToken() != null

    }

}