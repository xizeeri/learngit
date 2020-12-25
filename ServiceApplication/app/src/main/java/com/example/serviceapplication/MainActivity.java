package com.example.serviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button1);
        text = findViewById(R.id.text1);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.text1:
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    text.setText("666666666666");
                }
            }).start();
            break;
            default:
                break;
        }
    }
}