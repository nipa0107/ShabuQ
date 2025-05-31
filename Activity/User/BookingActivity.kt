package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.databinding.ActivityBookingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookingActivity : AppCompatActivity() {
    private lateinit var bindingBooking: ActivityBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBooking = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(bindingBooking.root)
        var data = intent.extras
        var user: UserParcelable? = data?.getParcelable("UserInfo")
        var type : TableTypeParcelable? = data?.getParcelable("typeData")

        bindingBooking.menuName.text = type?.type_name
        bindingBooking.btnConfirm.setOnClickListener {
            createbooking()
        }
//        bindingBooking.btnCode.setOnClickListener {
//            bindingBooking.edtCode.setText(randomCode(4))
//
//        }
        bindingBooking.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    var intent = Intent(this@BookingActivity, PromotionActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
                R.id.menu2 -> {
                    var intent = Intent(this@BookingActivity, HomeActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
                R.id.menu3 -> {
                    var intent = Intent(this@BookingActivity, WarnActivity::class.java)
                    intent.putExtra("UserInfo", user)
                    startActivity(intent)
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        bindingBooking.add.setOnClickListener {
            bindingBooking.count.text = (bindingBooking.count.text.toString().toInt() + 1).toString()
            bindingBooking.remove.isEnabled = true
        }
        bindingBooking.remove.isEnabled = bindingBooking.count.text.toString().toInt() != 1
        bindingBooking.remove.setOnClickListener {
            bindingBooking.count.text = (bindingBooking.count.text.toString().toInt() - 1).toString()
            if(bindingBooking.count.text.toString().toInt() == 1){
                bindingBooking.remove.isEnabled = false
            }
        }
    }

    fun createbooking(){
        var data = intent.extras
        var user: UserParcelable? = data?.getParcelable("UserInfo")
        var type : TableTypeParcelable? = data?.getParcelable("typeData")
        val api: UserAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
        api.createbooking(
            type?.id_type.toString().toInt(),
            bindingBooking.count.text.toString().toInt(),
            bindingBooking.edtName.text.toString(),
//            bindingBooking.edtCode.text.toString(),
            user?.id_user.toString().toInt()
        ).enqueue(object: Callback<Booking> {
            override fun onResponse(call: Call<Booking>, response: Response<Booking>) {
                Toast.makeText(applicationContext, "Successfully ", Toast.LENGTH_SHORT).show()

                val intent1 = Intent(applicationContext,BookingDetailActivity::class.java)
                startActivity(intent1)
                val intent2 = Intent(this@BookingActivity, BookingDetailActivity::class.java)
//                intent2.putExtra("dd",bindingBooking.edtCode.text.toString())
                intent2.putExtra("aa",bindingBooking.menuName.text.toString())
                intent2.putExtra("bb",bindingBooking.count.text.toString().toInt())
                intent2.putExtra("cc",bindingBooking.edtName.text.toString())
                startActivity(intent2)
            }



            override fun onFailure(call: Call<Booking>, t: Throwable) {
                Toast.makeText(applicationContext, "Add failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
//fun randomCode(length: Int) :String {
//    val charset = ('0'..'9')
//    return (1..length)
//        .map { charset.random() }
//        .joinToString("")
//}