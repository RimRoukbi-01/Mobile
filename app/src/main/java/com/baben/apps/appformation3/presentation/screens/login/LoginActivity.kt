package com.baben.apps.appformation3.presentation.screens.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivityLoginBinding
import com.baben.apps.appformation3.presentation.screens.home.HomeActivity
import com.baben.apps.appformation3.presentation.screens.signup.SignupActivity
import okhttp3.internal.cache.DiskLruCache.Editor

class LoginActivity : BaseActivities() {

    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActions()
        login()
    }

    private fun setupActions() {
        binding.uiLoginButton.setOnClickListener(::onLoginButtonClicked)
        binding.uiSignupButton.setOnClickListener(::onSignupButtonClicked)
    }

    private fun onLoginButtonClicked(view: View?) {
       // TODO("implement real login action")
        startActivity(Intent(context, HomeActivity::class.java))
        finish()
    }

    private fun onSignupButtonClicked(view: View?) {
        startActivity(Intent(context, SignupActivity::class.java))
    }

public fun login(){
     sharedPreferences = getSharedPreferences("nom_pref", Context.MODE_PRIVATE)
    val intent = Intent(this@LoginActivity, SignupActivity::class.java)
  if(sharedPreferences.contains("username")&&sharedPreferences.contains("password") ){
    startActivity(intent);
}
  binding.uiLoginButton.setOnClickListener{

      var username:String=binding.username.text.toString();
      var password:String=binding.password.text.toString();

      if(username.equals("souad")&&password.equals("123")){
          val editor: SharedPreferences.Editor = sharedPreferences.edit()
          editor.putString("username",username)
         editor.putString("password",password)
          editor.commit()
          startActivity(intent)
          Toast.makeText(this@LoginActivity,"login successfuly",Toast.LENGTH_LONG)

      }
      else{
          Toast.makeText(this@LoginActivity,"login failed",Toast.LENGTH_LONG)

      }
}


}






}