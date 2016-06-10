package com.rba.custompicker.control.adapter;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public interface DatePickerAdapter<T> {

    int getItemsCount();

    T getItem(int index);

    int indexOf(T o);

}
