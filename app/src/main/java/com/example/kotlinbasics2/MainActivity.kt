package com.example.kotlinbasics2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//https://api.openweathermap.org/data/2.5/weather?q=Budapest&units=metric&lang=hu&appid=8adf00444f23a8acb998eb856aa05b0e
class MainActivity : AppCompatActivity() {

    private lateinit var toGreetingButton: Button;
    private lateinit var toCalculatorButton: Button;
    private lateinit var toWeatherButton: Button
    private lateinit var toUserListButton: Button
    private lateinit var toRandomUserListButton : Button
    private lateinit var toCountButton: Button
    private lateinit var toColorButton: Button
    private lateinit var toBeerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        toGreetingButton = findViewById(R.id.toGreetingButton)
        toCalculatorButton = findViewById(R.id.toCalculatorButton)
        toWeatherButton = findViewById(R.id.toWeatherButton)
        toUserListButton = findViewById(R.id.toUserListButton)
        toRandomUserListButton = findViewById(R.id.toRandomUserListButton)
        toCountButton = findViewById(R.id.toCountButton)
        toColorButton = findViewById(R.id.toColorButton)
        toBeerButton = findViewById(R.id.toBeerButton)



        toGreetingButton.setOnClickListener() {
            val intent = Intent(this, GreetingActivity::class.java)
            startActivity(intent)
        }
        toCalculatorButton.setOnClickListener() {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        toWeatherButton.setOnClickListener() {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        toUserListButton.setOnClickListener() {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
        toRandomUserListButton.setOnClickListener() {
            val intent = Intent(this, RandomUserListActivity::class.java)
            startActivity(intent)
        }
        toCountButton.setOnClickListener() {
            val intent = Intent(this, StudentCount::class.java)
            startActivity(intent)
        }
        toColorButton.setOnClickListener() {
            val intent = Intent(this, ColorListActivity::class.java)
            startActivity(intent)
        }
        toBeerButton.setOnClickListener() {
            val intent = Intent(this, BeersListActivity::class.java)
            startActivity(intent)
        }
    }// ON CREATE
}
