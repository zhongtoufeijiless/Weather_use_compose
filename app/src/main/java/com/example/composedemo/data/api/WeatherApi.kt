package com.example.composedemo.data.api

import com.example.composedemo.data.model.*

interface WeatherApi {
    // 获取当前天气
    suspend fun getWeather(city: String): WeatherData
    // 获取天气预报
    suspend fun getForecast(city: String): List<ForecastData>
    // 获取历史天气
    suspend fun getWeatherHistory(city: String): List<WeatherHistory>
    // 获取极端天气
    suspend fun getExtremeWeather(city: String): List<ExtremeWeather>

    // 城市管理
    suspend fun getCities(): List<City>
    suspend fun addCity(city: City)
    suspend fun removeCity(cityId: String)

    // 设置项
    suspend fun getSettings(): Settings
    suspend fun updateSettings(settings: Settings)
}
