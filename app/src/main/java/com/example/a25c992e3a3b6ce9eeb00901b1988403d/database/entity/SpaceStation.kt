package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_CAPACITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_COORDINATE_X_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_COORDINATE_Y_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_ID_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_IS_FAVORITE_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_NAME_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_NEED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_STOCK_FIELD

@Entity(tableName = DatabaseConst.SPACE_STATION_TABLE_NAME)
data class SpaceStation(
    @ColumnInfo(name = SPACE_STATION_ID_FIELD)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = SPACE_STATION_NAME_FIELD)
    val name: String,
    @ColumnInfo(name = SPACE_STATION_CAPACITY_FIELD)
    var capacity: Long = 0,
    @ColumnInfo(name = SPACE_STATION_STOCK_FIELD)
    var stock: Long = 0,
    @ColumnInfo(name = SPACE_STATION_NEED_FIELD)
    val need: Long = 0,
    @ColumnInfo(name = SPACE_STATION_COORDINATE_X_FIELD)
    val coordinateX: Double = 0.0,
    @ColumnInfo(name = SPACE_STATION_COORDINATE_Y_FIELD)
    val coordinateY: Double = 0.0,
    @ColumnInfo(name = SPACE_STATION_IS_FAVORITE_FIELD)
    var isFavorite: Boolean,
)
