package com.example.a302.androiddbstduy2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String winner;

    private static final int dialogShow = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int pan[] = new int [25];
        final dice d=new dice();
        d.a();
        Button b=(Button)findViewById(R.id.Btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.a();
                int a= d.outn();
                nuser.a += a;
                Log.i("내 주사위 값:",""+a);
                d.a();

                int b= d.outn();
                ncom.b += b;
                Log.i("컴퓨터 주사위 값:",""+b);
                TextView tv = (TextView)findViewById(R.id.Txv);

                if (nuser.a >= pan.length || ncom.b >= pan.length){
                    if (nuser.a >= pan.length) winner = "당신의 승리!";
                    if (ncom.b >= pan.length) winner = "컴퓨터의 승리!";
                    if (nuser.a >= pan.length && ncom.b >= pan.length){
                        winner = "무승부;;";}
                    showDialog(dialogShow);
                }
                tv.setText("당신:"+nuser.a+"\n컴퓨터:"+ncom.b);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch(id) {
           case dialogShow:
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(this);
            builder.setTitle("이긴자는???")
                    .setMessage(winner+"")
                    .setCancelable(false)
                    .setPositiveButton("종료",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    nuser.a = 0;
                                    ncom.b = 0;
                                    MainActivity.this.finish();
                                }
                            }) .setNegativeButton("재시작",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            nuser.a = 0;
                            ncom.b = 0;
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            return alert;
        }
        return null;
    }
}
class nuser {
    public static int a=0;
}
class ncom {
    public static int b=0;
}

class dice {
    Random rand = new Random();
    int n = 0;
    public dice(){
        n = 0;
    }
    void a(){
      n = rand.nextInt(6);
    }
    int outn(){
        return n;
    }
    void aa(int a){

    }
}

