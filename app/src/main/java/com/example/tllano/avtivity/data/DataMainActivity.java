package com.example.tllano.avtivity.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.database.MyDatabaseHelper;

public class DataMainActivity extends Activity {

    Button saveData, readButton;
    Button create_db;

    EditText editText;
    TextView textView;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_data_main);

        saveData = (Button) findViewById(R.id.save_sp);
        readButton = (Button) findViewById(R.id.read_sp);
        editText = (EditText) findViewById(R.id.write_data_sp);
        textView = (TextView) findViewById(R.id.show_data_sp);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                String name = editText.getText().toString();
                if(!TextUtils.isEmpty(name)) {
                    editor.putString("name", name);
                }
                editor.putInt("age", 24);
                editor.putBoolean("married", false);
                editor.commit();
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                Boolean married = pref.getBoolean("married", false);
                Log.d("age", "" + age);
                Log.d("married","" + married);
                textView.setText(name);
            }
        });


        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        // 更新version id 执行onupdate();
        // dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        create_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });


        // 添加数据
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);
            }
        });

        // 更新数据
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "name = ?",
                        new String[] { "The Da Vinci Code" });
            }
        });

        // 删除数据
        Button deleteButton = (Button) findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[] { "500" });
            }
        });

        // 查询数据
        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null,
                        null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor
                                .getColumnIndex("name"));
                        String author = cursor.getString(cursor
                                .getColumnIndex("author"));
                        int pages = cursor.getInt(cursor
                                .getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor
                                .getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

        // 替换数据
        Button replaceData = (Button) findViewById(R.id.replace_data);
        replaceData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // 开启事务
                db.beginTransaction();
                try {
                    db.delete("Book", null, null);
//					if (true) {
//						throw new NullPointerException();
//					}
                    ContentValues values = new ContentValues();
                    values.put("name", "Game of Thrones");
                    values.put("author", "George Martin");
                    values.put("pages", 720);
                    values.put("price", 20.85);
                    db.insert("Book", null, values);
                    db.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    // 结束事务
                    db.endTransaction();
                }
            }
        });
    }
}
