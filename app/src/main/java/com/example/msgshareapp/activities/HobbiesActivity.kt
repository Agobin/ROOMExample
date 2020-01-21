package com.example.msgshareapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msgshareapp.adapters.HobbiesAdapter
import com.example.msgshareapp.R
import com.example.msgshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.i("debug_message", "This code was reached")
        super.onCreate(savedInstanceState)

        setupRecycleView()


    }

    private fun setupRecycleView() {

        setContentView(R.layout.activity_hobbies)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL //Setting the orientation of the layout manager
        recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(
            this,
            Supplier.hobbies
        )
        recyclerView.adapter = adapter
    }
}