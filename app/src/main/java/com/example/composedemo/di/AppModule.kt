package com.example.composedemo.di

import com.example.composedemo.data.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MockApi

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost/") // TODO: 替换为实际后端地址
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
    @Singleton
    @RealApi
    fun provideWeatherApi(service: WeatherService): WeatherApi =
        WeatherApiImpl(service)

    @Provides
    @Singleton
    @MockApi
    fun provideMockWeatherApi(): WeatherApi = MockWeatherApi()
} 