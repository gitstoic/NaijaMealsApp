package com.example.naijameals

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.naijameals.adapter.ItemAdapter
import com.example.naijameals.data.DataSource
import com.example.naijameals.model.FoodItem

class MainActivity : AppCompatActivity() {
     lateinit var aboutFood : Array<String>
     private lateinit var newArrayList: ArrayList<FoodItem>

     private lateinit var newRecyclerView: RecyclerView

    private var isGridLayoutManager = true
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

aboutFood = arrayOf(
    getString(R.string.abacha,
    R.string.ewa_agoyin,
        R.string.akara,
        R.string.masa_masa,
        R.string.semoandeforiro,
        R.string.ofeakwu,
        R.string.egusi,
        R.string.asaro,
        R.string.ngwongwo,
        R.string.jollofrice,
        R.string.fufu,
        R.string.moinmoin,
        R.string.dodoikire,
        R.string.tuwoshinkafa,
        R.string.eba)
)

        chooseLayout()
    }

    private fun chooseLayout() {
        val recyclerStyle = findViewById<RecyclerView>(R.id.recycler_view)
        if (isGridLayoutManager) {
            recyclerStyle.layoutManager = GridLayoutManager(applicationContext, 2)
        } else {
            recyclerStyle.layoutManager = StaggeredGridLayoutManager(2, 0)
        }
        val myDataset = DataSource().loadFoodItem()
        recyclerStyle.adapter = ItemAdapter(myDataset)
    }
    private fun setIcon(menuItem: MenuItem?){
        if (menuItem==null)return
        menuItem.icon=
            if(isGridLayoutManager)
                ContextCompat.getDrawable(this,R.drawable.ic_grid)
        else{                ContextCompat.getDrawable(this,R.drawable.ic_staggered_grid)

            }
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflating layout
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton= menu?.findItem(R.id.action_switch)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch ->{
                isGridLayoutManager= !isGridLayoutManager
           chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getUserData(){
        var adapter = ItemAdapter(newArrayList)
        newRecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent= Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("aboutFood", aboutFood[position])
                startActivity(intent)
            }
        })

    }

    }