package com.teamdcls.mockweather.viewmodel.city

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamdcls.mockweather.reponsitory.api.cityrepository.CitiesRepository

@Suppress("UNCHECKED_CAST")
class CityVMFactory(private val repository: CitiesRepository,private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CityVM(repository, context) as T
    }
}