package com.example.kotlinbasics2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.adapter.RandomUserAdapter
import com.example.kotlinbasics2.adapter.UserAdapter
import com.example.kotlinbasics2.model.RandomUserResponse
import com.example.kotlinbasics2.network.RandomUserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RandomUserListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_users)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.randomUserList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.randomUserListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchRandomUserList()
    }
        private fun fetchRandomUserList() {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val randomUserService = retrofit.create(RandomUserService::class.java)
            val call = randomUserService.getRandomUsers(10)
            call.enqueue(object : Callback<RandomUserResponse> {
                override fun onResponse(
                    call: Call<RandomUserResponse>,
                    response: Response<RandomUserResponse>
                ) {
                    if (response.isSuccessful) {
                       val user: RandomUserResponse? = response.body()
                        if(user != null){
                            Log.e("Eredmény", user.results.toString())
                            recyclerView.adapter = RandomUserAdapter(user.results)
                        }
                    }
                }

                override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                    Log.e("HIBA", "Hiba az API kérés során.")
                }

            })
        }

    }
