package com.example.tllano.avtivity.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tllano.avtivity.R;

public class NotificationActivity extends Activity {

    static final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;
    Button sendNotify, delNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        sendNotify = (Button) findViewById(R.id.sendNotify);
        delNotify = (Button) findViewById(R.id.delNotify);

        sendNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });

        delNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del(v);
            }
        });
    }

    public void send(View source)
    {
        Toast.makeText(NotificationActivity.this, "234567", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(NotificationActivity.this ,NormalActivity.class);
        PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);
        Notification notify = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("new message")
                .setContentText("today very happy")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi)
                .build();
        nm.notify(NOTIFICATION_ID, notify);
    }

    public void del(View v)
    {
        nm.cancel(NOTIFICATION_ID);
    }

    public void delAll(View v) {
        nm.cancelAll();
    }
}
