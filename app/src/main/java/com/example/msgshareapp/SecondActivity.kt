package com.example.msgshareapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*
import android.app.Activity


class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe Call   ?.
        // Safe Call with let  ?.let {  }

        val bundle: Bundle? = intent.extras
        val message = bundle?.getString("user_message")
        txvUserMessage.text = message

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}
