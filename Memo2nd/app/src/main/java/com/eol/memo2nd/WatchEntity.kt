package com.eol.memo2nd

import androidx.room.Entity
import androidx.room.PrimaryKey

// 사이즈 소수점 입력하게 자료타입 설정. nullable 로해서 thickness 값도 등록하긔
// 위키시스템에 필요한 컬럼 고려해서 추가

@Entity(tableName = "watchData")
data class WatchEntity(
    @PrimaryKey(autoGenerate = true)
    val watchId:Long?,
    var brand:String,
    var collectionName:String,
    var refNumber:String?,
    var caseSize:Double?,
    var lugTolugSize:Double?,
    var thickness:Double?,
    var writer:String?,
    var dateTime:Long
)