package com.example.androidservicesapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.androidservicesapp.NotificationAppServiceChannel.CHANNEL_ID;

public class AndroidServiceClass extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("intentExtra");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(AndroidServiceClass.this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(AndroidServiceClass.this, CHANNEL_ID)
                .setContentTitle(input)
                .setContentText("This is an Android Service Implementation")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);
        //stopSelf();
        return START_NOT_STICKY;
    }
}
