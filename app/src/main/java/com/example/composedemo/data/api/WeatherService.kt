package com.example.composedemo.data.api

import com.example.composedemo.data.model.*
import retrofit2.http.*

interface WeatherService {
    @GET("weather")
    suspend fun getWeather(@Query("city") city: String): WeatherData

    @GET("forecast")
    suspend fun getForecast(@Query("city") city: String): List<ForecastData>

    @GET("history")
    suspend fun getWeatherHistory(@Query("city") city: String): List<WeatherHistory>

    @GET("extreme")
    suspend fun getExtremeWeather(@Query("city") city: String): List<ExtremeWeather>

    @GET("cities")
    suspend fun getCities(): List<City>

    @POST("cities")
    suspend fun addCity(@Body city: City)

    @DELETE("cities/{id}")
    suspend fun removeCity(@Path("id") cityId: String)

    @GET("settings")
    suspend fun getSettings(): Settings

    @PUT("settings")
    suspend fun updateSettings(@Body settings: Settings)
} 