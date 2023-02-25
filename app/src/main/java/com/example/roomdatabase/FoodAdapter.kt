package com.example.roomdatabase

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomdatabase.Database.RoomDB

class FoodAdapter(list: List<FoodEntity>) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    var list = list
    lateinit var context : Context

    class FoodHolder(itemView: View) : ViewHolder(itemView){

        var id = itemView.findViewById<TextView>(R.id.tvId)
        var name = itemView.findViewById<TextView>(R.id.tvName)
        var price = itemView.findViewById<TextView>(R.id.tvPrice)
        var rating = itemView.findViewById<RatingBar>(R.id.rtFood)
        var delete = itemView.findViewById<ImageView>(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {

        context = parent.context
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_food,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {

        var db = RoomDB.getInstances(context)

        holder.id.text = list[position].id.toString()
        holder.name.text = list[position].name
        holder.price.text = list[position].price.toString()
        holder.rating.rating = list[position].rating

        holder.itemView.setOnClickListener{

            var dialog = Dialog(context)
            dialog.setContentView(R.layout.data_update)

            var edtName = dialog.findViewById<EditText>(R.id.edtName)
            var edtPrice = dialog.findViewById<EditText>(R.id.edtPrice)
            var rtFood = dialog.findViewById<RatingBar>(R.id.edtRate)
            var btnUpdate = dialog.findViewById<Button>(R.id.btnUpdate)


            edtName.setText(list.get(position).name)
            edtPrice.setText(list.get(position).price.toString())
            rtFood.rating = (list.get(position).rating)

            btnUpdate.setOnClickListener {

                var data = FoodEntity(edtName.text.toString(),edtPrice.text.toString().toInt(),rtFood.rating)
                data.id = list[position].id

                db.foods().updateFood(data)
                dialog.dismiss()
                ShowActivity.update()
            }
        }
        holder.delete.setOnClickListener {

            db.foods().deleteFood(list[position])
            ShowActivity.update()
        }
    }
}