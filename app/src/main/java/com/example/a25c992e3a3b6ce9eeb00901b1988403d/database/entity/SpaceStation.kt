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
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_IS_FINISHED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_NAME_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_NEED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_STATION_STOCK_FIELD
import kotlin.math.pow
import kotlin.math.sqrt

@Entity(tableName = DatabaseConst.SPACE_STATION_TABLE_NAME)
data class SpaceStation(
    @ColumnInfo(name = SPACE_STATION_ID_FIELD)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = SPACE_STATION_NAME_FIELD)
    val name: String,
    @ColumnInfo(name = SPACE_STATION_CAPACITY_FIELD)
    var capacity: Int = 0,
    @ColumnInfo(name = SPACE_STATION_STOCK_FIELD)
    var stock: Int = 0,
    @ColumnInfo(name = SPACE_STATION_NEED_FIELD)
    var need: Int = 0,
    @ColumnInfo(name = SPACE_STATION_COORDINATE_X_FIELD)
    val coordinateX: Double = 0.0,
    @ColumnInfo(name = SPACE_STATION_COORDINATE_Y_FIELD)
    val coordinateY: Double = 0.0,
    @ColumnInfo(name = SPACE_STATION_IS_FAVORITE_FIELD)
    var isFavorite: Boolean,
    @ColumnInfo(name = SPACE_STATION_IS_FINISHED_FIELD)
    var isFinished: Boolean = false,
){

    fun calculateDistance(stationTwo: SpaceStation): Int {
        return sqrt(
            (stationTwo.coordinateY - this.coordinateY).pow(2.0) +
                    (stationTwo.coordinateX - this.coordinateX).pow(2.0)
        ).toInt()
    }
}
