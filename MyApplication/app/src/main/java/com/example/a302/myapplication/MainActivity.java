package com.example.a302.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Btn_exit,Btn_Timeattack,Btn_TimeattackPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_exit = (Button) findViewById(R.id.btn_exit);
        Btn_Timeattack = (Button) findViewById(R.id.btn1);
        Btn_TimeattackPlus = (Button) findViewById(R.id.btn2);

        Btn_exit.setOnClickListener(this);
        Btn_Timeattack.setOnClickListener(this);
        Btn_TimeattackPlus.setOnClickListener(this);

        Log.v("버튼","버튼지정");

        }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn1:
                Intent intent = new Intent(MainActivity.this,TimeAttack.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                Intent intent1 = new Intent(MainActivity.this,TimeAttackPlus.class);
                startActivity(intent1);
                break;

            case R.id.btn_exit:
                finish();
                break;
        }
    }
}
