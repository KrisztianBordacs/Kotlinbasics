package com.example.kotlinbasics2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//https://api.openweathermap.org/data/2.5/weather?q=Budapest&units=metric&lang=hu&appid=8adf00444f23a8acb998eb856aa05b0e
class MainActivity : AppCompatActivity() {

    private lateinit var toGreetingButton: Button;
    private lateinit var toCalculatorButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toGreetingButton = findViewById(R.id.toGreetingButton)
        toCalculatorButton = findViewById(R.id.toCalculatorButton)


        toGreetingButton.setOnClickListener() {
            val intent = Intent(this,GreetingActivity::class.java)
            startActivity(intent)
        }
        toCalculatorButton.setOnClickListener() {
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}