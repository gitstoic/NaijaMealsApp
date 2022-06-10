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


class ItemAdapter(private val dataSet: List<FoodItem>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodNameText: TextView = itemView.findViewById(R.id.food_name)
        val foodPriceText: TextView = itemView.findViewById(R.id.food_price)
        val foodImage: ImageView= itemView.findViewById(R.id.food_image)
val button: Button = itemView.findViewById(R.id. btn_deets)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
val item = dataSet[position]
        holder.foodNameText.text = item.foodName
        holder.foodPriceText.text = item.foodPrice
        holder.foodImage.setImageResource(item.foodImage)
        holder.button.text

        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DEETS, item.foodDeets)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int =dataSet.size
}

