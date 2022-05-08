package com.example.naijameals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.naijameals.adapter.ItemAdapter
import com.example.naijameals.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset= DataSource().loadFoodItem()
        val recyclerStyle =findViewById<RecyclerView>(R.id.recycler_view)
        recyclerStyle.adapter = ItemAdapter(myDataset)
        recyclerStyle.setHasFixedSize(true)

    }
}