package com.example.naijameals

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val allRecipes= findViewById<TextView>(R.id.activity2detail)
//val allRecipes =TextView= findViewById(R.id.activity2detail)
val bundle: Bundle?= intent.extras
        val recipes = bundle?.getString("recipes")

        allRecipes.text = recipes
    }
}