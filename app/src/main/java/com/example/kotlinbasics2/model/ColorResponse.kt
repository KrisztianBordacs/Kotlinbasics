package com.example.kotlinbasics2.model


data class ColorResponse(
    val data: List<Data>
)

data class Data(
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
)


