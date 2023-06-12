package com.jpmc.weatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherInfo(viewModel)
        }
    }


    @Composable
    fun WeatherInfo(viewModel:WeatherViewModel) {
        val cityName = remember { mutableStateOf("") }
        val temperature by viewModel.temperature.collectAsState()
        Column(Modifier.padding(16.dp)) {
            TextField(
                value = cityName.value,
                onValueChange = { cityName.value= it },
                label = { Text("Enter city name") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {viewModel.fetchWeatherInfo(cityName.value)},
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Search")
            }
           if(temperature != null){
               Text(
                   text = "Temperature: ${temperature.toString()}°C",
                   style = TextStyle(fontSize = 24.sp),
                   modifier = Modifier.padding(top = 16.dp)
               )
           }
        }
    }
}