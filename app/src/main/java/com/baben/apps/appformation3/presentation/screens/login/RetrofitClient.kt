package com.baben.apps.appformation3.presentation.screens.login

import com.baben.apps.appformation3.domain.repositories.LoginRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://fakestoreapi.com/auth/login"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val userService: LoginRepository = retrofit.create(LoginRepository::class.java)
}