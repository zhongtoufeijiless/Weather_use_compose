package com.example.composedemo.data.api

import com.example.composedemo.data.model.WeatherData
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiImplTest {
    private lateinit var server: MockWebServer
    private lateinit var service: WeatherService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun testGetWeather() = runBlocking {
        val mockJson = """
            {
                "city": "北京",
                "temperature": 25.0,
                "weather": "晴",
                "humidity": 60,
                "windSpeed": 3.5,
                "updateTime": "2024-06-01 12:00"
            }
        """.trimIndent()
        server.enqueue(MockResponse().setBody(mockJson).setResponseCode(200))
        val result = service.getWeather("北京")
        assertEquals("北京", result.city)
        assertEquals(25.0, result.temperature, 0.01)
        assertEquals("晴", result.weather)
        assertEquals(60, result.humidity)
        assertEquals(3.5, result.windSpeed, 0.01)
        assertEquals("2024-06-01 12:00", result.updateTime)
    }
}
