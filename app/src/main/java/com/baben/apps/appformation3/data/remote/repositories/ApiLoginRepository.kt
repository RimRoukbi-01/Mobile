package com.baben.apps.appformation3.data.remote.repositories

import android.app.VoiceInteractor
import com.baben.apps.appformation3.domain.models.Login
import com.baben.apps.appformation3.domain.repositories.LoginRepository
import okhttp3.FormBody
import okhttp3.OkHttpClient
import retrofit2.Call

class ApiLoginRepository : LoginRepository {

    override  fun login(model: Login?): LoginRepository.LoginResult? {
        TODO("Not yet implemented")


}

    override fun loginClient(username: String, password: String): Call<Login> {
        TODO("Not yet implemented")
    }

}

