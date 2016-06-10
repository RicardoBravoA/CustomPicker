package com.rba.custompicker.control.adapter;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class NumericAdapter implements DatePickerAdapter {

    public static final int DEFAULT_MAX_VALUE = 9,DEFAULT_MIN_VALUE = 0;
    private int minValue, maxValue;

    public NumericAdapter() {
        this(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    public NumericAdapter(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int value = minValue + index;
            return value;
        }
        return 0;
    }

    @Override
    public int getItemsCount() {
        return maxValue - minValue + 1;
    }

    @Override
    public int indexOf(Object o){
        return (int)o - minValue;
    }
}