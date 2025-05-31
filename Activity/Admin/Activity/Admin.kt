package com.example.adminshabu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Admin(
    @Expose
    @SerializedName("id_admin") val id_admin:String,

    @Expose
    @SerializedName("admin_email") val admin_email: String,

    @Expose
    @SerializedName("admin_name") val admin_name: String,

    @Expose
    @SerializedName("admin_password") val admin_password: String,




){}
