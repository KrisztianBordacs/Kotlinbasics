package com.example.kotlinbasics2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics2.model.CountResponse
import com.example.kotlinbasics2.network.NetworkHelper
import com.example.kotlinbasics2.network.UlesrendService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StudentCount : AppCompatActivity() {

    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_count)

        countTextView = findViewById(R.id.countTextView)

        // Ellenőrizzük a mobilnet állapotát
        if (NetworkHelper.isMobileDataEnabled(this)) {
            fetchStudentData()
        } else {
            Toast.makeText(this, "A mobilnet nincs bekapcsolva!", Toast.LENGTH_LONG).show()
        }
    }

    private fun fetchStudentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://banki13.komarom.net/2024/bordacsk/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val ulesrendService = retrofit.create(UlesrendService::class.java)
        val call = ulesrendService.getCount(true)

        call.enqueue(object : Callback<CountResponse> {
            override fun onResponse(
                call: Call<CountResponse>,
                response: Response<CountResponse>
            ) {
                Log.d("API_HÍVÁS", "Válasz kód: ${response.code()}")
                if (response.isSuccessful) {
                    val count = response.body()?.count
                    Log.d("Eredmény", count.toString())
                    countTextView.text = count.toString()
                } else {
                    Log.e("HIBA", "API válasz nem sikerült. Válasz: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<CountResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kérés során: ${t.message}")
            }
        })
    }
}
