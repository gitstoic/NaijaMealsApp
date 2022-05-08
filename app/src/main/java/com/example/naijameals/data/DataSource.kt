package com.example.naijameals.data

import com.example.naijameals.R
import com.example.naijameals.model.FoodItem

class DataSource {

    fun loadFoodItem(): List<FoodItem>{
        return listOf(
            FoodItem("Abacha", "Price: N2200", R.drawable.abacha),
            FoodItem("Ewa Agoyin", "Price: N2300", R.drawable.ewaagoyin),
            FoodItem("Akara", "Price: N1050", R.drawable.akara),
            FoodItem("Masa masa", "Price: N600", R.drawable.masamasa),
            FoodItem("Semo and Efo riro", "Price: N3800", R.drawable.semo_eforiro),
            FoodItem("Ofe Akwu", "Price: N1100", R.drawable.ofeakwu),
            FoodItem("Egusi soup", "Price: N1200", R.drawable.egusi),
            FoodItem("Asaro (Yam Porridge)", "Price: N2800", R.drawable.asaro),
            FoodItem("Nwo nwo", "Price: N1500", R.drawable.nwonwo),
            FoodItem("Jollof rice", "Price: N2500", R.drawable.jollofrice),
            FoodItem("Fufu", "Price: N3550", R.drawable.fufu),
            FoodItem("Moin moin", "Price: N1000", R.drawable.moin_moin),
            FoodItem("Dodo Ikire", "Price: N1000", R.drawable.dodo_ikire),
            FoodItem("Tuwo shinkafa", "Price: N2500", R.drawable.tuwo),
            FoodItem("Eba and soup", "Price: N3500", R.drawable.eba)
                )
    }

}