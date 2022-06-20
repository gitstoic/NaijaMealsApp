package com.example.naijameals.model
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodItem(
    val foodName: String,  val foodDeets: String, val foodPrice: Double, @DrawableRes val foodImage: Int): Parcelable
