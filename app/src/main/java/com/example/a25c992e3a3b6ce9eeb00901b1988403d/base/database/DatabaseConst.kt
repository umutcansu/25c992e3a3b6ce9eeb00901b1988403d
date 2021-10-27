package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database

object DatabaseConst {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "APP_DATABASE"

    const val SPACE_SHUTTLE_DEFAULT_STATION_NAME = "Dünya"
    const val SPACE_SHUTTLE_DEFAULT_DAMAGE_VALUE = 100
    const val DAMAGE_DS_FACTOR = 10
    const val UGS_FACTOR = 10_000
    const val EUS_FACTOR = 20
    const val DS_FACTOR = 10_000

    const val SPACE_SHUTTLE_TABLE_NAME = "SpaceShuttle"
    const val SPACE_SHUTTLE_ID_FIELD = "Id"
    const val SPACE_SHUTTLE_NAME_FIELD = "Name"
    const val SPACE_SHUTTLE_SPEED_FIELD = "Speed"
    const val SPACE_SHUTTLE_CAPACITY_FIELD = "Capacity"
    const val SPACE_SHUTTLE_DURABILITY_FIELD = "Durability"
    const val SPACE_SHUTTLE_CURRENT_STATION_FIELD = "CurrentStation"
    const val SPACE_SHUTTLE_UGS_FIELD = "UGS"
    const val SPACE_SHUTTLE_EUS_FIELD = "EUS"
    const val SPACE_SHUTTLE_DS_FIELD = "DS"
    const val SPACE_SHUTTLE_DAMAGE_FIELD = "Damage"

    const val SPACE_STATION_TABLE_NAME = "SpaceStation"
    const val SPACE_STATION_ID_FIELD = "Id"
    const val SPACE_STATION_NAME_FIELD = "Name"
    const val SPACE_STATION_IS_FAVORITE_FIELD = "IsFavorite"
    const val SPACE_STATION_CAPACITY_FIELD = "Capacity"
    const val SPACE_STATION_STOCK_FIELD = "Stock"
    const val SPACE_STATION_COORDINATE_X_FIELD = "CoordinateX"
    const val SPACE_STATION_COORDINATE_Y_FIELD = "CoordinateY"
    const val SPACE_STATION_NEED_FIELD = "Need"

}