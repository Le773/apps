package com.example.tllano.avtivity.uiactivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class LayoutActivity extends BaseActivity {

    LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        mContainer = (LinearLayout) findViewById(R.id.verticalContainer);
    }

    //
    public void onAddClick(View view) {
        Button button = new Button(this);
        button.setText("Click to Remove");
        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  mContainer.removeView(v);
              }
        });

        mContainer.addView(button, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT));
    }

}
