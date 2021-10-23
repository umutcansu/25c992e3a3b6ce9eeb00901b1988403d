package com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.DATABASE_NAME
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.DATABASE_VERSION
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_CAPACITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_DURABILITY_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_NAME_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_SPEED_FIELD
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst.SPACE_SHUTTLE_TABLE_NAME
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.dao.SpaceShuttleDao
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle

@Database(entities = [SpaceShuttle::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun spaceShuttleDao(): SpaceShuttleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(lock) {
            INSTANCE ?: makeDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun makeDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().fallbackToDestructiveMigration().addCallback(roomCallback)
                .build()
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL(seedQuery)
            }

        }

        private val seedQuery = """
            insert into $SPACE_SHUTTLE_TABLE_NAME 
            (
                $SPACE_SHUTTLE_NAME_FIELD, 
                $SPACE_SHUTTLE_SPEED_FIELD,
                $SPACE_SHUTTLE_CAPACITY_FIELD,
                $SPACE_SHUTTLE_DURABILITY_FIELD
            )
            values
            (
                "Sample",
                50.0,
                30.0,
                20.0
            );
            """.trim()
    }
}