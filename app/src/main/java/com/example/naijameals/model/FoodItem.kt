package com.example.naijameals.model
import androidx.annotation.DrawableRes


data class FoodItem(val foodName: String, val foodPrices: String,
    @DrawableRes val imageResourceId: Int)


