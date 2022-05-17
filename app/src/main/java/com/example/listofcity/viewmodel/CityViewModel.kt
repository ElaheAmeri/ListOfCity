package com.example.listofcity.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.listofcity.database.City
import com.example.listofcity.database.CityRepository

class CityViewModel(app: Application): AndroidViewModel(app) {
    init {

        CityRepository.initDB(app.applicationContext)
    }
fun getList():MutableList<City>{
    return CityRepository.cityList
}
}