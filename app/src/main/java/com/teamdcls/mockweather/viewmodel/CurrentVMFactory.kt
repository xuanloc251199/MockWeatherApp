package com.teamdcls.mockweather.viewmodel

//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.teamdcls.mockweather.reponsitory.database.dao.CurrentWeatherDao
//
//
//class CurrentVMFactory(
//    private val current: CurrentWeatherDao,
//) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CurrentVM::class.java)) {
//            return CurrentVM(current) as T
//        }
//        return super.create(modelClass)
//    }
//}
