package com.example.a302.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Etx;
    Button Btn;
    TextView Txv1,Txv2,TxvNum;
    int b[] = new int[10], min , Gtx;
    int i = 0,j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxvNum = (TextView) findViewById(R.id.TxvPut);
        Txv1 = (TextView) findViewById(R.id.Txv1);
        Txv2 = (TextView) findViewById(R.id.Txv2);
        Etx = (EditText) findViewById(R.id.Edit1);
        Btn = (Button) findViewById(R.id.Btn1);

        Btn.setOnClickListener(this);
    }

    public void onClick (View v) {


        switch (v.getId()) {
            case R.id.Btn1:
              if (TextUtils.isEmpty(Etx.getText())){
                    Etx.setError("숫자를 입력해주세요");
                    break;
            }
                Etx.setOnClickListener(this);
                Gtx = Integer.parseInt(Etx.getText().toString().trim());

                b[i] = Gtx;
                i++;

                TxvNum.setText(Arrays.toString(b));
                break;
            }
        if (i > 9){
            i = 0;
        }
    }
}
