package com.example.composedemo.data.model

data class WeatherData(
    val city: String,
    val temperature: Double,
    val weather: String,
    val humidity: Int,
    val windSpeed: Double,
    val updateTime: String
) 