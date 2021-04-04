package ru.mirea.sorokin.bsbo0819.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static androidx.core.app.NotificationCompat.PRIORITY_LOW;


public class MainActivity_na extends AppCompatActivity {
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private static final int NOTIFY_ID = 1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_na);
        b1 = findViewById(R.id.button);

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent intent = new Intent(getApplicationContext(), MainActivity_na.class);
                                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                      PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                      NotificationCompat.Builder notificationBuilder =
                                              new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                                      .setAutoCancel(true)
                                                      .setSmallIcon(R.drawable.ic_launcher_background)
                                                      .setContentTitle("Заголовок")
                                                      .setContentText("Текст уведомления")
                                                      .setContentIntent(pendingIntent)
                                                      .setPriority(PRIORITY_LOW);
                                      createChannelIfNeeded(notificationManager);
                                      notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
                                  }

                                  public void createChannelIfNeeded(NotificationManager manager) {
                                      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                          NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
                                          manager.createNotificationChannel(notificationChannel);
                                      }
                                  }
                              }
        );


    }
}
