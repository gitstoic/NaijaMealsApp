package com.example.naijameals


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
    private val myDataset = DataSource().loadFoodItems()
    private lateinit var newRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newRecyclerView = binding.recyclerView
        newRecyclerView.setHasFixedSize(true)
        chooseLayout()

    }




        private fun chooseLayout() {
            if (isGridLayoutManager) {
                newRecyclerView.layoutManager = GridLayoutManager(applicationContext, 1)
            } else {
                newRecyclerView.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
            newRecyclerView.adapter = ItemAdapter(myDataset)
        }

        private fun setIcon(menuItem: MenuItem?) {
            if (menuItem == null) return
            menuItem.icon =
                if (isGridLayoutManager)
                    ContextCompat.getDrawable(this, R.drawable.ic_grid)
                else {
                    ContextCompat.getDrawable(this, R.drawable.ic_staggered_grid)
                }
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            //inflating layout
            menuInflater.inflate(R.menu.layout_menu, menu)
            val layoutButton = menu?.findItem(R.id.action_switch)
            setIcon(layoutButton)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_switch -> {
                    isGridLayoutManager = !isGridLayoutManager
                    chooseLayout()
                    setIcon(item)
                    return true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }
    }

