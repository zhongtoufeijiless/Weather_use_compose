package com.example.composedemo.ui.city

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composedemo.viewmodel.CityViewModel

@Composable
fun CityScreen(viewModel: CityViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "城市管理", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // 假数据列表
        repeat(3) { idx ->
            Text(text = "城市 ${idx+1}", modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityScreenPreview() {
    CityScreen(viewModel = CityViewModel())
} 