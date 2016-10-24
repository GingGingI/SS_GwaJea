package com.example.a302.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class TimeAttackPlus extends AppCompatActivity implements View.OnClickListener{

    Animation Slide_f_R,Slide_t_L;
    LinearLayout gg;
    Random rand = new Random();
    int score = 0,Nm1,Nm2,Nm3,Nm4,Nmm1,Nmm2,i,j,over = 0,r1,r2;
    Button Btn1,Btn2,Btn3,pause,Finish;
    TextView Num1,Num2,Num3,Num4,Score,dap,time1,T_Score;
    String Nu1,Nu2,Nu3,Nu4,Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack_plus);

        Slide_f_R = AnimationUtils.loadAnimation(this,R.anim.slide_form_right);
        Slide_t_L = AnimationUtils.loadAnimation(this,R.anim.slide_to_left);
        Finish = (Button) findViewById(R.id.Btn_finish);
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn3 = (Button) findViewById(R.id.Btn3);
        pause = (Button) findViewById(R.id.back);
        gg = (LinearLayout) findViewById(R.id.GG);
        T_Score = (TextView) findViewById(R.id.text_Score);
        Score = (TextView) findViewById(R.id.Score);
        Num1 = (TextView) findViewById(R.id.Num1);
        Num2 = (TextView) findViewById(R.id.Num2);
        Num3 = (TextView) findViewById(R.id.Num3);
        Num4 = (TextView) findViewById(R.id.Num4);
        dap = (TextView) findViewById(R.id.dap);
        time1 = (TextView) findViewById(R.id.Time1);

        Nm1 = rand.nextInt(100) + 1;
        Nm2 = rand.nextInt(100) + 1;
        Nm3 = rand.nextInt(100) + 1;
        Nm4 = rand.nextInt(100) + 1;
        r1 = rand.nextInt(4) + 1;
        r2 = rand.nextInt(4) + 1;

        if ((Nm1 - Nm2) < 0)
        {
            Nm1 = rand.nextInt(100) + 1;
            Nm2 = rand.nextInt(100) + 1;
        }
        if ((Nm3 - Nm4) < 0)
        {
            Nm3 = rand.nextInt(100) + 1;
            Nm4 = rand.nextInt(100) + 1;
        }

        Nu1 = String.valueOf(Nm1);
        Nu2 = String.valueOf(Nm2);
        Nu3 = String.valueOf(Nm3);
        Nu4 = String.valueOf(Nm4);

        switch (r1) {
            case 1:
                Nmm1 = Nm1 + Nm2;
                break;
            case 2:
                Nmm1 = Nm1 - Nm2;
                break;
            case 3:
                Nmm1 = Nm1 * Nm2;
                break;
            case 4:
                Nmm1 = Nm1 / Nm2;
                break;
            //1 : 더하기 , 2 : 빼기 , 3 : 곱하기 , 4 : 나누기
        }

        switch (r2) {
            case 1:
                Nmm2 = Nm3 + Nm4;
                break;
            case 2:
                Nmm2 = Nm3 - Nm4;
                break;
            case 3:
                Nmm2 = Nm3 * Nm4;
                break;
            case 4:
                Nmm2 = Nm3 / Nm4;
                break;
            //1 : 더하기 , 2 : 빼기 , 3 : 곱하기 , 4 : 나누기
        }

        Num1.setText(Nu1);
        Num2.setText(Nu2);
        Num3.setText(Nu1);
        Num4.setText(Nu2);
        dap.setText("?");
        Btn1.setText(">");
        Btn2.setText("=");
        Btn3.setText("<");

        //리스너 지정
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        pause.setOnClickListener(this);
        Finish.setOnClickListener(this);

        if (Nmm1 > Nmm2) {
            j = 1;
        } else if (Nmm1 == Nmm2) {
            j = 2;
        } else if (Nmm1 < Nmm2) {
            j = 3;
        }
    }

    public void onClick(View v){

    }
}
