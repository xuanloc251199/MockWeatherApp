package com.teamdcls.mockweather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamdcls.mockweather.ApiState
import com.teamdcls.mockweather.model.current.CurrentWeather
import com.teamdcls.mockweather.reponsitory.CurrentWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentVM
@Inject constructor(private var repository: CurrentWeatherRepository) : ViewModel() {
    private val _response = MutableLiveData<CurrentWeather>()
    val weatherResponse: LiveData<CurrentWeather>
        get() = _response


    init {
        getWeather()
    }

    fun getWeather() = viewModelScope.launch {
        repository.getWeather().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }
}

