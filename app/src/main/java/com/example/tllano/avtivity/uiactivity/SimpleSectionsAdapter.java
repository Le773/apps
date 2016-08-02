package com.example.tllano.avtivity.uiactivity;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
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

    public SimpleSectionsAdapter(ListView parent, int headerResId, int itemResId) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        mHeaderResource = headerResId;
        mItemResource = itemResId;

        //创建包含自动排序键的集合
        mSections = new ArrayList<SectionItem<T>>();
        mKeyedSections = new SparseArray<SectionItem<T>>();
        //将自身附加为列表的单击处理程序
        parent.setOnItemClickListener(this);
    }

    /*
    * 向列表添加新的带标题的节，
    * 或者更新现有的节
    */
    public void addSection(String title, T[] items) {
        SectionItem<T> sectionItem = new SectionItem<T>(title, items);
        //添加节，替换具有相同标题的现有节
        int currentIndex = mSections.indexOf(sectionItem);
        if (currentIndex >= 0) {
            mSections.remove(sectionItem);
            mSections.add(currentIndex, sectionItem);
        } else {
            mSections.add(sectionItem);
        }
        //对最新的集合排序
        reorderSections();
        //表明视图数据已改变
        notifyDataSetChanged();
    }

    /*
    *将带有初始全局位置的节标记为可引用的键
    */
    private void reorderSections() {
        mKeyedSections.clear();
        int startPosition = 0;
        for(SectionItem<T> item : mSections) {
            mKeyedSections.put(startPosition, item);
            startPosition += item.getCount();
        }
    }

    @Override
    public int getCount() {
        int count = 0;
        for(SectionItem<T> item : mSections) {
            count += item.getCount();
        }
        return count;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderAtPosition(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public Object getItem(int position) {
        return findSectionItemAtPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    *重写并返回 false，告诉 ListView 有一些项(头部)不可点击
    */

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    /*
    *重写以告诉 ListView 哪些项(头部)是不可点击的
    */

    @Override
    public boolean isEnabled(int position) {
        return !isHeaderAtPosition(position);
    }

    /*
    * 检查是否是代表节标题的全局位置值
    */
    private boolean isHeaderAtPosition(int position) {
        for(int i=0; i < mKeyedSections.size(); i++ ) {
            if (position == mKeyedSections.keyAt(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                return ;//
        }
        return null;
    }

    private View getHeaderView(int position, View convertView, ViewGroup parent ) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(mHeaderResource, parent, false);
        }
        SectionItem<T> item = mKeyedSections.get(position);
        TextView textView = (TextView) convertView.
                findViewById(android.R.id.text1);
        textView.setText(item.getTitle());
        return  convertView;
    }

    private View getItemView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(mHeaderResource, parent, false);
        }
        T item = findSectionItemAtPosition(position);
        TextView textView = (TextView) convertView.
                findViewById(android.R.id.text1);
        textView.setText(item.toString());
        return  convertView;
    }

    // 返回给定全局位置的显式列表项
    private T findSectionItemAtPosition(int position) {
        int firstIndex, lastIndex;
        for(int i=0; i < mKeyedSections.size(); i++ ) {
            firstIndex = mKeyedSections.keyAt(i);
            lastIndex = firstIndex + mKeyedSections.valueAt(i).getCount();
            if(position >= firstIndex && position < lastIndex) {
                int sectionPosition = position -firstIndex - 1;
                return mKeyedSections.valueAt(i).getItem(sectionPosition);
            }
        }
        return null;
    }
}
