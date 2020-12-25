package com.example.playaudioapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button play_btn =findViewById(R.id.play);
        play_btn.setOnClickListener(this);
        Button pause_btn =findViewById(R.id.pause);
        pause_btn.setOnClickListener(this);
        Button stop_btn =findViewById(R.id.stop);
        stop_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}