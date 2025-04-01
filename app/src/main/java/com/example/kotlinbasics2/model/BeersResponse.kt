package com.example.kotlinbasics2.model

data class BeersResponse (
    val beers: List<Beer>
)
data class Beer (
    val name: String,
    val description: String,
    val contributed_by: String
)