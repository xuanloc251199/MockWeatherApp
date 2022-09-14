package com.teamdcls.mockweather.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.teamdcls.mockweather.reponsitory.database.WeatherDataBase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CitiesVM(app: Application) : AndroidViewModel(app) {
    private val cityDao = WeatherDataBase.getInstance(app.applicationContext).cityDao()

    val cities = cityDao.getCitiesLiveData()
    val citi = flow {
        emit(cityDao.getCities())

    }

}