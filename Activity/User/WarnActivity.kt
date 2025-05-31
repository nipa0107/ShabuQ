package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.databinding.ActivityWarnBinding

class WarnActivity : AppCompatActivity() {
    private lateinit var bindingWarn:ActivityWarnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingWarn = ActivityWarnBinding.inflate(layoutInflater)
        setContentView(bindingWarn.root)

        var data = intent.extras
        var UserInfo: UserParcelable? = data?.getParcelable("UserInfo")

        bindingWarn.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    var intent = Intent(this@WarnActivity, PromotionActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu2 -> {
                    var intent = Intent(this@WarnActivity, HomeActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu3 -> {
                    var intent = Intent(this@WarnActivity, WarnActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
            }
            true
        }

    }
}