package com.example.composedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composedemo.viewmodel.HomeViewModel
import com.example.composedemo.ui.theme.ComposedemoTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val weather = viewModel.weather.collectAsState().value
    val lifeIndex = viewModel.lifeIndex.collectAsState().value
    val hourForecast = viewModel.hourForecast.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF60A5FA), Color(0xFFDBEAFE))
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 顶部栏
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: 城市选择 */ }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "城市")
                    Text(text = weather?.city ?: "-", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                IconButton(onClick = { /* TODO: 设置 */ }) {
                    Icon(Icons.Default.Settings, contentDescription = "设置")
                }
            }
            // 天气信息
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = weather?.temperature?.toInt()?.toString()?.plus("°") ?: "-", fontSize = 56.sp, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = com.example.composedemo.R.drawable.ic_weather_sun),
                        contentDescription = "天气图标",
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = weather?.weather ?: "-", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .background(Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(id = com.example.composedemo.R.drawable.ic_weather_sun),
                        contentDescription = "天气大图标",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = "体感 ${weather?.temperature?.toInt() ?: "-"}° | 优",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            // 生活指数
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                lifeIndex.forEach { item ->
                    Column(
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .padding(12.dp)
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = item.name,
                            modifier = Modifier.size(28.dp)
                        )
                        Text(text = item.name, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
                        Text(text = item.value, fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
            // 气温/降水曲线（占位）
            Box(
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.White, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "气温/降水概率曲线", fontSize = 12.sp, color = Color.Gray)
            }
            // 未来预报
            Column(
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "未来24小时", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "未来7天", fontSize = 12.sp, color = Color.Gray)
                }
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    hourForecast.forEach { item ->
                        Column(
                            modifier = Modifier.width(60.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = item.hour, fontSize = 12.sp)
                            Image(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.hour,
                                modifier = Modifier.size(24.dp)
                            )
                            Text(text = item.temp, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposedemoTheme {
        HomeScreen()
    }
} 