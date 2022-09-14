package com.teamdcls.mockweather.reponsitory.api.cityrepository

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val e: Throwable) : ApiState()
    class Success(val data: Any) : ApiState()
    object Empty : ApiState()
}