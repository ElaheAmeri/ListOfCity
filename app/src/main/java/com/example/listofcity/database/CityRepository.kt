package com.example.listofcity.database

import android.content.Context
import androidx.lifecycle.LiveData

object CityRepository {
    lateinit var db: AppDataBase
    lateinit var dao: CityDao
    var favouriteCityList= mutableListOf<City>()
    var cityList = mutableListOf<City>(City(0,"تبریز"),
        City(0,"تهران"),
        City(0,"یزد"),
        City(0,"مشهد"),
        City(0,"قم"),
        City(0,"سمنان"),
        City(0,"اصفهان"),
        City(0,"شیراز"),
        City(0,"سنندج"),
        City(0,"بوشهر"),
        City(0,"کاشان")

    )
    fun initDB(context: Context):AppDataBase{
        db = AppDataBase.getMyDataBase(context)
        dao = db.CityDao()
        return db
    }


    fun insert(city: City){
        dao.insertCity(city)
    }
    fun insertFavouriteCity(favouriteCity: FavouriteCity){
        dao.insertFavouriteCity(favouriteCity)
    }

    fun getAllFavouriteCity():LiveData<List<FavouriteCity>>{
       return dao.getAllFavouriteCity()
    }


    fun deleteCity(favouriteCity: FavouriteCity){
        dao.delete(favouriteCity)
    }

}