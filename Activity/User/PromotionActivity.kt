package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.databinding.ActivityPromotionBinding

class PromotionActivity : AppCompatActivity() {
    private lateinit var bindingPro: ActivityPromotionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPro = ActivityPromotionBinding.inflate(layoutInflater)
        setContentView(bindingPro.root)

        var data = intent.extras
        var UserInfo: UserParcelable? = data?.getParcelable("UserInfo")

        bindingPro.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    var intent = Intent(this@PromotionActivity, PromotionActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu2 -> {
                    var intent = Intent(this@PromotionActivity, HomeActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
                R.id.menu3 -> {
                    var intent = Intent(this@PromotionActivity, WarnActivity::class.java)
                    intent.putExtra("UserInfo", UserInfo)
                    startActivity(intent)
                }
            }
            true
        }

    }
}