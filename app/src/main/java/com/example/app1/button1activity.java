package com.example.app1;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class button1activity extends AppCompatActivity {
    Button submit_button;


    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.button1activity);

        submit_button=findViewById(R.id.submit_button);
//request notification permisssion
//        checks if the device's SDK version is greater than or equal to TIRAMISU (Android 4.4)
//        and requests the notification permission if it's not already granted
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(button1activity.this,
                    android.Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
//                checks if the permission POST_NOTIFICATIONS is not granted, and if so,
//                it requests the permission using ActivityCompat.requestPermissions()
                ActivityCompat.requestPermissions(button1activity.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                makeNotification();
            }
        });
        }

public void makeNotification(){
        String chanelID="CHANNEL_ID_NOTIFICATION";
//         build the notification
    NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext(), chanelID);
    builder.setSmallIcon(R.drawable.baseline_notifications_active_24)
            .setContentTitle("Android Studio")
            .setContentText("Hi, We received your complaint!")
//            sets whether the notification should be automatically canceled when the user taps it
            .setAutoCancel(true)
//             indicates that the notification has a default priority,
//              it's not particularly urgent or time-sensitive.
            .setPriority((NotificationCompat.PRIORITY_DEFAULT));

    Intent intent=new Intent(getApplicationContext(), NotificationActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.putExtra("data", "Some value to be passed");
//allows the system to execute the intent on your behalf even if your app is not running
    PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);
    builder.setContentIntent(pendingIntent);
//    allows you to post, manage, and cancel notifications shown to the user.
    NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//checks if the device's SDK version is at least Oreo (Android 8.0). Beginning with
// Android 8.0, notification channels were introduced
    if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
        NotificationChannel notificationChannel= notificationManager.getNotificationChannel(chanelID);
        if(notificationChannel==null){
//            If the channel doesn't exist, this block of code creates
//            a new NotificationChannel with the specified channel ID
            int importance=NotificationManager.IMPORTANCE_HIGH;
            notificationChannel=new NotificationChannel(chanelID, "Some Description", importance);
            notificationChannel.setLightColor(Color.GREEN);
//             creates the notification channel
            notificationManager.createNotificationChannel((notificationChannel));
        }

    }
//    posts the notification to the system
            notificationManager.notify(0, builder.build());
    }
}