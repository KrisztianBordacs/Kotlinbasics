package com.example.kotlinbasics2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.R
import com.example.kotlinbasics2.model.RUser

class RandomUserAdapter(private val randomUserList: List<RUser>) :
    RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>()
    {
        class RandomUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val profileImage: ImageView = itemView.findViewById(R.id.profileImageView)
            val nameText: TextView = itemView.findViewById(R.id.nameTextView)
            val emailText: TextView = itemView.findViewById(R.id.emailTextView)
            val country: TextView = itemView.findViewById(R.id.countryTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RandomUserViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_randomuser, parent,
                    false
                )
            return RandomUserViewHolder(view)
        }

        override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
            val user = randomUserList[position]
            val name = user.name.last + user.name.first
            holder.nameText.text = name
            holder.emailText.text = user.email
            if(user.gender == "female"){
            holder.profileImage.setImageResource(R.drawable.profile)
            }else{
             holder.profileImage.setImageResource(R.drawable.user)
            }
            holder.country.text = user.location.country
            //holder.profileImage.setImageURI(Uri.parse(user.picture.medium))
        }

        override fun getItemCount() = randomUserList.size

    }
