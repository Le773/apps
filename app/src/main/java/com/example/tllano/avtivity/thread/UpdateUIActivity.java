package com.example.tllano.avtivity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tllano.avtivity.R;


public class UpdateUIActivity extends Activity {

    public static final int UPDATE_TEXT = 1;

    TextView text;
    Button changeText;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    text.setText("Nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ui);

        changeText = (Button) findViewById(R.id.change_text);
        text = (TextView) findViewById(R.id.text);
        Log.d("changeText", "" + R.id.change_text);

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateUIActivity.this, "AAA", Toast.LENGTH_SHORT).show();
                Log.d("UpdateUIActivity", "" + v.getId());
                switch (v.getId()) {
                    case R.id.change_text:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = UPDATE_TEXT;
                                handler.sendMessage(message);
                            }
                        }).start();
                        break;
                    default:
                        Toast.makeText(UpdateUIActivity.this, "BBB", Toast.LENGTH_SHORT).show();
                        break;
                }
                Log.d("UpdateUIActivity", "" + v.getId());
            }
        });
    }
}
