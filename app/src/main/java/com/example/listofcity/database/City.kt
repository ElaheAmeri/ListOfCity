package com.example.listofcity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City(@PrimaryKey(autoGenerate=true) var id :Int,
            var name:String,
            var click:Boolean=false,
           var isFavouriteCity:Boolean=false)    {
}