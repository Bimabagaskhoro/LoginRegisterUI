package com.bimabagaskhoro.loginregister.rest

import com.bimabagaskhoro.loginregister.models.register.RequestRegister
import com.bimabagaskhoro.loginregister.models.ResponseRegister
import com.bimabagaskhoro.loginregister.models.login.RequestLogin
import com.bimabagaskhoro.loginregister.models.login.ResponseLogin
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("users")
    fun registerUser(
    @Body req: RequestRegister
    ): Call<ResponseRegister>

    @POST("sessions")
    fun loginUser(
            @Body req: RequestLogin
    ): Call<ResponseLogin>
}