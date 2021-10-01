package com.bimabagaskhoro.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.bimabagaskhoro.loginregister.databinding.ActivityLoginBinding
import com.bimabagaskhoro.loginregister.models.login.RequestLogin
import com.bimabagaskhoro.loginregister.models.login.ResponseLogin
import com.bimabagaskhoro.loginregister.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonLogin.setOnClickListener {
                login()
            }
            tvCreateAccount.setOnClickListener {
                val btnCreate = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(btnCreate)
            }
        }
    }

    private fun login() {
        val edtEmail: EditText = findViewById(R.id.edt_email_login)
        val edtPass: EditText = findViewById(R.id.edt_password_login)
        val data = RequestLogin()
        data.email = edtEmail.text.toString()
        data.password = edtPass.text.toString()
        RetrofitClient().apiInstance().loginUser(data)
                .enqueue(object : Callback<ResponseLogin>{
                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                        if (response.isSuccessful){
                            Toast.makeText(this@LoginActivity, "Respon sukses", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Reponse Gagal : $t", Toast.LENGTH_LONG).show()
                    }

                })
    }
}