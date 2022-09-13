//package com.teamdcls.mockweather.model
//import android.os.Parcelable
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.ForeignKey
//import androidx.room.ForeignKey.CASCADE
//import androidx.room.PrimaryKey
//import com.teamdcls.mockweather.model.Cities
//import kotlinx.android.parcel.Parcelize
//import java.util.*
//
//@Parcelize
//@Entity(
//    tableName = "current_weathers",
//    foreignKeys = [
//        ForeignKey(
//            entity = Cities::class,
//            onDelete = CASCADE,
//            parentColumns = ["id"],
//            childColumns = ["city_id"]
//        )
//    ]
//)
//data class CurrentWeather(
//    @PrimaryKey
//    @ColumnInfo(name = "city_id")
//    val cityId: Long,
//    @ColumnInfo(name = "cloudiness")
//    val cloudiness: Long,
//    @ColumnInfo(name = "main")
//    val main: String,
//    @ColumnInfo(name = "description")
//    val description: String,
//    @ColumnInfo(name = "icon")
//    val icon: String,
//    @ColumnInfo(name = "temperature")
//    val temperature: Double,
//    @ColumnInfo(name = "pressure")
//    val pressure: Double,
//    @ColumnInfo(name = "humidity")
//    val humidity: Long,
//    @ColumnInfo(name = "temperature_min")
//    val temperatureMin: Double,
//    @ColumnInfo(name = "temperature_max")
//    val temperatureMax: Double,
//    @ColumnInfo(name = "win_speed")
//    val winSpeed: Double,
//    @ColumnInfo(name = "win_degrees")
//    val winDegrees: Double,
//    @ColumnInfo(name = "data_time")
//    val dataTime: Date,
//    @ColumnInfo(name = "rain_volume_for_last_3_hours")
//    val rainVolumeForThe3Hours: Double,
//    @ColumnInfo(name = "snow_volume_for_last_3_hours")
//    val snowVolumeForThe3Hours: Double,
//    @ColumnInfo(name = "visibilityKm")
//    val visibility: Double,
//    @ColumnInfo(name = "sunrise")
//    val sunrise: Date,
//    @ColumnInfo(name = "sunset")
//    val sunset: Date,
//    @ColumnInfo(name = "weather_condition_id")
//    val weatherConditionId: Long
//) : Parcelable