package com.example.kotlinbasics2.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.R
import com.example.kotlinbasics2.model.Data


class ColorAdapter(private val colorList: List<Data>) :
    RecyclerView.Adapter<ColorAdapter.ColorListViewHolder>()
{
    class ColorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorView: View = itemView.findViewById(R.id.colorView)
        val colorText: TextView = itemView.findViewById(R.id.colorText)
        val yearText: TextView = itemView.findViewById(R.id.yearText)
        val pantoneValueText: TextView = itemView.findViewById(R.id.pantoneValueText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ColorListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_color, parent,
                false
            )
        return ColorListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ColorListViewHolder, position: Int) {
        val colorItem = colorList[position]
        holder.colorText.text = colorItem.color
        holder.yearText.text = colorItem.year.toString()
        holder.pantoneValueText.text = colorItem.pantone_value
        try {
            val colorHex = colorItem.color
            val colorInt = Color.parseColor(colorHex)
            holder.colorView.setBackgroundColor(colorInt)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }


    override fun getItemCount() = colorList.size

}
