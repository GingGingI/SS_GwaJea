package com.example.a302.ar_db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 302 on 2017-03-21.
 * http://pulsebeat.tistory.com/15
 */
public class MarketDBAdapter {

    public static final String KEY_TITLE = "title";
    public static final String KEY_BODY = "body";
    public static final String KEY_ROWID = "_id";
    private static final String TAG = "MarketDBAdapter";

    private static final String DATABASE_CREATE = "crate table Market (_id interger primary key autoincrement, "
            + "title text not null, body text not null);";

    private static final String DATABASE_NAME = "Data";
    private static final String DATABASE_TABLE = "Market";
    private static final int DATABASE_VERSION = 1;
    private final Context mCtx;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDB;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "이버전으로부터 :" + oldVersion + "이버전으로:" + newVersion
                    + "업그레이드합니다." +
                    ",또한 모든 이전 데이터를 파괴합니다.");
            db.execSQL("DROP TABLE IF EXISTS Market");
            onCreate(db);
        }
    }

    public MarketDBAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public MarketDBAdapter open() throws SQLException {

    }
}
