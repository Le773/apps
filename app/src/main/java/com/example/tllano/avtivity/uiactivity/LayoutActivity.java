package com.example.tllano.avtivity.uiactivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class LayoutActivity extends BaseActivity  implements View.OnClickListener{

    LinearLayout mContainer;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        mContainer = (LinearLayout) findViewById(R.id.verticalContainer);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.remove_btn).setOnClickListener(this);
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

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        mContainer.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            mContainer.removeViewAt(0);
        }
        i--;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            addButtonView();
        }
        if (v.getId() == R.id.remove_btn) {
            removeButtonView();
        }
    }
}
