package com.example.lab_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {
    Button sendBtn, cancelBtn, imgNotificationBtn;
    NotificationManager notificationManager;
    NotificationChannel channel;

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private final static String default_notification_channel_id = "default";

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel();

        sendBtn = findViewById(R.id.sendBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        imgNotificationBtn = findViewById(R.id.imgNotificationBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationActivity.this, "send clicked", Toast.LENGTH_SHORT).show();

//                Notification Compat builder
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationActivity.this,
                        default_notification_channel_id)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setColor(Color.BLUE)
                        .setContentTitle("Test Notification")
                        .setContentText("Hello! This is my first push notification");
//                Notification manager
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    AudioAttributes audioAttributes = new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .setUsage(AudioAttributes.USAGE_ALARM)
                            .build();
                    int importance = NotificationManager.IMPORTANCE_HIGH;
//                    Notification Channel
                    NotificationChannel notificationChannel = new
                            NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    //notificationChannel.setSound(sound , audioAttributes) ;
                    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);

                    assert mNotificationManager != null;
                    mNotificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());
                }
            }
        });
        imgNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationActivity.this, "img notif clicked", Toast.LENGTH_SHORT).show();

                final Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.jeriel)).getBitmap();
//                Notification Compat builder
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationActivity.this,
                        default_notification_channel_id)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setColor(Color.BLUE)
                        .setContentTitle("Image Notification")
                        .setContentText("Hello! This is me :)")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
//                Notification manager
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    AudioAttributes audioAttributes = new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .setUsage(AudioAttributes.USAGE_ALARM)
                            .build();
                    int importance = NotificationManager.IMPORTANCE_HIGH;
//                    Notification Channel
                    NotificationChannel notificationChannel = new
                            NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    //notificationChannel.setSound(sound , audioAttributes) ;
                    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);

                    assert mNotificationManager != null;
                    mNotificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.cancelAll();
            }
        });
    }

    public void sendOnChannel1() {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel_id")
                .setContentTitle("Test Title")
                .setContentText("Test Message")
                .setSmallIcon(R.mipmap.ic_launcher);

        //notificationManager.notify(1, notification.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("This is channel 2");


            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.createNotificationChannel(channel2);
        }
    }
}