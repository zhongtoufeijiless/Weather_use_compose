package com.example.composedemo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityListItem(cityName: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Card(modifier = modifier
        .padding(vertical = 4.dp)
        .clickable { onClick() }) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = cityName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityListItemPreview() {
    CityListItem(cityName = "北京")
} 