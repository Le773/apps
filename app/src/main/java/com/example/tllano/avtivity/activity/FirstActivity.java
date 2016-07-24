package com.example.tllano.avtivity.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.data.DataMainActivity;
import com.example.tllano.avtivity.login.LoginActivity;
import com.example.tllano.avtivity.thread.UpdateUIActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FirstActivity extends AppCompatActivity {

    EditText edit, showContent;
    Button startNormalActivity, startDialogActivity, btn_save, to_main, showContacts, datamain, login, updateui, btnService;
    public static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first);

        startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        edit = (EditText) findViewById(R.id.textview_save_01);
        btn_save = (Button) findViewById(R.id.button_save);

        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, DialogActivity.class);
            }
        });

        btn_save.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    btn_save.setBackgroundColor(Color.RED);
                } else {
                    btn_save.setBackgroundColor(Color.GREEN);
                }
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_save.setBackgroundColor(Color.YELLOW);
                String inputText = edit.getText().toString();
                if (!TextUtils.isEmpty(inputText)) {
                    save(inputText);
                    Log.d(TAG,inputText);
                } else {
                    Toast.makeText(FirstActivity.this,"inputText is null", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 设置 edittext
        showContent = (EditText) findViewById(R.id.textview_read_01);
        String inputText = load();
        if(!TextUtils.isEmpty(inputText)) {
            showContent.setText(inputText);
            showContent.setSelection(inputText.length());
            Toast.makeText(FirstActivity.this, "Restoring succeede", Toast.LENGTH_SHORT).show();
        }

        //to main activity
        to_main = (Button) findViewById(R.id.to_main_activity);
        to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainIntent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(toMainIntent);
            }
        });


        // 查看联系人
        showContacts = (Button) findViewById(R.id.show_contacts);
        showContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, ContactsActivity.class);
                startActivity(intent);
            }
        });

        // 数据存储
        datamain = (Button) findViewById(R.id.datamain);
        datamain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, DataMainActivity.class);
                startActivity(intent);
            }
        });

        // 登录
        login = (Button) findViewById(R.id.tologin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // 后台更新UI
        updateui = (Button) findViewById(R.id.update_ui_01);
        updateui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, UpdateUIActivity.class);
                startActivity(intent);
            }
        });

        // service main
        btnService = (Button) findViewById(R.id.service_main_01);
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = edit.getText().toString();
        save(inputText);
    }

    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;

        Log.d(TAG, "save message");
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}