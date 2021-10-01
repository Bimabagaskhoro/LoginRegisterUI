package com.bimabagaskhoro.loginregister.models.register

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequestRegister(
	@SerializedName("password")
	@Expose
	var password: String? = null,

	@SerializedName("occupation")
	@Expose
	var occupation: String? = null,

	@SerializedName("name")
	@Expose
	var name: String? = null,

	@SerializedName("email")
	@Expose
	var email: String? = null
) : Parcelable
