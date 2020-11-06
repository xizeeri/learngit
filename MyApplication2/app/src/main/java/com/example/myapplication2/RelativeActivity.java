package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity implements View.OnClickListener{

    int visible_id;

    TextView text_u;
    TextView text_d;
    TextView text_l;
    TextView text_r;

    Button btn_u;
    Button btn_d;
    Button btn_c;
    Button btn_l;
    Button btn_r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        text_u = findViewById(R.id.text_u);
        text_d = findViewById(R.id.text_d);
        text_l = findViewById(R.id.text_l);
        text_r = findViewById(R.id.text_r);

        btn_c = findViewById(R.id.btn_c);
        btn_u = findViewById(R.id.btn_u);
        btn_d = findViewById(R.id.btn_d);
        btn_l = findViewById(R.id.btn_l);
        btn_r = findViewById(R.id.btn_r);

        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_l.setOnClickListener(this);
        btn_r.setOnClickListener(this);
        btn_u.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_u:
                visible_id = changeVisible(text_u.getVisibility());
                text_u.setVisibility(visible_id);
                break;
            case R.id.btn_d:
                visible_id = changeVisible(text_d.getVisibility());
                text_d.setVisibility(visible_id);
                break;
            case R.id.btn_l:
                visible_id = changeVisible(text_l.getVisibility());
                text_l.setVisibility(visible_id);
                break;
            case R.id.btn_r:
                visible_id = changeVisible(text_r.getVisibility());
                text_r.setVisibility(visible_id);
                break;
            case R.id.btn_c:
                text_u.setVisibility(View.INVISIBLE);
                text_d.setVisibility(View.INVISIBLE);
                text_l.setVisibility(View.INVISIBLE);
                text_r.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
    }

    private int changeVisible(int stateId) {
        if (stateId == View.VISIBLE) {
            return View.INVISIBLE;
        }
        return View.VISIBLE;
    }
}