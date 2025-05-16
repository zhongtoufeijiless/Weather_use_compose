package com.example.composedemo.data.model
 
data class Settings(
    val temperatureUnit: String, // "C" 或 "F"
    val language: String, // 语言代码，如 "zh"、"en"
    val notificationsEnabled: Boolean
) 