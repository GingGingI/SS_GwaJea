package com.example.a302.androiddbstudy;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DB DataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBase = new DB(MainActivity.this,
                "DBStudy.db",  // 파일명
                null, //커서 팩토리
                1); // 버전 번호

        // 데이터 저장
        insert("유저1",18,"ㅇ?");// dbs,age,address
        insert("유저2",28,"ㅇ??");
        insert("유저3",28,"ㅇ???");

        //수정하기
        update("유저1",58);

        //삭제하기
        delete("유저2");

        //조회
        select();
    }

    public void insert(String name,int age,String address) {
        db = DataBase.getWritableDatabase(); // db객체 가져오기

        ContentValues values = new ContentValues();
        //db.insert 의 매개변수인 value가 ContentValues 변수이므로 그에 맞춤
        //데이터의 삽입은 put을이용
        values.put("name",name);
        values.put("age",age);
        values.put("address",address);
        db.insert("dbs",null,values); // 테이블/널컬럼핵/데이터
    }

    public void update (String name, int age) {
        db = DataBase.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("age",age);
        db.update("dbs",values,"name=?",new String[]{name});
    }

    public void delete (String name) {
        db = DataBase.getWritableDatabase();
        db.delete("dbs","name=?", new String[]{name});
        Log.i("db",name+ "정상적으로 삭제대어땅");
    }

    public void select(){

        // db의 데이터를 읽어와서, 결과저장 , 해당 데이터를 꺼내 사용

        db = DataBase.getWritableDatabase();
        Cursor c = db.query("dbs",null,null,null,null,null,null);
        while(c.moveToNext()) {
            int _id = c.getInt(c.getColumnIndex("_id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));
            Log.i("db","id: "+_id+", name: "+name+"age: "+age
                    +"address: "+address);

            TextView tv = (TextView)findViewById(R.id.Tv);
            tv.append(_id+","+name+","+address+"\n");
        }
    }
}
