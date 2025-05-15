package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherDataTest {
    @Test
    fun testWeatherDataCreation() {
        val data = WeatherData(
            city = "北京",
            temperature = 25.0,
            weather = "晴",
            humidity = 60,
            windSpeed = 3.5,
            updateTime = "2024-06-01 12:00"
        )
        assertEquals("北京", data.city)
        assertEquals(25.0, data.temperature, 0.01)
        assertEquals("晴", data.weather)
        assertEquals(60, data.humidity)
        assertEquals(3.5, data.windSpeed, 0.01)
        assertEquals("2024-06-01 12:00", data.updateTime)
    }
}
