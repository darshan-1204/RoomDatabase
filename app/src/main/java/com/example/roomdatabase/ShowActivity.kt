package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.Database.RoomDB
import com.example.roomdatabase.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var db = RoomDB.getInstances(this)

        var list = db.foods().getFood()

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = FoodAdapter(list)
    }

//    companion object{
//
//        lateinit var adapter: FoodAdapter
//        lateinit var binding: ActivityShowBinding
//        lateinit var db: RoomDB
//
//        fun update(){
//            var list = db.foods().getFood()
//            adapter = FoodAdapter(list)
//            binding.recycler.adapter = adapter
//        }
//    }
}