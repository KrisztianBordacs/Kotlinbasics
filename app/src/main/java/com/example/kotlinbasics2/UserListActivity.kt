package com.example.kotlinbasics2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.adapter.UserAdapter
import com.example.kotlinbasics2.model.User

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.userList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val users = listOf(
            User("Gipsz Jakab", "gj@email.hu", R.drawable.user),
            User("Kovács Péter", "kovacs.peter@email.hu", R.drawable.user),
            User("Nagy Anna", "nagy.anna@email.hu", R.drawable.profile),
            User("Szabó Judit", "szabo.judit@email.hu", R.drawable.user),
            User("Közepes Boglárka", "kozepes.boglarka@email.hu", R.drawable.profile),
            User("Közepes Boróka", "kozepes.boroka@email.hu", R.drawable.profile),
            User("Kiss Bíborka", "kiss.biborka@email.hu", R.drawable.profile),
            User("Nagy Béla", "nagy.bela@email.hu", R.drawable.user),
            User("Valaki József", "valaki.jozsef@email.hu", R.drawable.user),
            User("Kovács Ágnes", "kovacs.agnes@email.hu", R.drawable.profile),
            User("Nagy Zsófia", "nagy.zsofi@email.hu", R.drawable.profile),
            User("Szabó Ádám", "szabo.adam@email.hu", R.drawable.user),
            User("Molnár Péter", "molnar.peter@email.hu", R.drawable.user),
        )
        val recyclerView: RecyclerView = findViewById(R.id.userListRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)


    }
}