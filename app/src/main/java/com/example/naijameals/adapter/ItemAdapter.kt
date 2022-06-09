package com.example.naijameals.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naijameals.DetailActivity
import com.example.naijameals.R
import com.example.naijameals.data.DataSource
import com.example.naijameals.model.FoodItem


class ItemAdapter(private val dataSet: ArrayList<DataSource>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    //og
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener= listener
    }

    class ItemViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val foodNameText: TextView = itemView.findViewById(R.id.food_name)
        val foodPriceText: TextView = itemView.findViewById(R.id.food_price)
        val foodImage: ImageView= view.findViewById(R.id.food_image)

        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout, mListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
val item = dataSet[position]
        holder.foodNameText.text = item.heading
        holder.foodPriceText.text = item.price
        holder.foodImage.setImageResource(item.foodImage)
    }
    override fun getItemCount(): Int =dataSet.size
}

