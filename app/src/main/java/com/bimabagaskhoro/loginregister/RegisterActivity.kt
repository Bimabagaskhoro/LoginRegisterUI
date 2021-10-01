
package com.bimabagaskhoro.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.bimabagaskhoro.loginregister.databinding.ActivityRegisterBinding
import com.bimabagaskhoro.loginregister.models.register.RequestRegister
import com.bimabagaskhoro.loginregister.models.ResponseRegister
import com.bimabagaskhoro.loginregister.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonRegister.setOnClickListener {
                register()
            }
            tvLogin.setOnClickListener {
                val tvLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(tvLogin)
            }
        }
    }

    private fun register() {
        val edtName: EditText = findViewById(R.id.name)
        val edtEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val edtOcc: EditText = findViewById(R.id.editOccupation)
        val edtPass: EditText = findViewById(R.id.editTextTextPassword)
        val data = RequestRegister()
        data.name = edtName.text.toString()
        data.email = edtEmail.text.toString()
        data.occupation = edtOcc.text.toString()
        data.password = edtPass.text.toString()
        RetrofitClient().apiInstance().registerUser(data)
                .enqueue(object : Callback<ResponseRegister>{
                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                        ) {
                            if (response.isSuccessful){
                                Toast.makeText(this@RegisterActivity, "Respon sukses", Toast.LENGTH_SHORT).show()
                            }
                        }

                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                        Toast.makeText(this@RegisterActivity, "Reponse Gagal : $t", Toast.LENGTH_LONG).show()
                    }

                })
    }

}