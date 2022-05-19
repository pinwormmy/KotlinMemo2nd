package com.eol.memo2nd

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
// 오토마이그레이션 안되는 항목인듯.(컬럼 타입 변경) 다시 수정!!
@Database(
    version = 2,
    entities = [ WatchEntity.class ],
    autoMigrations = [
        @AutoMigration (from = 1, to = 2)
    ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun watchDAO() : WatchSizeDAO

    companion object{

        private var instance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase?{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext, AppDataBase::class.java,
                    "database-watchSize")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}