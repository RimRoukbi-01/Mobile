package com.baben.apps.appformation3.presentation.screens.login


import android.view.WindowInsetsAnimation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baben.apps.appformation3.data.remote.repositories.ApiLoginRepository
import com.baben.apps.appformation3.domain.models.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel  : ViewModel(){
    private val userService = RetrofitClient.userService
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult
    fun login1(username: String, password: String) {
        userService.loginClient(username, password).enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                _loginResult.value = response.isSuccessful
            }
            override fun onFailure(call: Call<Login>, t: Throwable) {
            }
        })
    }




}