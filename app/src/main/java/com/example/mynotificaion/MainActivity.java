package com.example.mynotificaion;

import androidx.appcompat.app.AppCompatActivity;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mynotificaion.App.CHANNEL_ID_1;
import static com.example.mynotificaion.App.CHANNEL_ID_2;

public class MainActivity extends AppCompatActivity {
    private EditText title,description;
    private NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager=NotificationManagerCompat.from(this);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
    }

    public void sendOnChannel1(View view){
        Intent activityIntent=new Intent(this,MainActivity.class);
        PendingIntent contentIntent= PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent=new Intent(this,NotificatonReceiver.class);
        broadcastIntent.putExtra("toastMessage",description.getText().toString());
        PendingIntent actionIntent=PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID_1)
                .setSmallIcon(R.drawable.one)
                .setContentTitle(title.getText().toString())
                .setContentText(description.getText().toString())
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast",actionIntent)
                .build();
        notificationManager.notify(1,notification);

    }

    public void sendOnChannel2(View view){

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_baseline_looks_two_24)
                .setContentTitle(title.getText().toString())
                .setContentText(description.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2,notification);

    }
}