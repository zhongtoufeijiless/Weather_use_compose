package com.example.composedemo.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class CityTest {
    @Test
    fun testCityCreation() {
        val city = City(
            id = "1",
            name = "上海",
            latitude = 31.23,
            longitude = 121.47
        )
        assertEquals("1", city.id)
        assertEquals("上海", city.name)
        assertEquals(31.23, city.latitude, 0.01)
        assertEquals(121.47, city.longitude, 0.01)
    }
}
