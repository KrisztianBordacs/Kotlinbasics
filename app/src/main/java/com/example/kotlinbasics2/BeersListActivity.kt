package com.example.kotlinbasics2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics2.adapter.BeersAdapter
import com.example.kotlinbasics2.model.Beer
import com.example.kotlinbasics2.model.BeersResponse
import com.example.kotlinbasics2.network.BeersService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeersListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_beers)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.beerList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.beerListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            fetchBeerList()
        }
    }

    private fun fetchBeerList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://punkapi.online/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val beerService = retrofit.create(BeersService::class.java)
        val call = beerService.getBeers()
        call.enqueue(object : Callback<List<Beer>> {
            override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
                if (response.isSuccessful) {
                    val beersResponse: List<Beer>? = response.body()
                    if (beersResponse != null) {
                        Log.e("Eredmény", beersResponse.toString())
                        recyclerView.adapter = BeersAdapter(beersResponse)
                    }
                }
            }

            override fun onFailure(call: Call<List<Beer>>, t: Throwable) {
                Log.e("Hiba", "${t.message}")
                Log.e("HIBA", "Hiba az API kérés során.")
            }
        })
    }
}

