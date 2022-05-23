package com.example.naijameals.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class FoodItem(val id: Int, val foodName: String, @DrawableRes val imageResourceId: Int)


