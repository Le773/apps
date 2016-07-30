package com.example.tllano.avtivity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.tllano.avtivity.R;

public class DarkActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark);
    }

    public void onToggleClick(View view) {
        int currentVis = view.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE){
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        view.setSystemUiVisibility(newVis);
    }
}
