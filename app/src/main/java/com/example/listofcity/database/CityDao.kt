package com.example.listofcity.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteCity(favouriteCity: FavouriteCity)

    @Query("SELECT * FROM favouritecity")
    fun getAllFavouriteCity():LiveData<List<FavouriteCity>>

    @Delete
    fun delete(favouriteCity: FavouriteCity)
}
