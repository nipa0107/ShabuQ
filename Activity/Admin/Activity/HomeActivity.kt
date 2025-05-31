package com.example.adminshabu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminshabu.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var bindingHome: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bindingHome.root)

        bindingHome.btnadmin2.setOnClickListener{
            val intent = Intent(applicationContext,TableTypeActivity::class.java)
            startActivity(intent)
        }
    }
}