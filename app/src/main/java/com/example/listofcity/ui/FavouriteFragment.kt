package com.example.listofcity.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.listofcity.R
import com.example.listofcity.adapter.CityAdapter
import com.example.listofcity.adapter.FavouroteCityAdapter
import com.example.listofcity.databinding.FragmentFaivoritBinding
import com.example.listofcity.databinding.FragmentHomeBinding
import com.example.listofcity.viewmodel.FavouriteCityViewModel

class FavouriteFragment : Fragment() {
    lateinit var binding : FragmentFaivoritBinding
    val vmodel :FavouriteCityViewModel by viewModels()
    val adapter= FavouroteCityAdapter(mutableListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFaivoritBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleViewList()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initRecycleViewList(){

        binding.rvFavoritePage?.adapter=adapter
        adapter.dataSet=vmodel.getList()
        adapter.notifyDataSetChanged()
        adapter.notifyItemInserted(0)

    }


}