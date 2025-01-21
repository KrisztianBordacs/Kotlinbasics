package com.example.kotlinbasics2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.R
import com.example.kotlinbasics2.model.User

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val emailText: TextView = itemView.findViewById(R.id.emailText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item, parent,
                false
            )
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameText.text = user.name
        holder.emailText.text = user.email
        holder.profileImage.setImageResource(user.profileImage)
    }

    override fun getItemCount() = userList.size

}