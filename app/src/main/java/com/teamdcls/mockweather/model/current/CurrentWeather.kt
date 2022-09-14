package com.teamdcls.mockweather.model.current
import com.google.gson.annotations.SerializedName

data class CurrentWeather (

    @SerializedName("Headline"       ) var Headline       : Headline?                 = Headline(),
    @SerializedName("DailyForecasts" ) var DailyForecasts : ArrayList<DailyForecasts> = arrayListOf()

)