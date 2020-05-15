package com.example.androidnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //1. Notification Channel
    //2. Notification Builder
    //3. Notification Manager

    public static final String CHANNEL_ID = "simplified_coding";
    private static final String CHANNEL_NAME = "Simplified Coding";
    private static final String CHANNEL_DESC = "Simplified Coding Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if greater than or = to android Orio or android  8
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        findViewById(R.id.buttonNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }

    private void displayNotification(){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Hurray! It is working...")
                        .setContentText("Your first notification..")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, mBuilder.build());
    }
}
