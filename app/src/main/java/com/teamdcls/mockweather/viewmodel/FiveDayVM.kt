package com.teamdcls.mockweather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamdcls.mockweather.model.current.CurrentWeather
import com.teamdcls.mockweather.reponsitory.FiveDayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiveDayVM
@Inject constructor(private var repository: FiveDayRepository) : ViewModel() {
    private val _response = MutableLiveData<CurrentWeather>()
    val weatherResponse: LiveData<CurrentWeather>
        get() = _response


    init {
        getFiveDay()
    }

    fun getFiveDay() = viewModelScope.launch {
        repository.getFiveDay().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getFiveDay Error: ${response.code()}")
            }
        }
    }
}