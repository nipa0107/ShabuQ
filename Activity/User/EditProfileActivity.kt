package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
//import com.bumptech.glide.Glide
import com.example.finalproject.databinding.ActivityEditProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProfileActivity : AppCompatActivity() {
    private lateinit var bindingedit: ActivityEditProfileBinding
    val createClient = UserAPI.create()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingedit = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(bindingedit.root)

    var data = intent.extras
    var UserInfo: UserParcelable? = data?.getParcelable("UserInfo")

        bindingedit.edtName.setText(UserInfo?.user_name.toString())
        bindingedit.edtEmail.setText(UserInfo?.user_email.toString())
        bindingedit.edtTel.setText(UserInfo?.tel.toString())

        bindingedit.btnEdit.setOnClickListener {
            val api: UserAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserAPI::class.java)
            api.editProfile(
                UserInfo?.id_user.toString().toInt(),
                bindingedit.edtName.text.toString(),
                bindingedit.edtEmail.text.toString(),
                bindingedit.edtTel.text.toString()
            ).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        Toast.makeText(applicationContext, "แก้ไขโปรไฟล์สำเร็จ", Toast.LENGTH_SHORT).show()
                        val LoginPage = Intent(this@EditProfileActivity, LoginActivity::class.java)
                        LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(LoginPage)
                        finish()
                    }else{
                    Toast.makeText(applicationContext,"Update Failure",
                        Toast.LENGTH_LONG).show()
                }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    return t.printStackTrace()
                }
            })
        }
    }
}

//    bindingedit.btnEdit.setOnClickListener {
//        val api: UserAPI = Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(UserAPI::class.java)
//        api.user(
//            UserInfo?.id_user.toString().toInt(),
//                bindingedit.edtName.text.toString(),
//                bindingedit.edtEmail.text.toString(),
//                bindingedit.edtTel.text.toString()
//        ).enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if(response.isSuccessful){
//                    Toast.makeText(applicationContext,"Seccessfully Update",
//                        Toast.LENGTH_LONG).show()
//                    val LoginPage = Intent(this@EditProfileActivity, LoginActivity::class.java)
//                    LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(LoginPage)
//                    finish()
//                 }else{
//                    Toast.makeText(applicationContext,"Update Failure",
//                        Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                return t.printStackTrace()
//            }
//        })
//    }
//}
//}

//        var data = intent.extras
//        var empInfo: UserParcelable? = data?.getParcelable("empInfo")
//
//
//        bindingedit.edtName.setText(empInfo?.user_name.toString())
//        bindingedit.edtEmail.setText(empInfo?.user_email.toString())
//        bindingedit.edtTel.setText(empInfo?.tel.toString())
//
//        bindingedit.btnEdit.setOnClickListener {
//            val api: UserAPI = Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(UserAPI::class.java)
//            api.user(
//                empInfo?.id_user.toString().toInt(),
//                bindingedit.edtName.text.toString(),
//                bindingedit.edtEmail.text.toString(),
//                bindingedit.edtTel.text.toString()
//            ).enqueue(object : Callback<User> {
//                override fun onResponse(call: Call<User>, response: Response<User>) {
//                    if(response.isSuccessful){
//                    Toast.makeText(applicationContext,"Seccessfully Update",
//                        Toast.LENGTH_LONG).show()
//                    val LoginPage = Intent(this@EditProfileActivity, LoginActivity::class.java)
//                        LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//                        startActivity(LoginPage)
//                        finish()
//                }else{
//                    Toast.makeText(applicationContext,"Update Failure",
//                        Toast.LENGTH_LONG).show()
//                }
////                    if(response.isSuccessful){
////                        Toast.makeText(applicationContext, "Edit Profile Successful", Toast.LENGTH_SHORT).show()
////                        val LoginPage = Intent(this@EditProfileActivity, LoginActivity::class.java)
////                        LoginPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
////                        startActivity(LoginPage)
////                        finish()
////                    }
//                }
//
//                override fun onFailure(call: Call<User>, t: Throwable) {
//                    return t.printStackTrace()
//                }
//            })
//        }
//    }
//}
////    fun btnEdit(v: View){
////        val name = intent.getStringArrayExtra("mID")
////        val email = intent.getStringArrayExtra("mName")
////        val tel = intent.getStringArrayExtra("mAge")
////
////        bindingedit.edtName.setText("name")
////        bindingedit.edtEmail.setText("email")
////        bindingedit.edtTel.setText("tel")
////        createClient.user(
////            bindingedit.edtName.text.toString(),
////            bindingedit.edtEmail.text.toString(),
////            bindingedit.edtTel.text.toString()
////        ).enqueue(object : Callback<User> {
////            override  fun onResponse(call: Call<User>, response:Response<User>){
////                if(response.isSuccessful){
////                    Toast.makeText(applicationContext,"Seccessfully Update",
////                        Toast.LENGTH_LONG).show()
////                    finish()
////                }else{
////                    Toast.makeText(applicationContext,"Update Failure",
////                        Toast.LENGTH_LONG).show()
////                }
////            }
////            override  fun onFailure(call: Call<User>, t: Throwable){
////                Toast.makeText(applicationContext,"Error onFailure" + t.message,
////                    Toast.LENGTH_LONG).show()
////            }
////        })
////    }
//////    fun deleteStudent(v: View){ }
////}