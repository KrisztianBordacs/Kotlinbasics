package com.example.kotlinbasics2.network

import com.example.kotlinbasics2.model.ColorResponse
import com.example.kotlinbasics2.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorService {

    @GET("/api/unknown")
    fun getColor(
        @Query("unknown") unknown: Boolean
    ): Call<ColorResponse>


}