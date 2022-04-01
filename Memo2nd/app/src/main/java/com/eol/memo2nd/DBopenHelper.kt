package com.eol.memo2nd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// SQLiteOpenHelper 상속받아 SQLite 를 사용하도록 하겠습니다.
class DBopenHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    //onCreate(), onUpgrade() 두가지 메소드를 오버라이드 받아 줍시다.

    //데이터베이스가 만들어 지지않은 상태에서만 작동합니다. 이미 만들어져 있는 상태라면 실행되지 않습니다.
    override fun onCreate(db: SQLiteDatabase?) {
        //테이블을 생성할 쿼리를 작성하여 줍시다.
        val create = "create table memo (userId integer primary key, memoContent text, dateTime integer)"
        //실행시켜 줍니다.
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    //insert 메소드
    fun insertMemo(memo:Memo){
        val values = ContentValues()
        //넘겨줄 컬럼의 매개변수 지정
        values.put("content",memo.memoContent)
        values.put("datetime",memo.dateTime)
        //쓰기나 수정이 가능한 데이터베이스 변수
        val wd = writableDatabase
        wd.insert("memo",null,values)
        //사용이 끝나면 반드시 close()를 사용하여 메모리누수 가 되지않도록 합시다.
        wd.close()
    }


    //select 메소드
    fun selectMemo():MutableList<Memo>{
        val list = mutableListOf<Memo>()
        //전체조회
        val selectAll = "select * from memo"
        //읽기전용 데이터베이스 변수
        val rd = readableDatabase
        //데이터를 받아 줍니다.
        val cursor = rd.rawQuery(selectAll,null)

        //반복문을 사용하여 list 에 데이터를 넘겨 줍시다.
        while(cursor.moveToNext()){
            val userId = cursor.getLong(cursor.getColumnIndexOrThrow("userId"))
            val memoContent = cursor.getString(cursor.getColumnIndexOrThrow("memoContent"))
            val dateTime = cursor.getLong(cursor.getColumnIndexOrThrow("dateTime"))

            list.add(Memo(userId,memoContent,dateTime))
        }
        cursor.close()
        rd.close()

        return list
    }

    //update 메소드
    fun updateMemo(memo:Memo){
        val values = ContentValues()

        values.put("content",memo.memoContent)
        values.put("datetime",memo.dateTime)

        val wd = writableDatabase
        wd.update("memo",values,"userId=${memo.userId}",null)
        wd.close()

    }

    //delete 메소드
    fun deleteMemo(memo:Memo){
        val delete = "delete from Memo where userId = ${memo.userId}"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()

    }

}