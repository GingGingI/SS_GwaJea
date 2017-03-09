package com.example.a302.androiddbstudy2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //http://blog.naver.com/tinatan/70176627062
    DBHelper dbHelper;
    SQLiteDatabase db;
    ArrayList<hooman> al = new ArrayList<hooman>();
    Button btnInsert, btnDelete, btnUpdate, btnSelectAll, btnRun;
    EditText et1, et2, et3;
    TextView tv;
    int state = 0;
    mAdapter adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button) findViewById(R.id.btn_insert);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnSelectAll = (Button) findViewById(R.id.btn_selectAll);
        btnRun = (Button) findViewById(R.id.btn_run);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        tv = (TextView) findViewById(R.id.textView_title);
        lv = (ListView) findViewById(R.id.listView1);

        //db 를 연결하자~!
        dbHelper = new DBHelper(MainActivity.this,"MyDB.db",null,1);

        //DB파일이 없을경우 파일생성을 유도하기위해 더미생성
        String fileChk = ""
    }
}
