package com.jpmc.weatherapp.repository

import com.jpmc.weatherapp.data.Main
import com.jpmc.weatherapp.data.WeatherData
import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val openWeatherMapService: OpenWeatherMapService): WeatherRepository {
    private val apiKey = "3a9bfd5d43d5acbd7972ef357d2c014b"
    override suspend fun getWeatherData(cityName: String): WeatherResponse {

       /*return try {
            val response = openWeatherMapService.getWeatherData(cityName, apiKey)
            if (response.isSuccessful) {
                val weatherResponse = response.body()!!
               // val temperature = weatherResponse?.main.temp
              Result.success(weatherResponse)
            }
            else{
                Result.failure(Throwable("failed to fetch weathre data"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }*/
        val response = openWeatherMapService.getWeatherData(cityName,apiKey)
        if(response.isSuccessful){
            val weatherResponse = response.body()
            if(weatherResponse != null){
                val name = weatherResponse.name
                val temp = weatherResponse.main.temp
                return WeatherResponse(name,temp)
            }
        }
        throw WeatherDataNotFoundException()
    }
}

class WeatherDataNotFoundException : Throwable() {

}
