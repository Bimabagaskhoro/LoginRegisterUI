package com.bimabagaskhoro.loginregister.models.login

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequestLogin(

        @SerializedName("password")
        @Expose
        var password: String? = null,

        @SerializedName("email")
        @Expose
        var email: String? = null
): Parcelable
