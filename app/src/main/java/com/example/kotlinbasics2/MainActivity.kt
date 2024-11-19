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
//1. feladat
    data class University (
        var universityName: String,
        var departments: Department
    )data class Department (
        var name:String,
        var professors:List<Professor>,
        var sutdents:List<Student>
    )data class Professor (
        var name: String,
        var subject: String
    )data class Student (
        var name:String,
        var sitdentId:String,
        var courses:List<Course>
    )data class Course (
        var curseName: String,
        var credits: Int
    )
//2. feladat
    data class Airport (
        var airportName: String,
        var terminals: List<Terminal>
    )data class Terminal (
        var terminalName: String,
        var flights: List<Flight>
    )data class Flight (
        var flightNumber: String,
        var destinaton: String,
        var airline: Airline
    )data class Airline (
        var name: String,
        var country: String
    )
//3. feladat
    data class Publisher (
        var pulisherName: String,
        var authors: List<Author>
    )data class Author (
        var authorName:String,
        var books: List<Book>
    )data class Book (
        var title: String,
        var year: Int,
        var ratings: List<Rating>
    )data class Rating (
        var rating: Int,
        var comment: String
    )
//4. feladat
    data class Agentcy (
        var agentcyName: String,
        var costumers: List<Costumer>
    )data class Costumer (
        var costumersId: String,
        var name: String,
        var email: String,
        var bookings: List<Booking>
    )data class Booking (
        var bookingId: String,
        @JsonProperty("package")
        var packageField: Package,
        var rating: Rating2?
    )data class Package (
        var packageId: String,
        var destinaton: String,
        var durrationDays: Int,
        var price: Int,
        var activities: List<Activity>
    )data class Rating2 (
        var score: Int,
        var comment: String
    )data class Activity (
        var activityName: String,
        var type: String
    )
    //Weather

}