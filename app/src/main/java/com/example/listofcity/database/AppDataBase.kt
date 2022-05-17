package com.example.listofcity.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class AppData
@Database(entities = [City::class],version = 1)
abstract class AppDataBase() : RoomDatabase(){
    abstract fun CityDao(): CityDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getMyDataBase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(AppDataBase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "MyDb232"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}