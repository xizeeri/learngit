package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity01 extends AppCompatActivity {
    private  String[] data = {"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewActivity01.this,
                android.R.layout.simple_expandable_list_item_1, data);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);





    }
}