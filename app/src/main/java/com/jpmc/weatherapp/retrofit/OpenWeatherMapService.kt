package com.jpmc.weatherapp.retrofit

import com.jpmc.weatherapp.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapService {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") cityName:String,
        @Query("appid") apiKey: String
    ): Response<WeatherResponse>
}