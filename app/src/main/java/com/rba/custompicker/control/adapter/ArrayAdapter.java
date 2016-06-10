package com.rba.custompicker.control.adapter;

import java.util.ArrayList;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class ArrayAdapter<T> implements DatePickerAdapter {

    public static final int DEFAULT_LENGTH = 4;
    private ArrayList<T> items;
    private int length;

    public ArrayAdapter(ArrayList<T> items, int length) {
        this.items = items;
        this.length = length;
    }

    public ArrayAdapter(ArrayList<T> items) {
        this(items, DEFAULT_LENGTH);
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "";
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }

    @Override
    public int indexOf(Object o){
        return items.indexOf(o);
    }

}
