package com.example.naijameals.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naijameals.R
import com.example.naijameals.model.FoodItem


class ItemAdapter(private val dataSet: List<FoodItem>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodNameText: TextView = itemView.findViewById(R.id.food_name)
        val foodPrice: TextView = itemView.findViewById(R.id.food_price)
        val foodImage: ImageView= view.findViewById(R.id.food_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
val item = dataSet[position]
        holder.foodNameText.text = item.foodName
        holder.foodPrice.text = item.foodPrices
        holder.foodImage.setImageResource(item.imageResourceId)

    }

    override fun getItemCount(): Int =dataSet.size
}

