package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.TabletypeItemLayoutBinding

class TableTypeAdapter(
    var tableTypeList: ArrayList<TableType>?, val user: UserParcelable?, val context: Context,)
    : RecyclerView.Adapter<TableTypeAdapter.ViewHolder>(){
    inner class ViewHolder(view: View, val binding: TabletypeItemLayoutBinding)
        :RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TabletypeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.foodName.text = tableTypeList!![position].type_name
        binding.cardView.setOnClickListener {
            var intent = Intent(context, BookingActivity::class.java)
            intent.putExtra("typeData", TableTypeParcelable(tableTypeList!![position].id_type,tableTypeList!![position].type_name, tableTypeList!![position].id_admin))
            intent.putExtra("UserInfo", UserParcelable(user?.id_user.toString().toInt(),user?.user_name.toString(), user?.user_email.toString(), user?.tel.toString()))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tableTypeList!!.size
    }
}