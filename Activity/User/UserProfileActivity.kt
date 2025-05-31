package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {
    private lateinit var bindingUser: ActivityUserProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUser = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(bindingUser.root)

        var data = intent.extras
        var UserInfo: UserParcelable? = data?.getParcelable("UserInfo")


        bindingUser.showName.text = "ชื่อ : " + UserInfo?.user_name
        bindingUser.showEmail.text = "อีเมล : " + UserInfo?.user_email
        bindingUser.showTel.text = "เบอร์โทร : " + UserInfo?.tel

        bindingUser.btnEdit.setOnClickListener {
            val editProfile = Intent(this@UserProfileActivity, EditProfileActivity::class.java)
            editProfile.putExtra("UserInfo", UserInfo)
            startActivity(editProfile)
        }

        bindingUser.btnLogout.setOnClickListener {
            val LoginPage = Intent(this, MainActivity::class.java)
            LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(LoginPage)
            finish()
        }
    }
}