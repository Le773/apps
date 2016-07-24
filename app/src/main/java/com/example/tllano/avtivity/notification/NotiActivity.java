package com.example.tllano.avtivity.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tllano.avtivity.R;

import java.io.File;

public class NotiActivity extends Activity {

    Button mSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);
        mSend = (Button) findViewById(R.id.mNotifition);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(
                        R.drawable.ic_launcher, "This is ticker text",
                        System.currentTimeMillis());
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
                notification.sound = soundUri;
                long[] vibrates = {0, 1000, 1000, 1000};
                notification.vibrate = vibrates;
                notification.ledARGB = Color.GREEN;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 1000;
                notification.flags = Notification.FLAG_SHOW_LIGHTS;
//			notification.defaults = Notification.DEFAULT_ALL;
                Intent intent = new Intent(NotiActivity.this, NotiActivity.class);
                PendingIntent pi = PendingIntent.getActivity(NotiActivity.this, 0, intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);
//                notification.setLatestEventInfo(this, "This is content title",
//                        "This is content text", pi);
                manager.notify(1, notification);
            }

        });
    }

}
