package com.bimabagaskhoro.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import com.bimabagaskhoro.loginregister.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonLogin.setOnClickListener(this@LoginActivity)
            tvCreateAccount.setOnClickListener(this@LoginActivity)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_login -> {
                val btnLogin = Intent(this, MainActivity::class.java)
                startActivity(btnLogin)
            }
            R.id.tv_create_account -> {
                val btnCreate = Intent(this, RegisterActivity::class.java)
                startActivity(btnCreate)
            }
        }
    }
}