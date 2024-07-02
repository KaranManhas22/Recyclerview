package com.karan.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.karan.recyclerview.databinding.ActivityMainBinding
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var item = 5
    private var counter = 0

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
        var recyclerAdapter = RecyclerAdapter(item)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding?.recycleview?.layoutManager = linearLayoutManager
        binding?.recycleview?.adapter = recyclerAdapter

        binding?.btnfloating?.setOnClickListener {
            item++
            recyclerAdapter.Addvalue(item)
            Toast.makeText(this, "value is added", Toast.LENGTH_SHORT).show()
        }

    }

}