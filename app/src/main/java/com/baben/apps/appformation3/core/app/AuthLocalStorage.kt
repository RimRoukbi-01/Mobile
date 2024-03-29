package com.baben.apps.appformation3.core.app

import android.content.Context

// gere le stockage de token
class AuthLocalStorage(context: Context) {

    companion object {
        const val SHARD_PREFERENCE_KRY: String = "com.baben.apps.appformation3.core.app.sharedpreference"
    }
    private val sharedPreference = context.getSharedPreferences(SHARD_PREFERENCE_KRY, Context.MODE_PRIVATE)
    fun saveToken(Token: String) {
        TODO("Not yet implemented")
    }
}