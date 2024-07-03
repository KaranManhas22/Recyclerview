package com.karan.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var item: ArrayList<String>, private var adapterInterface: AdapterInterface): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val name1: TextView = view.findViewById(R.id.name)
        val number1: TextView = view.findViewById(R.id.number)
        var btndel:Button=view.findViewById(R.id.btnDel)
        var btnupdate:Button=view.findViewById(R.id.btnupdate)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.name1.setText(item[position])
        holder.number1.setText(item[position])


        holder.btnupdate.setOnClickListener {
            adapterInterface.Update_data(position)

        }
        holder.btndel.setOnClickListener {
            adapterInterface.Delete_data(position)
        }

    }


    override fun getItemCount(): Int {
        return item.size

    }
    fun Addvalue(aditionvalue: ArrayList<String>) {
        item = aditionvalue
        notifyDataSetChanged()
    }


    }

