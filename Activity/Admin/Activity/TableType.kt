package com.example.adminshabu

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TableType(
    @Expose
    @SerializedName("id_type") val id_type:Int,

    @Expose
    @SerializedName("type_name") val type_name: String,

    @Expose
    @SerializedName("id_admin") val id_admin: Int, ){}
