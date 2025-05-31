package com.example.finalproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("id_user") val id_user: Int,

    @Expose
    @SerializedName("user_name") val user_name: String,

    @Expose
    @SerializedName("user_password") val user_password: String,

    @Expose
    @SerializedName("user_email") val user_email: String,

    @Expose
    @SerializedName("tel") val tel: String
){}
