package com.karan.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textfield.TextInputLayout.LengthCounter
import kotlinx.coroutines.withContext

class RecyclerAdapter(var item:Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var counter =0


    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val name1: TextView = view.findViewById(R.id.name)
        val number1: TextView = view.findViewById(R.id.number)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {


        holder.name1.setText(position.toString())
        holder.number1.setText(position.toString())

    }

    override fun getItemCount(): Int {
        return item
    }
    fun Addvalue(aditionvalue: Int) {
        item = aditionvalue
        notifyDataSetChanged()
    }

}