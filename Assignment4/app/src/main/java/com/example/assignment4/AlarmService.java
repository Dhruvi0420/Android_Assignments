package com.example.assignment4;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
public class AlarmService extends BroadcastReceiver {
    public static MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(
                context,
                "Alarm Triggered",
                Toast.LENGTH_LONG
        ).show();
        mediaPlayer = MediaPlayer.create(
                context,
                Settings.System.DEFAULT_ALARM_ALERT_URI
        );
        mediaPlayer.start();
        Intent stopIntent =
                new Intent(context, com.example.assignment4.StopAlarm.class);
        PendingIntent stopPendingIntent =
                PendingIntent.getBroadcast(
                        context,
                        1,
                        stopIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT |
                                PendingIntent.FLAG_IMMUTABLE
                );
        NotificationManager manager =
                (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channel_id = "alarm_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel(
                            channel_id,
                            "Alarm Notification",
                            NotificationManager.IMPORTANCE_HIGH
                    );

            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, channel_id)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Alarm Notification")
                        .setContentText("Wake Up!")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setAutoCancel(false)
                        .addAction(
                                R.drawable.ic_launcher_foreground,
                                "Stop",
                                stopPendingIntent
                        );
        manager.notify(1, builder.build());
    }
}