package com.jpmc.weatherapp.di

import com.jpmc.weatherapp.repository.WeatherRepository
import com.jpmc.weatherapp.usecases.GetWeatherDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCasesModule {
    @Provides
    fun provideGetWeatherDataUseCase(weatherRepository: WeatherRepository):GetWeatherDataUseCase {
      return GetWeatherDataUseCase(weatherRepository)
    }

}