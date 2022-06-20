package com.example.naijameals.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.naijameals.FoodListFragmentDirections
import com.example.naijameals.R
import com.example.naijameals.model.FoodItem


class ItemAdapter(private val dataSet: List<FoodItem>, private val foodClicked: (FoodItem)-> Unit):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodNameText: TextView = itemView.findViewById(R.id.food_name)
        val foodPriceText: TextView = itemView.findViewById(R.id.food_price)
        val foodImage: ImageView= itemView.findViewById(R.id.food_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
val item = dataSet[position]
        holder.foodNameText.text = item.foodName
        holder.foodPriceText.text = item.foodPrice.toString()
        holder.foodImage.setImageResource(item.foodImage)

        holder.foodImage.setOnClickListener {
       foodClicked(item)
        }

    }
    override fun getItemCount(): Int =dataSet.size
}

