package com.example.a302.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int i = 1;
    Button Btn_exit,Btn_Timeattack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn_exit = (Button) findViewById(R.id.btn_exit);
        Btn_Timeattack = (Button) findViewById(R.id.btn1);

        Btn_exit.setOnClickListener(this);
        Btn_Timeattack.setOnClickListener(this);

        Log.v("버튼","버튼지정");

        if (i == 1){
            Intent intent = new Intent(MainActivity.this,TimeAttack.class);
            startActivity(intent);
            i = 0;
            Log.v("버튼","버튼이동");
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn1:
                i = 1;
                break;
            case R.id.btn_exit:
                finish();
                break;
        }
    }
}
