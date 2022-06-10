package com.example.naijameals.data

import com.example.naijameals.R
import com.example.naijameals.model.FoodItem

class DataSource{
    fun loadFoodItems(): List<FoodItem>{
        return listOf(
            FoodItem( "Abacha", R.string.abacha,"N600", R.drawable.abacha),
            FoodItem( "Ewa Agoyin", R.string.ewa_agoyin,"N1500", R.drawable.ewaagoyin),
            FoodItem( "Akara", R.string.akara,"N1000", R.drawable.akara),
            FoodItem( "Masa masa", R.string.masa_masa,"N800", R.drawable.masamasa),
            FoodItem( "Semo & Efo riro", R.string.semoandeforiro,"N1700", R.drawable.semo_eforiro),
            FoodItem( "Ofe akwu", R.string.ofeakwu,"N1200", R.drawable.ofeakwu),
            FoodItem( "Egusi", R.string.egusi,"N1300", R.drawable.egusi),
            FoodItem( "Asaro", R.string.asaro,"N1500", R.drawable.asaro),
            FoodItem( "Ngwo ngwo", R.string.ngwongwo,"N1000", R.drawable.ngwongwo),
            FoodItem( "Jollof rice", R.string.jollofrice,"N3000", R.drawable.jollofrice),
            FoodItem( "Fufu", R.string.fufu,"1800", R.drawable.fufu),
            FoodItem( "Moin moin", R.string.moinmoin,"N1900", R.drawable.moin_moin),
            FoodItem( "Dodo ikire", R.string.dodoikire,"N500", R.drawable.dodo_ikire),
            FoodItem( "Tuwo shinkafa", R.string.tuwoshinkafa,"N900", R.drawable.tuwo),
            FoodItem( "Eba", R.string.eba,"N3400", R.drawable.eba),
            )

    }
}

