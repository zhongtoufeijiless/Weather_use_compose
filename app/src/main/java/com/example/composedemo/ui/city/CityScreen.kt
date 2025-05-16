package com.example.composedemo.ui.city

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composedemo.viewmodel.CityViewModel
import com.example.composedemo.ui.components.CityListItem

@Composable
fun CityScreen(viewModel: CityViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "城市管理", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // 城市列表
        viewModel.cityList.forEach { city ->
            CityListItem(cityName = city)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityScreenPreview() {
    val fakeViewModel = CityViewModel()
    CityScreen(viewModel = fakeViewModel)
} 