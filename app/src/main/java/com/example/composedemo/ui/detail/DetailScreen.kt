package com.example.composedemo.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composedemo.viewmodel.DetailViewModel

@Composable
fun DetailScreen(viewModel: DetailViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "天气详情", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // 假数据展示
        Text(text = "温度：26°")
        Text(text = "湿度：60%")
        Text(text = "风速：3m/s")
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(viewModel = DetailViewModel())
} 