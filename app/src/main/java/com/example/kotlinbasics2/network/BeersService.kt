package com.example.kotlinbasics2.network

import com.example.kotlinbasics2.model.BeersResponse
import com.example.kotlinbasics2.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BeersService {

    @GET("beers?page=1")
    fun getBeers(): Call<BeersResponse>
}