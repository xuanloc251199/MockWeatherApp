//package com.teamdcls.mockweather.reponsitory.database
//
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.teamdcls.mockweather.model.current.CurrentWeather
//import com.teamdcls.mockweather.reponsitory.database.dao.CurrentWeatherDao
//
//@Database(entities = [CurrentWeather::class], version = 1, exportSchema = false)
//abstract class WeatherDataBase : RoomDatabase() {
//
//    abstract fun currentWeatherDao(): CurrentWeatherDao
//
//    companion object {
//        private var instance: WeatherDataBase? = null
//
//        //singleton pattern
//        @Synchronized
//        fun getInstance(ctx: Context): WeatherDataBase {
//            if (instance == null) {
//                //data/data/package/database/weather.db
//                instance = Room.databaseBuilder(
//                    ctx.applicationContext,
//                    WeatherDataBase::class.java,
//                    "weather.db"
//                )
//                    .allowMainThreadQueries()
//                    .build()
//            }
//            return instance!!
//        }
//    }
//}