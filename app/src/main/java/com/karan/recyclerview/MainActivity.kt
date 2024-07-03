package com.karan.recyclerview

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.karan.recyclerview.databinding.ActivityMainBinding
import com.karan.recyclerview.databinding.CustomDialogboxBinding

class MainActivity : AppCompatActivity(), AdapterInterface {

    var binding: ActivityMainBinding? = null
    var item = arrayListOf<String>("C", "c++", "java")

    var recyclerAdapter = RecyclerAdapter(item, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding?.recycleview?.layoutManager = linearLayoutManager
        binding?.recycleview?.adapter = recyclerAdapter

        binding?.btnfloating?.setOnClickListener {

            recyclerAdapter.Addvalue(item)
            Toast.makeText(this, "value is added", Toast.LENGTH_SHORT).show()
        }
    }

    override fun Update_data(position: Int) {
        val dialogBinding = CustomDialogboxBinding.inflate(layoutInflater)
        val update_dialog = Dialog(this).apply {
            setContentView(dialogBinding.root)
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            show()
        }
        val oldName: String = item[position]
        dialogBinding.etname.setText(oldName)
        val update = "update"
        dialogBinding.btnadd.text = update
        dialogBinding.btnadd.setOnClickListener {
            if (dialogBinding.etname.text.toString().isNullOrEmpty()) {
                dialogBinding.etname.error = "Enter Name"
            } else {

                item[position] = dialogBinding.etname.text.toString()

                recyclerAdapter.notifyDataSetChanged()
                update_dialog.dismiss()
            }
        }
    }

    override fun Delete_data(position: Int) {
        AlertDialog.Builder(this).apply {
            setTitle("Are you sure")
            setPositiveButton("yes")
            { _, _ ->
                item.removeAt(position)

            }
            setNegativeButton("No")
            { _, _ ->

            }
            setCancelable(false)
        }
            .show()

        recyclerAdapter.notifyDataSetChanged()
    }
}









