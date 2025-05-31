package com.example.adminshabu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminshabu.databinding.TableItemLayoutBinding

class TableTypeAdapter (val tableTypeList: ArrayList<TableType>?, val context: Context):
    RecyclerView.Adapter<TableTypeAdapter.ViewHolder>() {

    class ViewHolder(view: View, val bindingType: TableItemLayoutBinding) :
        RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingType = TableItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingType.root,bindingType)
    }

    override fun getItemCount(): Int {
        return tableTypeList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bindingType = holder.bindingType

        bindingType.txtName.text = "Name: " + tableTypeList!![position].type_name
        bindingType.txtAdmin.text = "Admin: " + tableTypeList!![position].id_admin
    }
}