package com.example.kotlinbasics2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.R
import com.example.kotlinbasics2.model.Beer


class BeersAdapter(private val beerList: List<Beer>) :
    RecyclerView.Adapter<BeersAdapter.BeerListViewHolder>()
{
    class BeerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val beerNameTextView: TextView = itemView.findViewById(R.id.beerNameText)
        val beerDescriptionText: TextView = itemView.findViewById(R.id.beerDescriptionText)
        val contributedByTextView: TextView = itemView.findViewById(R.id.beerContributedByText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BeerListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.beers_item, parent,
                false
            )
        return BeerListViewHolder(view)
    }


    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        val beersItem = beerList[position]
        holder.beerNameTextView.text = beersItem.name
        holder.beerDescriptionText.text = beersItem.description
        holder.contributedByTextView.text = beersItem.contributed_by

    }


    override fun getItemCount() = beerList.size

}
