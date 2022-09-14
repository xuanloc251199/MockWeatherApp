package com.teamdcls.mockweather.reponsitory.api.cityrepository


import com.teamdcls.mockweather.Constant
import com.teamdcls.mockweather.model.Cities
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET(Constant.SEARCH)
    suspend fun searchCity(@Query("apikey") apikey: String, @Query("q") q: String):List<Cities>

    @GET(Constant.SEARCH_GEOPOSITION)
    suspend fun searchCityByLatLon(@Query("apikey") apikey: String, @Query("q") q: String):List<Cities>
}