package com.example.msgshareapp.activities


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.models.Supplier
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*


class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = this::class.java.simpleName

        fun LOG_MESSAGE(message: String) {
            Log.i(TAG, message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //Log.i("toast_tag", "Button was clicked !")
            LOG_MESSAGE("Button was clicked")
            //Toast.makeText(this, "Button was clicked.", Toast.LENGTH_SHORT).show()
            showToast("Button was clicked")
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {

            //Sharing context to other apps.
            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please select app: "))
        }

        btnRecyclerViewDemo.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        btnAddHobby.setOnClickListener {
            var hobby = etUserMessage.text.toString()

            if (hobby.isNotEmpty()) {
                Supplier.addHobby(hobby)
                showToast("New hobby, $hobby added successfully")
                etUserMessage.setText("")
            }
        }

    }
}
