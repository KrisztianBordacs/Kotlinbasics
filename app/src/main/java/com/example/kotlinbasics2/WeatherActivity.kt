package com.example.kotlinbasics2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics2.model.WeatherResponse
import com.example.kotlinbasics2.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {
    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var cityEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var humidityTextView: TextView
    private lateinit var windTextView: TextView
    private val apiKey = "8adf00444f23a8acb998eb856aa05b0e"

    private var temperatureString = ""
    private var feelString = ""
    private var humidityString = ""
    private var windSpeedString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.weather)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //UI Elemek inicializálása
        temperatureTextView = findViewById(R.id.temperatureTextView)
        cityTextView = findViewById(R.id.cityTextView)
        cityEditText = findViewById(R.id.cityEditText)
        searchButton = findViewById(R.id.searchButton)
        humidityTextView = findViewById(R.id.humidityTextView)
        windTextView = findViewById(R.id.windTextView)


        searchButton.setOnClickListener() {
            if (cityEditText.text.isNotEmpty() || cityEditText.text.isNotBlank()) {
                fetchWeatherData()
                cityTextView.text = cityEditText.text.toString()
                cityEditText.visibility = View.GONE
                searchButton.visibility = View.INVISIBLE
                cityTextView.visibility = View.VISIBLE
                temperatureTextView.visibility = View.VISIBLE
                humidityTextView.visibility = View.VISIBLE
                windTextView.visibility = View.VISIBLE

                cityEditText.setText("")
                hideKeyboard()
            }
        }

    }

    private fun fetchWeatherData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)
        val call = weatherService.getWeather(cityEditText.text.toString(), "metric", "hu", apiKey)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val weatherTemp = weatherResponse.main.temp
                        val weatherTempFeel = weatherResponse.main.feels_like
                        val weatherHumidity = weatherResponse.main.humidity
                        val weatherWindSpeed = weatherResponse.wind.speed
                        temperatureString = resources.getString(R.string.temperature)
                        feelString = resources.getString(R.string.feel)
                        humidityString = resources.getString(R.string.humidity)
                        windSpeedString = resources.getString(R.string.wind_speed)
                        temperatureTextView.text =
                            "$temperatureString: " + weatherTemp.toString() + "°C\n $feelString: " + weatherTempFeel.toString() + "°C"
                        humidityTextView.text = "$humidityString: " + weatherHumidity.toString()
                        windTextView.text =
                            "$windSpeedString: " + weatherWindSpeed.toString() + " km/h"
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kérés során.")
            }

        })
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(cityEditText.windowToken, 0)
    }

}