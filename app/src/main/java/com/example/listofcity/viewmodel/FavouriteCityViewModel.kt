package com.example.listofcity.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.listofcity.database.City
import com.example.listofcity.database.CityRepository
import com.example.listofcity.database.FavouriteCity

class FavouriteCityViewModel (app: Application): AndroidViewModel(app){

    fun getList():MutableList<City>{
        return CityRepository.favouriteCityList
    }
    fun insertFavouriteCity(favouriteCity: FavouriteCity){
        CityRepository.insertFavouriteCity(favouriteCity)
    }
    fun deleteCity(favouriteCity: FavouriteCity){
        CityRepository.deleteCity(favouriteCity)
    }
}