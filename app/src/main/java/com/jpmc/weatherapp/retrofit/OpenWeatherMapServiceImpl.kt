package com.jpmc.weatherapp.retrofit

import com.jpmc.weatherapp.data.WeatherData
import com.jpmc.weatherapp.data.WeatherResponse
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class OpenWeatherMapServiceImpl @Inject constructor(): OpenWeatherMapService {
    @Inject
    lateinit var retrofit: Retrofit

    private val apiService: OpenWeatherMapService by lazy {
        retrofit.create(OpenWeatherMapService::class.java)
    }
    override suspend fun getWeatherData(
        cityName: String,
        apiKey: String
    ): Response<WeatherData> {
        return apiService.getWeatherData(cityName,apiKey)
    }
}