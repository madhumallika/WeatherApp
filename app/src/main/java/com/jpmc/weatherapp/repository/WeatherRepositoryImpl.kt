package com.jpmc.weatherapp.repository

import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val openWeatherMapService: OpenWeatherMapService): WeatherRepository {
    private val apiKey = "3a9bfd5d43d5acbd7972ef357d2c014b"
    override suspend fun getWeatherData(cityName: String): Result<WeatherResponse> {
        return try {
            val response = openWeatherMapService.getWeatherData(cityName,apiKey)
            if (response.isSuccessful && response.body() != null){
                val weatherData = response.body()!!
                Result.success(weatherData)
            }
            else{
                Result.failure(Exception("Exception"))
            }
        }catch(e:Exception){
            Result.failure(e)
        }
    }
}