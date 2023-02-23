package com.example.roomdatabase.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.FoodDao
import com.example.roomdatabase.FoodEntity


@Database(entities = [FoodEntity::class], version = 1)
abstract class RoomDB: RoomDatabase() {

    companion object{

        fun getInstances(context : Context): RoomDB {
            var db = Room.databaseBuilder(context,RoomDB::class.java,"Hotel")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }
    abstract fun foods() : FoodDao
}