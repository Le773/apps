package com.example.tllano.avtivity.uiactivity;

/**
 * Created by TLLANO on 2016/8/2.
 */
public class SectionItem<T> {

    private String mTitle;
    private T[] mItems;

    public SectionItem(String title, T[] items) {
        if (title == null) title = "";
        mTitle = title;
        mItems = items;
    }
    public String getTitle() {
        return mTitle;
    }
    public T getItem(int position) {
        return mItems[position];
    }

    public int getCount() {
//为节标题包含额外的项
        return (mItems == null ? 1 : 1 + mItems.length);
    }

    @Override
    public boolean equals(Object object) {
//如果两个节有相同的标题，则它们相等
        if (object != null && object instanceof SectionItem) {
            return ((SectionItem) object).getTitle().equals(mTitle);
        }
        return false;
    }
}