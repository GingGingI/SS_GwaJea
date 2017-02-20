package com.example.a302.androiddbstudy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 302 on 2016-12-26.
 */
public class DB extends SQLiteOpenHelper{

    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //새로운 테이블 생성
        String sql = "create table dbs("+
                "_id integer primary key autoincrement, "+
                "name text, "+
                "age Integer, "+
                "address text)";

        db.execSQL(sql);
    }

    // DB업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // db = 적용할 db, old/new 구버전/신버전
    // db 버전이 업그레이드 되었을 때 실행되는 메소드

        String sql = "drop table if exists student";
        db.execSQL(sql);

        onCreate(db);
    }
    
}
