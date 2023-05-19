package com.jpmc.weatherapp.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import com.jpmc.weatherapp.retrofit.OpenWeatherMapServiceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    @ApplicationContext private val context:Context,
    private val openWeatherMapService: OpenWeatherMapService
    ): ViewModel() {
    private val apiKey = "3a9bfd5d43d5acbd7972ef357d2c014b"
        fun fetchWeatherInfo(cityName:String) {
            viewModelScope.launch {
                val response = openWeatherMapService.getWeatherData(cityName,apiKey)
                if(response.isSuccessful){
                    val weatherResponse = response.body()
                    Toast.makeText(context,"got response",Toast.LENGTH_LONG)
                }
                else{
                    Toast.makeText(context,"Noresponse from the server",Toast.LENGTH_LONG).show()
                }
            }
            Toast.makeText(context,"Searching for $cityName weather info",Toast.LENGTH_SHORT).show()
        }
}