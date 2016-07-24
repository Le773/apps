package com.example.tllano.avtivity.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by TLLANO on 2016/7/24.
 */

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // 第一次创建时调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "startDownload executed");
        Toast.makeText(MyService.this, "startDownload executed", Toast.LENGTH_SHORT).show();
    }

    // 每次启动服务时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
        Toast.makeText(MyService.this, "onStartCommand executed", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "onDestroy executed");
        Toast.makeText(MyService.this, "onDestroy executed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    public class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService", "startDownload executed");
            Toast.makeText(MyService.this, "startDownload executed", Toast.LENGTH_SHORT).show();
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            Toast.makeText(MyService.this, "getProgress executed", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
}
