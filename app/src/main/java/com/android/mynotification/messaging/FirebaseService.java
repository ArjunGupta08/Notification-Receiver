package com.android.mynotification.messaging;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.android.mynotification.MainActivity;
import com.android.mynotification.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class FirebaseService extends FirebaseMessagingService {
    private final String CHANNEL_ID = "channel_id";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

         Log.d("FirebaseService", "Message Received: " + remoteMessage.getData().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("title", remoteMessage.getData().get("title"));
        intent.putExtra("message", remoteMessage.getData().get("message"));
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationId = new Random().nextInt();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificatonChannel(manager);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent intent1 = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_MUTABLE );

        Notification notification;
        notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(remoteMessage.getData().get("title"))
                .setContentText(remoteMessage.getData().get("message"))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(intent1)
                .build();
        manager.notify(notificationId, notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificatonChannel(NotificationManager manager) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"channelName",NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("My Description");
        channel.enableLights(true);
        channel.setLightColor(Color.WHITE);

        manager.createNotificationChannel(channel);

    }
}