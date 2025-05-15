package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ForecastDataTest {
    @Test
    fun testForecastDataCreation() {
        val forecast = ForecastData(
            date = "2024-06-02",
            temperatureHigh = 30.0,
            temperatureLow = 20.0,
            weather = "多云"
        )
        assertEquals("2024-06-02", forecast.date)
        assertEquals(30.0, forecast.temperatureHigh, 0.01)
        assertEquals(20.0, forecast.temperatureLow, 0.01)
        assertEquals("多云", forecast.weather)
    }
}
