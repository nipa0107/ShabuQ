package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.databinding.ActivityBookingDetailBinding

class BookingDetailActivity : AppCompatActivity() {
    private lateinit var bindingBookDetail: ActivityBookingDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBookDetail = ActivityBookingDetailBinding.inflate(layoutInflater)
        setContentView(bindingBookDetail.root)
        var data = intent
        var data1 = intent.extras
        var user: UserParcelable? = data1?.getParcelable("BookingInfo")
        var aa = data.getStringExtra("aa").toString()
        var bb = data.getIntExtra("bb",0).toString()
        var cc = data.getStringExtra("cc").toString()
//        var dd = data.getStringExtra("dd").toString()

//        bindingBookDetail.showBooking.text = "โค้ด : " +dd
        bindingBookDetail.showBooking.text = "ประเภทโต๊ะ : " + aa
        bindingBookDetail.showCount.text = "จำนวนคน : " + bb
        bindingBookDetail.showName.text = "ชื่อ : " + cc

        bindingBookDetail.backhome.setOnClickListener {
            val userProfile = Intent(this@BookingDetailActivity, HomeActivity::class.java)
            userProfile.putExtra("UserInfo", user)
            startActivity(userProfile)
        }



//        bindingUser.btnEdit.setOnClickListener {
//            val editProfile = Intent(this@UserProfileActivity, EditProfileActivity::class.java)
//            editProfile.putExtra("UserInfo", UserInfo)
//            startActivity(editProfile)
//        }

//        bindingUser.btnLogout.setOnClickListener {
//            val LoginPage = Intent(this, MainActivity::class.java)
//            LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(LoginPage)
//            finish()
//        }
    }
}