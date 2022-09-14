package com.teamdcls.mockweather.reponsitory.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.teamdcls.mockweather.model.CityDatabase

@Dao
interface CityDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(city:CityDatabase)

    @Update
    suspend fun update(city:CityDatabase)

    @Delete
    suspend fun delete(city:CityDatabase)
    @Query(value = "SELECT * FROM tab_city")
    fun getCitiesLiveData(): LiveData<List<CityDatabase>>
    @Query(value = "SELECT * FROM tab_city")
    suspend fun getCities(): List<CityDatabase>
}