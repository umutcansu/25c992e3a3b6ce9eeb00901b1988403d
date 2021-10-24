package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.IDatabaseOperation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle

@Dao
interface SpaceShuttleDao : IDatabaseOperation<SpaceShuttle> {


    @Query("select * from SpaceShuttle")
    suspend fun getAllList():List<SpaceShuttle>

    @Query("select count(*) from SpaceShuttle")
    suspend fun getAllCount():Long
}