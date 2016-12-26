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
        db.execSQL("CREATE TABLE TOUCH (_id INTEGER PRIMARY KEY AUTOINCREMENT, Touch INTEGER)");
    }

    // DB업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(int Touch){
        //DB읽기
        SQLiteDatabase db = getWritableDatabase();
        //입력한 값으로 행 추가
        db.execSQL("INSERT INTO TOUCH VALUES(null, '" + Touch +"');");
        db.close();
    }

    
}
