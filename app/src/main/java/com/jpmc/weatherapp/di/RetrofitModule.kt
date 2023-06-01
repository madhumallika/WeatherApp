package com.jpmc.weatherapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jpmc.weatherapp.repository.WeatherRepository
import com.jpmc.weatherapp.repository.WeatherRepositoryImpl
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import com.jpmc.weatherapp.retrofit.OpenWeatherMapServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson{
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    @Provides
    @Singleton
    fun provideOpenWeatherMapService(retrofit: Retrofit.Builder): OpenWeatherMapService {
        return retrofit
            .build()
            .create(OpenWeatherMapService::class.java)
    }
    @Provides
    @Singleton
    fun provideWeatherRepository(openWeatherMapService: OpenWeatherMapService):WeatherRepository{
        return WeatherRepositoryImpl(openWeatherMapService)
    }
}