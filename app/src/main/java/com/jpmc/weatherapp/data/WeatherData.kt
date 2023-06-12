package com.jpmc.weatherapp.data

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("base")
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)