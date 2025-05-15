package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class ExtremeWeatherTest {
    @Test
    fun testExtremeWeatherCreation() {
        val extreme = ExtremeWeather(
            date = "2024-06-01",
            event = "暴雨",
            description = "24小时降雨量超过100毫米"
        )
        assertEquals("2024-06-01", extreme.date)
        assertEquals("暴雨", extreme.event)
        assertEquals("24小时降雨量超过100毫米", extreme.description)
    }
}
