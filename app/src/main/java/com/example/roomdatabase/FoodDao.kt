package com.example.roomdatabase

import androidx.room.*

@Dao
interface FoodDao {

    @Insert
    fun addFood(food: FoodEntity)

    @Query("SELECT * FROM food")
    fun getFood() : List<FoodEntity>

    @Delete
    fun deleteFood(food: FoodEntity)

    @Update
    fun updateFood(food: FoodEntity)

}