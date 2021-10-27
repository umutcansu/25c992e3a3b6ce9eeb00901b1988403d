package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_CAPACITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_CURRENT_STATION_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DAMAGE_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DEFAULT_DAMAGE_VALUE
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DEFAULT_STATION_NAME
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DS_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DURABILITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_EUS_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_ID_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_NAME_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_SPEED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_TABLE_NAME
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_UGS_FIELD


@Entity(tableName = SPACE_SHUTTLE_TABLE_NAME)
data class SpaceShuttle(
    @ColumnInfo(name = SPACE_SHUTTLE_ID_FIELD)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = SPACE_SHUTTLE_NAME_FIELD)
    var name: String = "",
    @ColumnInfo(name = SPACE_SHUTTLE_SPEED_FIELD)
    var speed: Int = 0,
    @ColumnInfo(name = SPACE_SHUTTLE_CAPACITY_FIELD)
    var capacity: Int = 0,
    @ColumnInfo(name = SPACE_SHUTTLE_DURABILITY_FIELD)
    var durability: Int = 0,
    @ColumnInfo(name = SPACE_SHUTTLE_CURRENT_STATION_FIELD)
    var currentStation: String = SPACE_SHUTTLE_DEFAULT_STATION_NAME,
    @ColumnInfo(name = SPACE_SHUTTLE_UGS_FIELD)
    var UGS: Int,
    @ColumnInfo(name = SPACE_SHUTTLE_EUS_FIELD)
    var EUS: Int,
    @ColumnInfo(name = SPACE_SHUTTLE_DS_FIELD)
    var DS: Int,
    @ColumnInfo(name = SPACE_SHUTTLE_DAMAGE_FIELD)
    var damage: Int = SPACE_SHUTTLE_DEFAULT_DAMAGE_VALUE
)
