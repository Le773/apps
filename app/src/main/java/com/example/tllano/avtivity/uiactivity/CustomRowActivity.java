package com.example.tllano.avtivity.uiactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class CustomRowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_row,
                R.id.line1,
                new String[] {"Bill","Tom","Sally","Jenny"});
        list.setAdapter(adapter);

        setContentView(list);
    }

    public static class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(Context context, int layout, int resId,
                             String[] items) {
            //调用 ArrayAdapter 的实现
            super(context, layout, resId, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            //如果某行没有被回收的话，填充该行
            if(row == null) {
                row = LayoutInflater.from(getContext())
                        .inflate(R.layout.custom_row, parent, false);
            }
            // 获取列表（字符串数组）中位置的当前值
            String item = getItem(position);
            ImageView left =
                    (ImageView)row.findViewById(R.id.leftimage);
            ImageView right =
                    (ImageView)row.findViewById(R.id.rightimage);
            TextView text = (TextView)row.findViewById(R.id.line1);

            left.setImageResource(R.drawable.apple_pic);
            right.setImageResource(R.drawable.banana_pic);
            text.setText(item);
            return row;
        }
    }
}
