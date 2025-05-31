package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var userList = arrayListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root )
// Link to RecyclerView

        binding.btnRegister.setOnClickListener{
            val intent = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnAddLogin.setOnClickListener{
            val intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
        }

    }

//    override fun onResume() {
//        super.onResume()
//        callStudentData()
//    }
//
//    fun callStudentData(){
//        userList.clear();
//        val serv : UserAPI = Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(UserAPI ::class.java)
//
//        serv.retrieveStudent()
//            .enqueue(object : Callback<List<User>> {
//                override fun onResponse(call: Call<List<User>>, response:
//                Response<List<User>>
//                ) {
//                    response.body()?.forEach {
//                        userList.add(User(it.user_email, it.user_password,it.user_name,it.tel))
//                    }
////// Set Data to RecyclerRecyclerView
//                }
//
//                override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                    Toast.makeText(applicationContext,"Error onFailure " + t.message,
//                        Toast.LENGTH_LONG).show()
//                }
//            })
//    }
}