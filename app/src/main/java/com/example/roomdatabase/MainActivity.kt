package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabase.Database.RoomDB
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = RoomDB.getInstances(this)

        binding.btnAdd.setOnClickListener{

            var food = FoodEntity(binding.edtName.text.toString(),binding.edtPrice.text.toString().toInt(),binding.edtRate.rating)
            db.foods().addFood(food)
        }

        binding.btnShow.setOnClickListener{

            startActivity(Intent(this,ShowActivity::class.java))
        }
    }
}