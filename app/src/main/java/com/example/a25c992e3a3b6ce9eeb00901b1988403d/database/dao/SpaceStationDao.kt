package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.IDatabaseOperation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation

@Dao
interface SpaceStationDao:IDatabaseOperation<SpaceStation> {

    @Query("select * from SpaceStation where Name = :stationName")
    suspend fun getStationByName(stationName:String):SpaceStation

    @Query("select IsFavorite from SpaceStation where Name = :stationName")
    suspend fun stationIsFavorite(stationName:String):Boolean?

    @Query("select count(*) > 0 from SpaceStation")
    suspend fun stationIsLoad():Boolean

    @Query("select * from SpaceStation")
    suspend fun getAllStation():List<SpaceStation>

    @Query("select * from SpaceStation where IsFavorite = :isFavorite")
    suspend fun getFavoriteStateStation(isFavorite:Boolean = true):List<SpaceStation>

    @Query("delete from SpaceStation")
    suspend fun deleteAll()

}