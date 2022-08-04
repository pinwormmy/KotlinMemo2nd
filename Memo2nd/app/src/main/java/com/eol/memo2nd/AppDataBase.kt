package com.eol.memo2nd

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
// 디비 새로 파기


@Database(
    version = 1,
    entities = [ WatchEntity::class ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun watchDAO() : WatchSizeDAO

    companion object{

        private var instance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, AppDataBase::class.java,
                    "watchData-db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}

