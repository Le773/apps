package com.example.tllano.avtivity.uiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tllano.avtivity.R;

import org.w3c.dom.Text;

public class ResetLayoutActivity extends Activity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取填充布局文件
        LinearLayout layout = (LinearLayout)getLayoutInflater().inflate(R.layout.activity_reset_layout, null);
        // 添加按钮
        Button reset = new Button(this);
        // 设置按钮样式
        reset.setText("Rest Form");
        reset.setAllCaps(false);
        layout.addView(reset, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        // 将视图关联到窗口
        setContentView(layout);
        // 打印布局文件
        editText = (EditText) findViewById(R.id.reset_layout_01);
        textView = (TextView) findViewById(R.id.reset_layout_tv_01);
        textView.setText(layout.toString());
    }
}
