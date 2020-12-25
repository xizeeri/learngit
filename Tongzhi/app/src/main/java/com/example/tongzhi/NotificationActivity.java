package com.example.tongzhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private String channelId = "nornal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.send_notice:
            Intent intent = new Intent(this,);

            NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                NotificationChannel notificationChannel = new NotificationChannel(channelId,"channelNornal", NotificationManager.IMPORTANCE_DEFAULT);
                manager.createNotificationChannel(notificationChannel);
            }

            Notification notification = new NotificationCompat.Builder(this,channelId)
                    .setContentTitle("this is content title")
                    .setContentText("this is content text")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.a)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.b))
                    .setAutoCancel(true)
                    .build();
            manager.notify(1,notification);
            break;
        default:
            break;
    }
    }
}