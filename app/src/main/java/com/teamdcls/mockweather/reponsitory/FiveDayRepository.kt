package com.teamdcls.mockweather.reponsitory

import com.teamdcls.mockweather.interfaces.ApiService
import javax.inject.Inject

class FiveDayRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getFiveDay() = apiService.getWeather()
}