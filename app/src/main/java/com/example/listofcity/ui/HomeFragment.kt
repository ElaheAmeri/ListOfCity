package com.example.listofcity.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcity.R
import com.example.listofcity.adapter.CityAdapter
import com.example.listofcity.adapter.SwipToDelete
import com.example.listofcity.databinding.FragmentHomeBinding
import com.example.listofcity.viewmodel.CityViewModel


class HomeFragment : Fragment() {
    val vmodel: CityViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    val adapter=CityAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHomeToFavourite?.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_faivoritFragment)
        }
        initRecycleViewList()
        swipe()


    }
    @SuppressLint("NotifyDataSetChanged")
    fun initRecycleViewList(){

        binding.rvHomePage.adapter=adapter
        adapter.dataSet=vmodel.getList()
        adapter.notifyDataSetChanged()
        adapter.notifyItemInserted(0)

    }
    fun swipe(){
        val swipeHandler = object : SwipToDelete(adapter) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                adapter.delet(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.rvHomePage)
    }
    fun click(adapter: CityAdapter){

    }




}