package com.example.msgshareapp

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(text: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, text, length).show()
}