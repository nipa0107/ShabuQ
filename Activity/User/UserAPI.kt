package com.example.finalproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface UserAPI {
    @GET("allregister")
    fun retrieveStudent(): Call<List<User>>

    @GET("getalltype")
    fun getalltype(): Call<List<TableType>>

    @FormUrlEncoded
    @POST("register")
    fun insertRegister(

        @Field("user_name") user_name: String,
        @Field("user_password") user_password: String,
        @Field("user_email") user_email: String,
        @Field("tel") tel: String): Call<User>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
       @Field("user_email") user_email: String,
        @Field("user_password") user_password: String):Call<User>

    @PUT("/user/{id_user}")
    @FormUrlEncoded
    fun editProfile(
        @Path("id_user") id_user: Int,
        @Field("user_name") user_name: String,
        @Field("user_email") user_email: String,
        @Field("tel") tel: String): Call<User>

    @POST("Addbooking")
    @FormUrlEncoded
    fun createbooking(
        @Field("id_type") id_type: Int,
//        @Path("id_booking") id_booking:Int,
        @Field("booking_seats")	booking_seats: Int,
        @Field("booking_name") booking_name: String,
//        @Field("booking_code") booking_code: String,
        @Field("id_user") id_user: Int
    ): Call<Booking>


    companion object{
        fun create():UserAPI{
            val userClient: UserAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserAPI::class.java)
            return  userClient
        }
   }
}