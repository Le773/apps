package com.example.tllano.avtivity.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.TextView;

import com.example.tllano.avtivity.R;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity {

    ListView contactsView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<String>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        textView = (TextView) findViewById(R.id.dialog_tv_01);

/*
       contactsView = (ListView) findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactsList);
        contactsView.setAdapter(adapter);
        readContacts();*/
    }

    private void readContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName + "\n" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
