package com.jpmc.weatherapp.repository

import com.jpmc.weatherapp.data.WeatherData
import com.jpmc.weatherapp.data.WeatherResponse

interface WeatherRepository {
    suspend fun getWeatherData(cityName:String) : WeatherResponse
}