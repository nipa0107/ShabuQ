package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var bindingRegister : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRegister = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindingRegister.root)
        // Add Button
        bindingRegister.btnAdd.setOnClickListener{
            addRegister()
        }
    }

    private fun addRegister(){
        val api: UserAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
        api.insertRegister(
            bindingRegister.edtName.text.toString(),
            bindingRegister.edtPassword.text.toString(),
            bindingRegister.edtEmail.text.toString(),
            bindingRegister.edtTel.text.toString()
        ).enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: retrofit2.Response<User>
            ) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Successfully Inserted",
                        Toast.LENGTH_SHORT).show()
                    finish()

                } else {
                    Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure " +
                        t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}

