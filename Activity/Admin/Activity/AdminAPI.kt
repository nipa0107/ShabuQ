package com.example.adminshabu

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface AdminAPI {
    @GET("allregister")
    fun retrieveStudent(): Call<List<Admin>>

    @FormUrlEncoded
    @POST("loginAdmin")
    fun login(
        @Field("admin_email") admin_email: String,
        @Field("admin_password") admin_password: String): Call<Admin>

    @PUT("editProfile/{id_admin}")
    @FormUrlEncoded
    fun editProfile(
        @Path("id_admin") id_admin: Int,
        @Field("admin_name") admin_name: String,
        @Field("admin_email") admin_email: String,
        @Field("admin_password") admin_password: String
    ): Call<Admin>


//    @GET("alltable/{id_desk}")
//    fun retrieveTable(@Path("id_desk_type") id_desk_type: Int,
//                      @Path("admin_id_admin") admin_id_admin: Int,
//                      @Path("id_desk_status") id_desk_status: Int): Call<List<Table>>
@GET("alltabletype")
fun retrieveType(): Call<List<TableType>>

    @FormUrlEncoded
    @POST("/admin")
    fun addTableType(
        @Field("type_name") type_name: String,
        @Field("id_admin") id_admin: Int): Call<TableType>

    @PUT("table/{dask_id}")
    fun edittable(
        @Field("id_desk") id_desk: Int,
        @Field("desk_no") desk_no: String,
        @Field("id_desk_type") id_desk_type: Int,
        @Field("admin_id_admin") admin_id_admin: String,
        @Field("id_desk_status") id_desk_status: String): Call<Admin>

//    companion object{
//        fun create():AdminAPI{
//            val AdminClient: AdminAPI = Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(AdminAPI::class.java)
//            return  AdminClient
//        }
//    }

}