package com.example.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.models.Hobby
import com.example.msgshareapp.R
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, "Current hobby is ${currentHobby!!.title} and current position is $currentPosition", Toast.LENGTH_LONG).show()
            }

            itemView.imgShare.setOnClickListener{
                currentHobby?.let {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, "My hobby is ${currentHobby?.title}")
                    intent.type = "Text/plain"

                    context.startActivity(Intent.createChooser(intent, "Choose app to share hobby:"))


                }

            }
        }

        fun setData(hobby: Hobby?, pos:Int){
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            currentHobby = hobby
            currentPosition = pos
        }
    }
}