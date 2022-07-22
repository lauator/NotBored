package com.example.notbored.data.suggestion

import com.example.notbored.data.dto.BoredSuggestion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredSuggestionService {

    @GET("activity")
    fun getRandom(): Call<BoredSuggestion>

    @GET("activity")
    fun getRandomParticipants(@Query("participants") numberOfParticipants: Int): Call<BoredSuggestion>

    @GET("activity")
    fun get(@Query("participants") numberOfParticipants: Int, @Query("type") typeOfActivity: String): Call<BoredSuggestion>

    @GET("activity")
    fun getWithOutParticipants(@Query("type") typeOfActivity: String): Call<BoredSuggestion>
}