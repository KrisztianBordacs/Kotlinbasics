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
import com.example.kotlinbasics2.adapter.ColorAdapter
import com.example.kotlinbasics2.model.ColorResponse
import com.example.kotlinbasics2.network.ColorService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ColorListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_color_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.colorList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.colorListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            fetchColorList()
        }
    }

    private fun fetchColorList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val colorService = retrofit.create(ColorService::class.java)
        val call = colorService.getColor(true)
        call.enqueue(object : Callback<ColorResponse> {
            override fun onResponse(call: Call<ColorResponse>, response: Response<ColorResponse>) {
                if (response.isSuccessful) {
                    val colorResponse: ColorResponse? = response.body()
                    if (colorResponse != null) {
                        Log.e("Eredmény", colorResponse.data.toString())
                        recyclerView.adapter = ColorAdapter(colorResponse.data)
                    }
                }
            }

            override fun onFailure(call: Call<ColorResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kérés során.")
            }
        })
    }
}
