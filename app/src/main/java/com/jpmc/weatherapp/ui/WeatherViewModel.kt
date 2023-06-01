package com.jpmc.weatherapp.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import com.jpmc.weatherapp.retrofit.OpenWeatherMapServiceImpl
import com.jpmc.weatherapp.usecases.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    @ApplicationContext private val context:Context,
    private val getWeatherDataUseCase: GetWeatherDataUseCase
    ): ViewModel() {
    private val weatherData = MutableLiveData<Result<WeatherResponse>>()
    private val apiKey = "3a9bfd5d43d5acbd7972ef357d2c014b"
        fun fetchWeatherInfo(cityName:String) {
            viewModelScope.launch {
                weatherData.value = getWeatherDataUseCase(cityName)
            }
            Toast.makeText(context,"Searching for $cityName weather info",Toast.LENGTH_SHORT).show()
        }
}