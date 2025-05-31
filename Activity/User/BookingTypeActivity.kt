package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.ActivityBookingTypeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookingTypeActivity : AppCompatActivity() {
    private lateinit var bindingBookType:ActivityBookingTypeBinding
    var tableTypeList = arrayListOf<TableType>()
    var searchList = arrayListOf<TableType>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBookType = ActivityBookingTypeBinding.inflate(layoutInflater)
        setContentView(bindingBookType.root)

        var data = intent.extras
        var user: UserParcelable? = data?.getParcelable("UserInfo")
        bindingBookType.recyclerView.adapter =
            TableTypeAdapter(searchList, user, applicationContext)
        bindingBookType.recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        bindingBookType.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    var intent = Intent(this@BookingTypeActivity, PromotionActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
                R.id.menu2 -> {
                    var intent = Intent(this@BookingTypeActivity, HomeActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
                R.id.menu3 -> {
                    var intent = Intent(this@BookingTypeActivity, WarnActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
            }
            true
        }

    }

    override fun onResume() {
        super.onResume()
        callFoodProduct()
    }

    fun callFoodProduct(){
        searchList.clear()
        var data = intent.extras
        var user : UserParcelable? = data?.getParcelable("UserInfo")
        var serv = UserAPI.create()
        serv.getalltype()
            .enqueue(object: Callback<List<TableType>> {
                override fun onResponse(
                    call: Call<List<TableType>>,
                    response: Response<List<TableType>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.forEach {
                            tableTypeList.add(TableType(it.id_type, it.type_name, it.id_admin))
                        }
                        searchList.addAll(tableTypeList)
                        bindingBookType.recyclerView.adapter = TableTypeAdapter(searchList, user, applicationContext)
                        bindingBookType.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    }
                }

                override fun onFailure(call: Call<List<TableType>>, t: Throwable) {
                    return t.printStackTrace()
                }

            })
    }

}