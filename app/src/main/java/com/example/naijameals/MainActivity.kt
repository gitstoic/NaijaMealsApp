package com.example.naijameals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.naijameals.adapter.ItemAdapter
import com.example.naijameals.data.DataSource


class MainActivity : AppCompatActivity() {
    private lateinit var aboutFood : Array<String>
     private lateinit var newArrayList: ArrayList<DataSource>
     private lateinit var newRecyclerView: RecyclerView
    private var isGridLayoutManager = true
    lateinit var imageId : Array<Int>
    lateinit var price   : Array<String>
    lateinit var heading : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
       // getUserData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        imageId = arrayOf(
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha,
            R.drawable.abacha
        )




 heading =  arrayOf(
     "abacha",
     "ewa_agoyin",
     "akara",
     "masa_masa",
     "semoandeforiro",
     "ofeakwu",
     "egusi",
     "asaro",
     "ngwongwo",
     "jollofrice",
     "fufu",
     "moinmoin",
     "dodoikire",
     "tuwoshinkafa",
     "eba"
 )
        price = arrayOf(
            "N600",
            "N800",
            "N1600",
            "N600",
            "N800",
            "N1200",
            "N700",
            "N600",
            "N800",
            "1200",
            "N600",
            "N800",
            "N1600",
            "N600",
            "N800"
        )


aboutFood = arrayOf(
   getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha),
    getString(R.string.abacha)
)



        newRecyclerView = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<DataSource>()
        getUserData()

//        chooseLayout()
    }

    private fun chooseLayout() {
//        val recyclerStyle = findViewById<RecyclerView>(R.id.recycler_view)
        if (isGridLayoutManager) {
            newRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        } else {
            newRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
//        val myDataset = DataSource().loadFoodItem()
//        recyclerStyle.adapter = ItemAdapter(myDataset)
    }
    private fun setIcon(menuItem: MenuItem?){
        if (menuItem==null)return
        menuItem.icon=
            if(isGridLayoutManager)
                ContextCompat.getDrawable(this,R.drawable.ic_grid)
        else{
            ContextCompat.getDrawable(this,R.drawable.ic_staggered_grid)
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
        for(i in imageId.indices){
            val naijafoods = DataSource(imageId[i], heading[i], price[i])
            newArrayList.add(naijafoods)
        }

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
