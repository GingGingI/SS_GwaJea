package com.example.a302.baktoebak;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String Timee;
    int i = 0;
    TextView num,Timmeer;
    Button BtnP , BtnM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (TextView) findViewById(R.id.num);
        Timmeer = (TextView) findViewById(R.id.Timmeer);
        BtnP = (Button) findViewById(R.id.Btnp);
        BtnM = (Button) findViewById(R.id.Btnm);

        BtnP.setOnClickListener(this);
        BtnM.setOnClickListener(this);

        Timmer.start();

    }
    CountDownTimer Timmer = new CountDownTimer(4000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            Timee = String.valueOf((int) (millisUntilFinished / 100) / 10);
            Timmeer.setText("Time :" +(Timee));
        }
        @Override
        public void onFinish() {
            if (i < 400) {
                i += 100;
            }else{
                i = 0;
            }
            num.setText(String.valueOf(i));
            Timmer.start();
        }
    };
    public void onClick (View v) {
     switch (v.getId()) {
         case R.id.Btnp :
             if (i < 400){
                 i += 100;
                 }else{
                 i = 0;
             }
             break;
         case R.id.Btnm :
             if (i > 0){
                 i -= 100;}
             else {
                 Toast.makeText(MainActivity.this, "0 이하로 내릴수 없습니다.", Toast.LENGTH_SHORT).show();}
             break;
     }
        num.setText(String.valueOf(i));
        Timmer.start();
    }
}
