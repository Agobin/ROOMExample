package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*
import android.app.Activity
import com.example.msgshareapp.Constants


class SecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val message = bundle?.getString(Constants.USER_MSG_KEY)
            txvUserMessage.text = message

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    }
}
