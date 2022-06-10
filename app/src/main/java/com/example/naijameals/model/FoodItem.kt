package com.example.naijameals.model
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class FoodItem( val foodName: String, @StringRes val foodDeets: Int, val foodPrice: String, @DrawableRes val foodImage: Int)

