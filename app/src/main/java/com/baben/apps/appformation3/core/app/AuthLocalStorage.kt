package com.baben.apps.appformation3.core.app

import android.annotation.SuppressLint
import android.content.Context

// gere le stockage de token
class AuthLocalStorage(context: Context) {

    companion object {
        const val TOKEN_KEY: String = "com.baben.apps.appformation3.core.app.tokenKey"
        const val SHARD_PREFERENCE_KEY: String = "com.baben.apps.appformation3.core.app.sharedpreference"
    }
    private val sharedPreference = context.getSharedPreferences(SHARD_PREFERENCE_KEY, Context.MODE_PRIVATE)
    fun saveToken(Token: String) {
        sharedPreference.edit().putString(TOKEN_KEY,Token).apply()
    }

    fun getToken():String {
        return sharedPreference.getString(TOKEN_KEY,"") ?: ""
    }

    @SuppressLint("CommitPrefEdits")
    fun clearToken() {
        sharedPreference.edit().remove(TOKEN_KEY).apply()

    }

    fun isLogged(): Boolean {
      return getToken() != ""
    }
}