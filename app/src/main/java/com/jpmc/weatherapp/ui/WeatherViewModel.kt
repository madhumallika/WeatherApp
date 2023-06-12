package com.jpmc.weatherapp.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jpmc.weatherapp.data.WeatherData
import com.jpmc.weatherapp.data.WeatherResponse
import com.jpmc.weatherapp.retrofit.OpenWeatherMapService
import com.jpmc.weatherapp.retrofit.OpenWeatherMapServiceImpl
import com.jpmc.weatherapp.usecases.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    @ApplicationContext private val context:Context,
    private val getWeatherDataUseCase: GetWeatherDataUseCase
    ): ViewModel() {
    //val weatherData = MutableLiveData<Result<WeatherData>>()
    private var _temperature = MutableStateFlow<Double?>(null)
    val temperature: StateFlow<Double?> get() = _temperature
    private val apiKey = "3a9bfd5d43d5acbd7972ef357d2c014b"

    fun fetchWeatherInfo(cityName:String) {
        viewModelScope.launch {
            try {
                viewModelScope.launch {
                    val weatherData = getWeatherDataUseCase(cityName)
                    _temperature.value = weatherData.temperature
                }
            }catch (e:Exception){}
        }

    }
}