package com.example.composedemo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {
    // 预留城市管理相关状态和方法

    // 城市列表 State
    val cityList: SnapshotStateList<String> = mutableStateListOf(
        "北京", "上海", "广州"
    )
} 