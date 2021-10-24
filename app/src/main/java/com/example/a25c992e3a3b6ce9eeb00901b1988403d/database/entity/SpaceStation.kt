package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst

@Entity(tableName = DatabaseConst.SPACE_STATION_TABLE_NAME)
data class SpaceStation(
    @ColumnInfo(name = DatabaseConst.SPACE_STATION_ID_FIELD)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = DatabaseConst.SPACE_STATION_NAME_FIELD)
    val name: String,
    @ColumnInfo(name = DatabaseConst.SPACE_STATION_IS_FAVORITE_FIELD)
    val isFavorite: Boolean
)
