package com.jpmc.weatherapp.usecases

import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherDataUseCase(private val weatherRepository: WeatherRepository) {
    @Inject
    suspend operator fun invoke(cityName:String): Result<WeatherResponse> {
        return weatherRepository.getWeatherData(cityName)
    }
}