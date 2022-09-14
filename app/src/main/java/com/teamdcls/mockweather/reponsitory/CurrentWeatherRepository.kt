package com.teamdcls.mockweather.reponsitory

import com.teamdcls.mockweather.RetrofitClient
import com.teamdcls.mockweather.interfaces.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CurrentWeatherRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeather()
}