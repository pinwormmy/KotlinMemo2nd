package com.eol.memo2nd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WatchSizeDAO {
    @Query("SELECT * FROM watchSize")
    fun showAll(): List<WatchEntity>

    @Insert
    fun writeWatch(vararg watch:WatchEntity)

    @Delete
    fun deleteWatch(watch:WatchEntity)
}