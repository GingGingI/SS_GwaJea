package com.example.a302.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    long mid, sum = 0, i = 1;
    int teen;
    char aki;
    TextView aski, two, eight, sixt, sixty;
    EditText ten;
    Button gogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aski = (TextView) findViewById(R.id.aski);
        two = (TextView) findViewById(R.id.two);
        eight = (TextView) findViewById(R.id.aski);
        sixt = (TextView) findViewById(R.id.aski);
        sixty = (TextView) findViewById(R.id.aski);
        ten = (EditText) findViewById(R.id.Etx);
        gogo = (Button) findViewById(R.id.Btn);

        gogo.setOnClickListener(this);
    }

}