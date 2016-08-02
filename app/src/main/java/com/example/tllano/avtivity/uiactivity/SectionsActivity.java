package com.example.tllano.avtivity.uiactivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tllano.avtivity.R;

/**
 * Created by TLLANO on 2016/8/2.
 */
public class SectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);

        SimpleSectionsAdapter<String> adapter = new
                SimpleSectionsAdapter<String>(
                        list, /* 资源扩充的上下文 */
                        R.layout.list_header, /* 头部视图的布局 */
                        android.R.layout.simple_list_item_1 /* Layout for item views */
                ) {
                    //适用于项点击的单击处理程序
                    @Override
                    public void onSectionItemClick(String item) {
                        Toast.makeText(SectionsActivity.this, item,
                                Toast.LENGTH_SHORT).show();
                    }
                };
        adapter.addSection("Fruits", new String[]{"Apples", "Oranges",
                "Bananas", "Mangos"});
        adapter.addSection("Vegetables", new String[]{"Carrots", "Peas",
                "Broccoli"});
        adapter.addSection("Meats", new String[]{"Pork", "Chicken", "Beef",
                "Lamb"});
        list.setAdapter(adapter);
        setContentView(list);
    }
}