package com.eol.memo2nd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchSize")
data class WatchEntity(
    @PrimaryKey(autoGenerate = true) val watchId:Long,
    var brand:String,
    var collectionName:String,
    var refNumber:String,
    var caseSize:Int,
    var lugTolugSize:Int,
    var dateTime:Long
)