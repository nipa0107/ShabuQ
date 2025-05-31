package com.example.adminshabu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.adminshabu.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener {
            addLogin()
        }
    }
    private fun addLogin() {
        val api: AdminAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdminAPI::class.java)
        if (binding.edtemail.text.toString().isEmpty() || binding.edtpassword.text.toString().isEmpty()
        ) {
            Toast.makeText(
                applicationContext, "กรุณากรอกข้อมูลก่อนเข้าสู่ระบบ",
                Toast.LENGTH_SHORT
            ).show()
        }
        api.login(
            binding.edtemail.text.toString(),
            binding.edtpassword.text.toString()
        ).enqueue(object : Callback<Admin> {
            override fun onResponse(call: Call<Admin>, response: Response<Admin>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        applicationContext, "เข้าสู่ระบบสำเร็จ",
                        Toast.LENGTH_SHORT
                    ).show()
                    val admin_id = response.body()?.id_admin.toString().toInt()
                    val admin_name = response.body()?.admin_name.toString()
                    val admin_email = response.body()?.admin_email.toString()
                    val admin_Pass = response.body()?.admin_password.toString()
                    val intent = Intent(applicationContext,HomeActivity::class.java)
                    startActivity(intent)
                    val Admin = Intent(this@MainActivity, HomeActivity::class.java)
                    Admin.putExtra("AdminInfo", AdminParcelable(admin_id,admin_name, admin_email, admin_Pass)
                    )
                    startActivity(Admin)
                } else {
                    Toast.makeText(
                        applicationContext, "ชื่อหรือรหัสผ่านไม่ถูกต้อง",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            override fun onFailure(call: Call<Admin>, t: Throwable) {
                Toast.makeText(
                    applicationContext, "Error onFailure" +
                            t.message, Toast.LENGTH_LONG
                ).show()
                println(t.message)
            }
        })
    }
}