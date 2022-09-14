package com.teamdcls.mockweather

open class Constant {
    companion object{
        const val LOCATION_KEY = "352954"
        const val API_KEY = "65XECsiHB4h4BZeGsqwQyGsAtYUZS8wq"
        const val BASE_URL = "http://dataservice.accuweather.com"
        const val FORECASTS = "/forecasts/v1"
        const val SEARCH = "/locations/v1/cities/search?apikey=$API_KEY&q="
        const val SEARCH_GEOPOSITION = "/locations/v1/cities/search"
    }
}