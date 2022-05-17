package com.example.listofcity.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcity.R
import com.example.listofcity.database.City

class CityAdapter(var dataSet: MutableList<City>) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var textView: TextView
        var btnLike:ImageButton
        init {
            btnLike=view.findViewById(R.id.btnLike)
            textView = view.findViewById(R.id.tvRecycleView)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.city_row_item, viewGroup, false)

        return ViewHolder(view)

    }
    @SuppressLint("NotifyDataSetChanged")
    fun delet(pos:Int){
        dataSet.removeAt(pos)
        notifyItemRemoved(pos)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        viewHolder.btnLike.setOnClickListener(){
            dataSet[position].click= !dataSet[position].click
            if (dataSet[position].click){
                dataSet[position].isFavouriteCity = !dataSet[position].isFavouriteCity
            }
            Toast.makeText(it.context,"شهر ${dataSet[position].name} به لیست اضافه شد ",Toast.LENGTH_SHORT).show()
        }

    }
    override fun getItemCount() = dataSet.size

}