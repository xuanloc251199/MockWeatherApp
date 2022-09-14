package com.teamdcls.mockweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamdcls.mockweather.reponsitory.CurrentWeatherRepository


class CurrentVMFactory(
    private var repository: CurrentWeatherRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrentVM::class.java)) {
            return CurrentVM(repository) as T
        }
        return super.create(modelClass)
    }
}
