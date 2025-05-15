package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherHistoryTest {
    @Test
    fun testWeatherHistoryCreation() {
        val history = WeatherHistory(
            date = "2024-05-30",
            temperature = 22.0,
            weather = "小雨"
        )
        assertEquals("2024-05-30", history.date)
        assertEquals(22.0, history.temperature, 0.01)
        assertEquals("小雨", history.weather)
    }
}
