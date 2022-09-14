package com.teamdcls.mockweather.reponsitory.api.cityrepository

import com.teamdcls.mockweather.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class CitiesRepository {
    fun searchCity(name:String) = flow {
        val rtf=RetrofitClient.retrofit.searchCity(apikey = Constant.API_KEY,q = name)
        emit(rtf)
    }.flowOn(Dispatchers.IO)
    fun searchCityByLatLon(lat:Double,lon:Double) = flow {
        val rtf=RetrofitClient.retrofit.searchCity(apikey = Constant.API_KEY,q = "$lat,$lon")
        emit(rtf)
    }.flowOn(Dispatchers.IO)

}