package com.example.androidservicesapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class NotificationAppServiceChannel extends Application {
    public static final String CHANNEL_ID = "Channel 1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {

        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_LOW);

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(notificationChannel);

    }
}
