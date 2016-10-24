package com.example.a302.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;

public class TimeAttack extends AppCompatActivity implements View.OnClickListener{

    Animation Slide_f_R,Slide_t_L;
    LinearLayout gg;
    Random rand = new Random();
    int score = 0,Nm1,Nm2,i,j,over = 0;
    Button Btn1,Btn2,Btn3,pause,Finish;
    TextView Num1,Num2,Score,dap,time1,T_Score;
    String Nu2,Nu1,Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack);
        //랜덤돌리고 답찾기
        {
            Nm1 = rand.nextInt(100) + 1;
            Nm2 = rand.nextInt(100) + 1;

            Nu1 = String.valueOf(Nm1);
            Nu2 = String.valueOf(Nm2);

            if (Nm1 > Nm2) {
                j = 1;
            } else if (Nm1 == Nm2) {
                j = 2;
            } else if (Nm1 < Nm2) {
                j = 3;
            }
        }

        //뷰 지정
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
        dap = (TextView) findViewById(R.id.dap);
        time1 = (TextView) findViewById(R.id.Time1);



        Num1.setText(Nu1);
        Num2.setText(Nu2);
        dap.setText("?");
        Btn1.setText(">");
        Btn2.setText("=");
        Btn3.setText("<");

        //클릭 리스너 지정
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        pause.setOnClickListener(this);
        Finish.setOnClickListener(this);

    }

    CountDownTimer Timme = new CountDownTimer(3000 , 100) {
        @Override
        public void onTick(long millisUntilFinished) {
            Timer = String.valueOf((float) (millisUntilFinished / 100) / 10);
            time1.setText(Timer);
        }
        @Override
        public void onFinish() {
            over = 1;
            gg.setVisibility(View.VISIBLE);
            gg.startAnimation(Slide_f_R);
            Timme.cancel();
        }
    }.start();

    public void onClick(View v) {


        switch(v.getId()) {
            case R.id.Btn1:
                if (over == 0) {
                    i = 1;
                    Timme.start();
                }
                break;
            case R.id.Btn2:
                if (over == 0) {
                    i = 2;
                    Timme.start();
                }
                break;
            case R.id.Btn3:
                if (over == 0) {
                    i = 3;
                    Timme.start();
                }
                break;
            case R.id.back:
                Timme.onFinish();
                break;
            case R.id.Btn_finish:
                finish();
                gg.setVisibility(View.GONE);
                over = 0;
                break;
        }

        if (i == j) {
            score++;
            Nm1 = rand.nextInt(100) + 1;
            Nm2 = rand.nextInt(100) + 1;

            Nu1 = String.valueOf(Nm1);
            Nu2 = String.valueOf(Nm2);

            Log.v("답1",""+Nm1);
            Log.v("답2",""+Nm2);
            if (Nm1 > Nm2) {
                j = 1;
            } else if (Nm1 == Nm2) {
                j = 2;
            } else if (Nm1 < Nm2) {
                j = 3;
            }

            Num1.setText(Nu1);
            Num2.setText(Nu2);

        }else {
            over = 1;
            gg.setVisibility(View.VISIBLE);
            gg.startAnimation(Slide_f_R);
            Timme.cancel();
        }
        String asdf = String.valueOf(score);

        Score.setText("score : "+asdf);
        T_Score.setText("score : "+asdf);
    }

}
