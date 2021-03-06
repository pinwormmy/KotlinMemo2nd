package com.eol.memo2nd

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
// 수동 마이그레이션 추가해서 다시 수정
// 코드 자체는 공식 사이트에 다 있고 별거없지않나? 테스트까지하는건 보류
// 마이그레이션 안되면 db새로 생성 (버전 업데이트때문에 안될 수 있어서)

@Database(
    version = 2, // 수정해야함
    entities = [ WatchEntity::class ]
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

