package com.example.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.data.api.MockWeatherApi
import com.example.composedemo.data.model.WeatherData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// 生活指数数据结构
data class LifeIndex(val iconRes: Int, val name: String, val value: String)
// 未来小时预报数据结构
data class HourForecast(val hour: String, val iconRes: Int, val temp: String)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherApi: MockWeatherApi
) : ViewModel() {
    private val _weather = MutableStateFlow<WeatherData?>(null)
    val weather: StateFlow<WeatherData?> = _weather

    private val _lifeIndex = MutableStateFlow<List<LifeIndex>>(emptyList())
    val lifeIndex: StateFlow<List<LifeIndex>> = _lifeIndex

    private val _hourForecast = MutableStateFlow<List<HourForecast>>(emptyList())
    val hourForecast: StateFlow<List<HourForecast>> = _hourForecast

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _weather.value = weatherApi.getWeather("北京")
            _lifeIndex.value = listOf(
                LifeIndex(iconRes = com.example.composedemo.R.drawable.ic_life_tshirt, name = "穿衣", value = "适宜"),
                LifeIndex(iconRes = com.example.composedemo.R.drawable.ic_weather_sun, name = "紫外线", value = "较强"),
                LifeIndex(iconRes = com.example.composedemo.R.drawable.ic_life_running, name = "运动", value = "适宜")
            )
            _hourForecast.value = listOf(
                HourForecast("14时", com.example.composedemo.R.drawable.ic_weather_cloud_sun, "25°"),
                HourForecast("15时", com.example.composedemo.R.drawable.ic_weather_rain, "23°"),
                HourForecast("16时", com.example.composedemo.R.drawable.ic_weather_sun, "26°")
            )
        }
    }
} 