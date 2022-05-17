package com.example.listofcity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavouriteCity(@PrimaryKey(autoGenerate=true) var id :Int,
                    var name:String,
                    var isFavouriteCity:Boolean=false)    {
}