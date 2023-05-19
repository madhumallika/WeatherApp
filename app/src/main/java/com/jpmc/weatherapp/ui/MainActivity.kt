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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchButton()
        }
    }

    @Preview
    @Composable
    fun SearchButton() {
        val cityName = remember { mutableStateOf("") }
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
        }
    }
}