package com.example.tllano.avtivity.uiactivity;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by TLLANO on 2016/8/2.
 */
public abstract class SimpleSectionsAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private LayoutInflater mLayoutInflater;
    private int mHeaderResource;
    private int mItemResource;

    // 所有节的唯一集合
    private List<SectionItem<T>> mSections;
    // 节的分组，按其初始位置设置键
    private SparseArray<SectionItem<T>> mKeyedSections;

    public
}
