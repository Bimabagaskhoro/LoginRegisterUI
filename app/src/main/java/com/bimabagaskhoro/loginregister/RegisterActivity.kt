
package com.bimabagaskhoro.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bimabagaskhoro.loginregister.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonRegister.setOnClickListener(this@RegisterActivity)
            tvLogin.setOnClickListener(this@RegisterActivity)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_register -> {
                Toast.makeText(this,"Registrasi Berhasil",Toast.LENGTH_SHORT).show()
            }
            R.id.tv_login -> {
                val tvLogin = Intent(this, LoginActivity::class.java)
                startActivity(tvLogin)
            }
        }
    }
}