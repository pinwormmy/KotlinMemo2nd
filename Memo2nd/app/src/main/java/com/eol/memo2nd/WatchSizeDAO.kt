package com.eol.memo2nd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WatchSizeDAO {

    @Query("SELECT * FROM watchData")
    fun showAll(): List<WatchEntity>

    @Query("SELECT * FROM watchData WHERE (brand || collectionName || refNumber) like '%' || :keyword || '%'")
    fun showSearch(keyword: String) : List<WatchEntity>

    @Insert
    fun writeWatch(vararg watch:WatchEntity)

    @Delete
    fun deleteWatch(watch:WatchEntity)
}