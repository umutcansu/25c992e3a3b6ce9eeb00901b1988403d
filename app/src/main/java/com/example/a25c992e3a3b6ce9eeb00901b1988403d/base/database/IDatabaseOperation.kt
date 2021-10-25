package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface IDatabaseOperation<T>
{
    @Insert
    suspend fun insert(t :T):Long

    @Delete
    suspend fun delete(t :T)

    @Update
    suspend fun update(t :T)


}