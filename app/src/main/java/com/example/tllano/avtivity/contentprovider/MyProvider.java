package com.example.tllano.avtivity.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

/**
 * Created by TLLANO on 2016/7/23.
 */

public class MyProvider extends ContentProvider {
    public MyProvider() {
        super();
    }
    // 数据库创建和升级

    @Override
    public boolean onCreate() {
        return false;
    }

    // 查询数据

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        return super.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    // 根据传入的内容返回相应的MIME类型

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }
}
