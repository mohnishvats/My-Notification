package com.example.mynotificaion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificatonReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message=intent.getStringExtra("toastMessage");
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }
}
