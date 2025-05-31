package com.example.adminshabu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.adminshabu.databinding.ActivityInsertTypeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertTypeActivity : AppCompatActivity() {
    private lateinit var bindingInsert : ActivityInsertTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertTypeBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
    }

    fun addType(v: View) {
        val api: AdminAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdminAPI::class.java)
        api.addTableType(
            bindingInsert.edtType.text.toString() ,
            bindingInsert.edtAdmin.text.toString().toInt()
        ).enqueue(object : Callback<TableType> {
            override fun onResponse(
                call: Call<TableType>,
                response: retrofit2.Response<TableType>
            ) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Successfully Inserted",
                        Toast.LENGTH_SHORT).show()
                    finish()

                } else {
                    Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<TableType>, t: Throwable) {
                Toast.makeText(applicationContext,"ไม่มีข้อมูลแอดมินในระบบ" +
                        t.message,Toast.LENGTH_LONG).show()
            }
        })
    }

    fun resetStudent(v: View) {
        bindingInsert.edtType.text?.clear()
    }
}