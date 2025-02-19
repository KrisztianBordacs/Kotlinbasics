package com.example.kotlinbasics2.network

import com.example.kotlinbasics2.model.CountResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UlesrendService {
    @GET("controllers/api.php")
    fun getCount(
        @Query("count") count: Boolean
    ): Call<CountResponse>


}