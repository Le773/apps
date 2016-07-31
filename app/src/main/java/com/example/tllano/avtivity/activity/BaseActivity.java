package com.example.tllano.avtivity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.tllano.avtivity.services.ActivityCollector;

/**
 * Created by TLLANO on 2016/7/31.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
