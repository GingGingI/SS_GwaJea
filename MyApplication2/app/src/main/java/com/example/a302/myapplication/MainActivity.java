package com.example.a302.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Etx;
    Button Btn,Btn_s;
    TextView Txv1,Txv2,TxvNum;
    int b[] = new int[10],a[] = new int[10], min , Gtx;
    int i = 0,j = -1,k = 0,temp,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxvNum = (TextView) findViewById(R.id.TxvPut);
        Txv1 = (TextView) findViewById(R.id.Txv1);
        Txv2 = (TextView) findViewById(R.id.Txv2);
        Etx = (EditText) findViewById(R.id.Edit1);
        Btn = (Button) findViewById(R.id.Btn1);
        Btn_s = (Button) findViewById(R.id.Btn_sort);

        Btn_s.setOnClickListener(this);
        Btn.setOnClickListener(this);
    }

    public void onClick (View v) {

        switch (v.getId()) {
            case R.id.Btn1:
                if (TextUtils.isEmpty(Etx.getText())) {
                    Etx.setError("숫자를 입력해주세요");
                    break;
                }
                Etx.setOnClickListener(this);
                Gtx = Integer.parseInt(Etx.getText().toString());

                b[i] = Gtx;
                i++;

                TxvNum.setText(Arrays.toString(b));
                break;

            case R.id.Btn_sort:
                min = 0;
                while (k < b.length-1) {
                    j+=1;
                    Log.i("실행", String.valueOf(j));

                    if (b[min] > b[j]){
                        Log.i("if min","실행");
                        min = j;
                        Log.i("min값",String.valueOf(b[min]));
                    }

                    if (j > b.length-2 ){
                        Log.i("if j > 9","검사");
                        temp = b[min];
                        b[min] = b[k];
                        b[k] = temp;

                        k+=1;
                        j = k;
                        min = k;
                        Log.i("K값 검사", String.valueOf(k)+"\t"+"J값 검사 :"+String.valueOf(j));
                    }
                }for (l = 0 ; l < 10 ; l++) {
                    a[l] = b[10 - l];
                    Log.i("변환",String.valueOf(l));
                }
                Txv1.setText(Arrays.toString(b));
                break;
        }
        if (i > 9){
            i = 0;
        }
    }
}
