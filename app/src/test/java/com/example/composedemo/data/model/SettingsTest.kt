package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SettingsTest {
    @Test
    fun testSettingsCreation() {
        val settings = Settings(
            temperatureUnit = "C",
            language = "zh",
            notificationsEnabled = true
        )
        assertEquals("C", settings.temperatureUnit)
        assertEquals("zh", settings.language)
        assertTrue(settings.notificationsEnabled)
    }
}
