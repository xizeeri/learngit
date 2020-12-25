package com.example.qqapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DialogBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView editText = findViewById(R.id.dialog_TV);
        editText.setText(name);
    }
}