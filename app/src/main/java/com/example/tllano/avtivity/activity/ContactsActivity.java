package com.example.tllano.avtivity.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tllano.avtivity.R;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends Activity {

    ListView contactsView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        contactsView = (ListView) findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactsList);
        contactsView.setAdapter(adapter);
        readContacts();
    }

    public void readContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName + "\n" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                if(cursor != null) {
                    cursor.close();
                }
        }
    }
}