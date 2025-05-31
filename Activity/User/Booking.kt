package com.example.finalproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Booking(
    @Expose
    @SerializedName("id_booking ") val id_booking : Int,

    @Expose
    @SerializedName("booking_seats") val booking_seats: Int,

    @Expose
    @SerializedName("booking_status") val booking_status: String,
    @Expose
    @SerializedName("booking_name") val booking_name: String,
//    @Expose
//    @SerializedName("booking_code") val booking_code: String,

    @Expose
    @SerializedName("id_user") val id_user: Int,

    @Expose
    @SerializedName("id_type") val id_type: Int
){}

