package com.example.kotlinbasics2.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.kotlinbasics2.model.RandomUserResponse

interface RandomUserService {

    @GET("/api/")
    fun getRandomUsers(
        @Query("results")result: Int
    ): Call<RandomUserResponse>

}