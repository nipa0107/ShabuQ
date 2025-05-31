package com.example.adminshabu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminshabu.databinding.ActivityTableTypeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TableTypeActivity : AppCompatActivity() {
    private lateinit var bindingTableType: ActivityTableTypeBinding
    var tableTypeList = arrayListOf<TableType>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTableType = ActivityTableTypeBinding.inflate(layoutInflater)
        setContentView(bindingTableType.root)
        // Link to RecyclerView
        bindingTableType.recyclerView.adapter = TableTypeAdapter(this.tableTypeList, applicationContext)
        bindingTableType.recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        bindingTableType.recyclerView.addItemDecoration(
            DividerItemDecoration(bindingTableType.recyclerView.getContext(),
                DividerItemDecoration.VERTICAL)
        )
        bindingTableType.btnAddStudent.setOnClickListener {
            val intent = Intent(applicationContext,InsertTypeActivity::class.java)
            startActivity((intent))
        }
    }

    override fun onResume() {
        super.onResume()
        callStudentData()
    }

    fun callStudentData(){
        tableTypeList.clear();
        val serv : AdminAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdminAPI ::class.java)

        serv.retrieveType()
            .enqueue(object : Callback<List<TableType>> {
                override fun onResponse(call: Call<List<TableType>>, response:
                Response<List<TableType>>
                ) {
                    response.body()?.forEach {
                        tableTypeList.add(TableType(it.id_type, it.type_name,it.id_admin))
                    }
//// Set Data to RecyclerRecyclerView
                    bindingTableType.recyclerView.adapter = TableTypeAdapter(tableTypeList,applicationContext)
                    bindingTableType.txt1.text = "Student List : "+ tableTypeList.size.toString()
                }

                override fun onFailure(call: Call<List<TableType>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error onFailure " + t.message,
                        Toast.LENGTH_LONG).show()
                }
            })
    }
    fun addStudent(v: View) {
        val intent = Intent(applicationContext, InsertTypeActivity::class.java)
        startActivity(intent)
    }
}