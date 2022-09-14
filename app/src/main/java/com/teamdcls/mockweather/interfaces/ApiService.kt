package com.teamdcls.mockweather.interfaces

import com.teamdcls.mockweather.Constant.API_KEY
import com.teamdcls.mockweather.Constant.FORECASTS
import com.teamdcls.mockweather.Constant.LOCATION_KEY
import com.teamdcls.mockweather.model.current.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("$FORECASTS/daily/1day/$LOCATION_KEY?apikey=$API_KEY&language=vi-vn&details=true&metric=true")
    suspend fun getWeather(): Response<CurrentWeather>

    @GET("$FORECASTS/daily/5day/$LOCATION_KEY?apikey=$API_KEY&language=vi-vn&metric=true")
    suspend fun getFiveDay(): Response<CurrentWeather>



}