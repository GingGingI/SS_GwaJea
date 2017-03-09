package com.example.a302.androiddbstudy2;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 302 on 2017-03-09.
 */
public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context, String name,
                    CursorFactory cursorFactory, int version) {
        super(context, name, cursorFactory, version);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table MyDB" +
                "(id integer primary key autoincrement, "+
                "name text, "+
                "age integer, "+
                "num text);";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "drop table if exists MyDB;";
        onCreate(db);
    }
}
