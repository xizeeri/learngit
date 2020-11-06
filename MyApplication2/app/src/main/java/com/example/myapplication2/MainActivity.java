package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String etinput;
    boolean clear_flag;

    EditText edt_text;
    Button btn_back;
    Button btn_clear;
    Button btn_add;
    Button btn_n1;
    Button btn_n2;
    Button btn_n3;
    Button btn_sub;
    Button btn_n4;
    Button btn_n5;
    Button btn_n6;
    Button btn_ride;
    Button btn_n7;
    Button btn_n8;
    Button btn_n9;
    Button btn_div;
    Button btn_point;
    Button btn_n0;
    Button btn_equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);

        edt_text = findViewById(R.id.edt_text);
        btn_back = findViewById(R.id.btn_back);
        btn_clear = findViewById(R.id.btn_clear);
        btn_add = findViewById(R.id.btn_add);
        btn_n1 = findViewById(R.id.btn_n1);
        btn_n2 = findViewById(R.id.btn_n2);
        btn_n3 = findViewById(R.id.btn_n3);
        btn_sub = findViewById(R.id.btn_sub);
        btn_n4 = findViewById(R.id.btn_n4);
        btn_n5 = findViewById(R.id.btn_n5);
        btn_n6 = findViewById(R.id.btn_n6);
        btn_ride = findViewById(R.id.btn_ride);
        btn_n7 = findViewById(R.id.btn_n7);
        btn_n8 = findViewById(R.id.btn_n8);
        btn_n9 = findViewById(R.id.btn_n9);
        btn_div = findViewById(R.id.btn_div);
        btn_point = findViewById(R.id.btn_point);
        btn_n0 = findViewById(R.id.btn_n0);
        btn_equal = findViewById(R.id.btn_equal);


        edt_text.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_n1.setOnClickListener(this);
        btn_n2.setOnClickListener(this);
        btn_n3.setOnClickListener(this);
        btn_n4.setOnClickListener(this);
        btn_n5.setOnClickListener(this);
        btn_n6.setOnClickListener(this);
        btn_n7.setOnClickListener(this);
        btn_n8.setOnClickListener(this);
        btn_n9.setOnClickListener(this);
        btn_n0.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_ride.setOnClickListener(this);
        btn_point.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {

        etinput = edt_text.getText().toString();
        String etTemp = "";

        switch (view.getId()){
            case R.id.btn_n0:
            case R.id.btn_n1:
            case R.id.btn_n2:
            case R.id.btn_n3:
            case R.id.btn_n4:
            case R.id.btn_n5:
            case R.id.btn_n6:
            case R.id.btn_n7:
            case R.id.btn_n8:
            case R.id.btn_n9:
            case R.id.btn_point:
                if (clear_flag){
                    etClear();
                }
                etTemp = etinput + ((Button)view).getText();
                showText(etTemp);
                break;

            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_div:
            case R.id.btn_ride:
                if (clear_flag){
                    etClear();
                }
                etTemp = etinput + " " + ((Button)view).getText() + " ";
                showText(etTemp);
                break;

            case R.id.btn_back:
                if (clear_flag)
                {
                    etClear();
                } else if (etinput != null && !etinput.equals(" "))
                        {
                         etTemp = etinput.substring(0, etinput.length() - 1);
                         showText(etTemp);
                        }
                break;

            case R.id.btn_clear:
                etClear();
                break;

            case R.id.btn_equal:
                getResult();
                clear_flag = true;
                break;

            default:
                break;
        }
    }

    private void showText(String content) {
        edt_text.setText(content);
        edt_text.setSelection(content.length());   /*将光标移至末尾*/
    }

    private void etClear() {
        clear_flag = false;
        etinput = "";
        edt_text.setText("");
    }

    private void getResult() {

        String dataIn = etinput;
        double result = 0;

        if (dataIn == null || dataIn.equals("")) {
            return;
        }
        if (!dataIn.contains(" ")) {
            return;
        }

        String str1 = dataIn.substring(0, dataIn.indexOf(" "));
        String operator = dataIn.substring(dataIn.indexOf(" ") + 1, dataIn.indexOf(" ") + 2);
        String str2 = dataIn.substring(dataIn.indexOf(" ") + 3);

        double data1 = Double.parseDouble(str1);
        double data2 = Double.parseDouble(str2);

        switch (operator) {
            case "+":
                result = data1 + data2;
                break;
            case "-":
                result = data1 - data2;
                break;
            case "*":
                result = data1 * data2;
                break;
            case "/":
                if (data2 == 0) {
                    etClear();
                    break;
                }
                result = data1 / data2;
                break;
        }
        if (!str1.contains(".") && !str2.contains(".") && !operator.equals("/")) {
            edt_text.setText(dataIn + "=" + (int) result);
            return;
        }
        edt_text.setText(dataIn + "=" + result);
    }
}