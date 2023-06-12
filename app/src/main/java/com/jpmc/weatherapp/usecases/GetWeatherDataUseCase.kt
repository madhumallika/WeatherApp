package com.jpmc.weatherapp.usecases

import com.jpmc.weatherapp.data.WeatherData
import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.repository.WeatherRepository
import com.jpmc.weatherapp.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetWeatherDataUseCase(private val weatherRepositoryimpl: WeatherRepositoryImpl) {
    @Inject
    suspend operator fun invoke(cityName:String): WeatherResponse {
        return weatherRepositoryimpl.getWeatherData(cityName)
    }
}