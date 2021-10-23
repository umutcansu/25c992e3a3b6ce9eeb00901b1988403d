package com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_CAPACITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DURABILITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_ID_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_NAME_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_SPEED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_TABLE_NAME


@Entity(tableName = SPACE_SHUTTLE_TABLE_NAME)
data class SpaceShuttle(
    @ColumnInfo(name = SPACE_SHUTTLE_ID_FIELD)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = SPACE_SHUTTLE_NAME_FIELD)
    var name: String = "",
    @ColumnInfo(name = SPACE_SHUTTLE_SPEED_FIELD)
    var speed: Double = 1.0,
    @ColumnInfo(name = SPACE_SHUTTLE_CAPACITY_FIELD)
    var capacity: Double = 1.0,
    @ColumnInfo(name = SPACE_SHUTTLE_DURABILITY_FIELD)
    var durability: Double = 1.0,
)
