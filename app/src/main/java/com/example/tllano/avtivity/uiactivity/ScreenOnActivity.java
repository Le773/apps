package com.example.tllano.avtivity.uiactivity;


import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class ScreenOnActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_on);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.FLAG_KEEP_SCREEN_ON:
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                break;
            case R.id.FLAG_NOT_FOCUSABLE:
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                break;
            case R.id.FLAG_NOT_TOUCH_MODAL:
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
                break;
            case R.id.FLAG_TOUCHABLE_WHEN_WAKING:
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TOUCHABLE_WHEN_WAKING);
                break;
            default:
                break;
        }
    }
}
