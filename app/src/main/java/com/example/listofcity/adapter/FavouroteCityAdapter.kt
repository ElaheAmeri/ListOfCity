package com.example.listofcity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcity.R
import com.example.listofcity.database.City
import com.example.listofcity.database.CityRepository

class FavouroteCityAdapter (var dataSet: MutableList<City>) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.city_row_item, viewGroup, false)

        return CityAdapter.ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: CityAdapter.ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        isFavourite(dataSet[position])

    }
    override fun getItemCount() = dataSet.size

    fun isFavourite(city: City){
        if (city.click){
            city.isFavouriteCity= !city.isFavouriteCity
            if (city.isFavouriteCity){
                CityRepository.favouriteCityList.add(city)
            }else{
                CityRepository.favouriteCityList.remove(city)
            }
        }

    }
}