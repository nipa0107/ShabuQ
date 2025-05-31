package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var bindingLogin: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)
        bindingLogin.checkLogin.setOnClickListener {
            addLogin()
        }
    }
    private fun addLogin() {
        val api: UserAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
        if (bindingLogin.edtemail.text.toString().isEmpty() || bindingLogin.edtpassword.text.toString().isEmpty()
        ) {
            Toast.makeText(
                applicationContext, "กรุณากรอกข้อมูลก่อนเข้าสู่ระบบ",
                Toast.LENGTH_SHORT
            ).show()
        }
        api.loginUser(
            bindingLogin.edtemail.text.toString(),
            bindingLogin.edtpassword.text.toString()
        ).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        applicationContext, "เข้าสู่ระบบสำเร็จ",
                        Toast.LENGTH_SHORT
                    ).show()
                    val user_id = response.body()?.id_user.toString().toInt()
                    val user_name = response.body()?.user_name.toString()
                    val user_email = response.body()?.user_email.toString()
                    val tel = response.body()?.tel.toString()
                    val intent = Intent(applicationContext,HomeActivity::class.java)
                    startActivity(intent)
                    val mainAdmin = Intent(this@LoginActivity, HomeActivity::class.java)
                    mainAdmin.putExtra("UserInfo", UserParcelable(user_id,user_name, user_email, tel)
                    )
                    startActivity(mainAdmin)
                } else {
                    Toast.makeText(
                        applicationContext, "ชื่อหรือรหัสผ่านไม่ถูกต้อง",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    applicationContext, "Error onFailure" +
                            t.message, Toast.LENGTH_LONG
                ).show()
                println(t.message)
            }
        })
    }
}









//fun callStudentData(){
//    userList.clear();
//    val serv : UserAPI = Retrofit.Builder()
//        .baseUrl("http://10.0.2.2:3000/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(UserAPI ::class.java)
//
//    serv.retrieveStudent()
//        .enqueue(object : Callback<List<User>> {
//            override fun onResponse(call: Call<List<User>>, response:
//            Response<List<User>>
//            ) {
//                response.body()?.forEach {
//                    userList.add(User(it.user_name, it.user_password,it.user_email,it.tel))
//                }
////// Set Data to RecyclerRecyclerView
//            }
//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                Toast.makeText(applicationContext,"Error onFailure " + t.message,
//                    Toast.LENGTH_LONG).show()
//            }
//        })
//}


