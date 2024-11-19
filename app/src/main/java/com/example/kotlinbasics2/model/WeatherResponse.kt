package com.example.kotlinbasics2.model

data class WeatherResponse(
    val main:Main
)
data class Main (
    val temp: Double
)
