package com.example.finalproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var bindingHome: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bindingHome.root)
        var data = intent.extras
        var UserInfo: UserParcelable? = data?.getParcelable("UserInfo")

        bindingHome.btnBooking.setOnClickListener{
            val intent = Intent(applicationContext,BookingTypeActivity::class.java)
            intent.putExtra("UserInfo", UserInfo)
            startActivity(intent)
        }

        bindingHome.btnUserProfile.setOnClickListener {
            val userProfile = Intent(this@HomeActivity, UserProfileActivity::class.java)
            userProfile.putExtra("UserInfo", UserInfo)
            startActivity(userProfile)
        }

        bindingHome.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    var intent = Intent(this@HomeActivity, PromotionActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu2 -> {
                    var intent = Intent(this@HomeActivity, HomeActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu3 -> {
                    var intent = Intent(this@HomeActivity, WarnActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
            }
            true
        }

    }
}