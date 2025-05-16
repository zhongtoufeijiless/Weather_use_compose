package com.example.composedemo.data.api

import com.example.composedemo.data.model.*
import javax.inject.Inject

class MockWeatherApi @Inject constructor() : WeatherApi {
    override suspend fun getWeather(city: String): WeatherData =
        WeatherData(city, 26.5, "晴", 55, 2.3, "2024-06-01 14:00")

    override suspend fun getForecast(city: String): List<ForecastData> =
        listOf(
            ForecastData("2024-06-02", 30.0, 22.0, "多云"),
            ForecastData("2024-06-03", 28.0, 21.0, "小雨")
        )

    override suspend fun getWeatherHistory(city: String): List<WeatherHistory> =
        listOf(
            WeatherHistory("2024-05-30", 22.0, "小雨"),
            WeatherHistory("2024-05-29", 24.0, "阴")
        )

    override suspend fun getExtremeWeather(city: String): List<ExtremeWeather> =
        listOf(
            ExtremeWeather("2024-05-20", "暴雨", "24小时降雨量超过100毫米")
        )

    override suspend fun getCities(): List<City> =
        listOf(
            City("1", "北京", 39.90, 116.40),
            City("2", "上海", 31.23, 121.47)
        )

    override suspend fun addCity(city: City) { /* no-op for mock */ }
    override suspend fun removeCity(cityId: String) { /* no-op for mock */ }

    override suspend fun getSettings(): Settings =
        Settings("C", "zh", true)

    override suspend fun updateSettings(settings: Settings) { /* no-op for mock */ }
}
