package com.example.week_9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);

        Log.d("FZF","FistActivity的onCreate函数被调用");

        Button btn1 = findViewById(R.id.first_b);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name","FZF?");
                bundle.putInt("id",
                        121);
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("Massage",bundle);
                startActivity(intent);
            }
        });


            /*@Override
            public void onClick(View view) {
                String data = "Hello SecondActivity?";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("hello",data);
                intent.putExtra("id",
                        123);
                startActivityForResult(intent,
                        1);
            }*/

            /*@Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
            }*/

        /* @Override
            public void onClick(View view) {
                Intent intent1 = new Intent("com.example.week_9.MY.ACTION");
                intent1.addCategory("android.intent.category.DEFAULT");
                startActivity(intent1);
            }*/



        /* @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent1);
            }*/
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
            if (resultCode == RESULT_OK){
                String returnedData = data.getStringExtra("data_return");
                Log.d("FZF",returnedData);
            }
        }
    }*/
}