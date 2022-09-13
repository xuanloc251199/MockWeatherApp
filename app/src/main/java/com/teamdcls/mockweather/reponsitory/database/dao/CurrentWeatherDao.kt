//package com.teamdcls.mockweather.reponsitory.database.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Update
//import com.teamdcls.mockweather.model.CurrentWeather
//
//@Dao
//interface CurrentWeatherDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertCurrentW(c: CurrentWeather)
//
//    @Update
//    suspend fun updateCurrentW(c: CurrentWeather)
//
//}