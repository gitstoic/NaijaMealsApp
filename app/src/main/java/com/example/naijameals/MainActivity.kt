package com.example.naijameals

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
import com.example.naijameals.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var isGridLayoutManager = true
//    private val myDataSet = DataSource().loadAboutFood()
    private lateinit var newRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newRecyclerView = binding.recyclerView
        newRecyclerView.setHasFixedSize(true)
        chooseLayout()

//array items
        imageId = arrayOf(
            R.drawable.abacha,
            R.drawable.ewaagoyin,
            R.drawable.akara,
            R.drawable.masamasa,
            R.drawable.semo_eforiro,
            R.drawable.ofeakwu,
            R.drawable.egusi,
            R.drawable.asaro,
            R.drawable.ngwongwo,
            R.drawable.jollofrice,
            R.drawable.fufu,
            R.drawable.moin_moin,
            R.drawable.dodo_ikire,
            R.drawable.tuwo,
            R.drawable.eba
        )

 heading =  arrayOf(
     "Abacha",
     "Ewa Agoyin",
     "Akara",
     "Masa masa",
     "Semo & Efo",
     "Ofe Akwu",
     "Egusi",
     "Asaro",
     "Ngwo ngwo",
     "Jollofrice",
     "Fufu",
     "Moin moin",
     "Dodo ikire",
     "Tuwo shinkafa",
     "Eba"
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
    getString(R.string.ewa_agoyin),
    getString(R.string.akara),
    getString(R.string.masa_masa),
    getString(R.string.semoandeforiro),
    getString(R.string.ofeakwu),
    getString(R.string.egusi),
    getString(R.string.asaro),
    getString(R.string.ngwongwo),
    getString(R.string.jollofrice),
    getString(R.string.fufu),
    getString(R.string.moinmoin),
    getString(R.string.dodoikire),
    getString(R.string.tuwoshinkafa),
    getString(R.string.eba)
)
        newArrayList = arrayListOf<DataSource>()
        getUserData()
    }




    private fun chooseLayout() {
        if (isGridLayoutManager) {
            newRecyclerView.layoutManager = GridLayoutManager(applicationContext, 1)
        } else {
            newRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
//        newRecyclerView.adapter = ItemAdapter(myDataSet)
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







    //initializing array items og
    private lateinit var aboutFood : Array<String>
    private lateinit var newArrayList: ArrayList<DataSource>
    lateinit var imageId : Array<Int>
    lateinit var price   : Array<String>
    lateinit var heading : Array<String>

    private fun getUserData(){
        for(i in imageId.indices){
            val naijafoods = DataSource(imageId[i], heading[i], price[i])
            newArrayList.add(naijafoods)
        }
        val adapter = ItemAdapter(newArrayList)
        newRecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent= Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("aboutFood", aboutFood[position])
                startActivity(intent)
            } })}
    }
