package com.bobCompany.onstarMobileApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bobCompany.onstarMobileApp.R
import com.bobCompany.onstarMobileApp.data.CardItem

class CardAdapter (private val items: List<CardItem>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

        class CardViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textTop : TextView = view.findViewById(R.id.textTop)
            val textBottom: TextView = view.findViewById(R.id.textBottom)
        }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): CardViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dogam_layout,parent,false)
        return CardViewHolder(view)
    }

        override fun onBindViewHolder(holder: CardViewHolder, position : Int){
            val item = items[position]
            holder.imageView.setImageResource(item.imageResId)
            holder.textTop.text = item.topText
            holder.textBottom.text = item.bottomText
        }

        override fun getItemCount(): Int = items.size
}