package com.teamdcls.mockweather.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tab_city")
data class CityDatabase(
    @ColumnInfo(name = "city_key")
    @PrimaryKey
    var city_key:String,
    @ColumnInfo(name = "city_name")
    var name:String,
    @ColumnInfo(name = "city_region")
    val region:String,
    @ColumnInfo(name = "city_country")
    val country:String,
    @ColumnInfo(name = "city_time_zone")
    val timeZone: String,
    @ColumnInfo(name = "city_lat")
    var lat:Double,
    @ColumnInfo(name = "city_lon")
    var lon:Double
) {
}