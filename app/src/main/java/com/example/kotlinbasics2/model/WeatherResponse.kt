package com.example.kotlinbasics2.model

data class WeatherResponse(
    val main: Main,
    val wind: Wind
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val humidity: Int
)

data class Wind(
    val speed: Double
)
