package com.example.composedemo.data.api

import com.example.composedemo.data.model.*

class WeatherApiImpl(private val service: WeatherService) : WeatherApi {
    override suspend fun getWeather(city: String): WeatherData = service.getWeather(city)
    override suspend fun getForecast(city: String): List<ForecastData> = service.getForecast(city)
    override suspend fun getWeatherHistory(city: String): List<WeatherHistory> = service.getWeatherHistory(city)
    override suspend fun getExtremeWeather(city: String): List<ExtremeWeather> = service.getExtremeWeather(city)
    override suspend fun getCities(): List<City> = service.getCities()
    override suspend fun addCity(city: City) = service.addCity(city)
    override suspend fun removeCity(cityId: String) = service.removeCity(cityId)
    override suspend fun getSettings(): Settings = service.getSettings()
    override suspend fun updateSettings(settings: Settings) = service.updateSettings(settings)
}
