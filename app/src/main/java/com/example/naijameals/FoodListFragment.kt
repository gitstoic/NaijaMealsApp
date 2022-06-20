package com.example.naijameals

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.naijameals.adapter.ItemAdapter
import com.example.naijameals.data.DataSource
import com.example.naijameals.databinding.FragmentFoodListBinding


class FoodListFragment : Fragment() {

    private var isGridLayoutManager = true
    private val myDataset = DataSource().loadFoodItems()
    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding
    private lateinit var newRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        val view = binding?.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        newRecyclerView = binding?.recyclerView!!
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch)
        setIcon(layoutButton)
    }

    private fun chooseLayout() {
        if (isGridLayoutManager) {
            newRecyclerView.layoutManager = GridLayoutManager(context, 1)
        } else {
            newRecyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        newRecyclerView.adapter = ItemAdapter(myDataset, foodClicked = {
            val directions = FoodListFragmentDirections.actionFoodListFragmentToDetailFragment(it)
            findNavController().navigate(directions)
        })
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) return
        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid)
            else
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_staggered_grid)

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



