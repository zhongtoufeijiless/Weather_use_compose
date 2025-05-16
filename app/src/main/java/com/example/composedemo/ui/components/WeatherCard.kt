package com.example.composedemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeatherCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .width(120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherCardPreview() {
    WeatherCard(title = "温度", value = "26°")
} 