package com.teamdcls.mockweather.viewmodel.city

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamdcls.mockweather.model.CityDatabase
import com.teamdcls.mockweather.reponsitory.api.cityrepository.ApiState
import com.teamdcls.mockweather.reponsitory.api.cityrepository.CitiesRepository
import com.teamdcls.mockweather.reponsitory.database.WeatherDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CityVM(private var repository: CitiesRepository, context: Context) : ViewModel() {
    private val cityDao = WeatherDataBase.getInstance(context.applicationContext).cityDao()
    val dataCities: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    fun searchCity(name: String) = viewModelScope.launch {
        dataCities.value = ApiState.Loading
        repository.searchCity(name)
            .catch { e -> dataCities.value = ApiState.Failure(e) }
            .collect { data -> dataCities.value = ApiState.Success(data) }
    }

    fun searchCityByLatLon(lat: Double, lon: Double) =
        viewModelScope.launch {
            dataCities.value = ApiState.Loading
            repository.searchCityByLatLon(lat, lon)
                .catch { e -> dataCities.value = ApiState.Failure(e) }
                .collect { data -> dataCities.value = ApiState.Success(data) }
        }
    fun insertCity(c:CityDatabase)
    {
        viewModelScope.launch(Dispatchers.IO) {
            cityDao.insert(c)
        }
    }
}
