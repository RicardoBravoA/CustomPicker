package com.rba.custompicker.control.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.rba.custompicker.R;
import com.rba.custompicker.control.adapter.ArrayAdapter;
import com.rba.custompicker.control.adapter.NumericAdapter;
import com.rba.custompicker.control.lib.PickerView;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class DatePickerView {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
    private View view;
    private PickerView pvYear,  pvMonth;
    private CustomDatePickerView.Type type;
    private int startYear = 1980, endYear = Calendar.getInstance().get(Calendar.YEAR);

    public DatePickerView(View view) {
        super();
        this.view = view;
        type = CustomDatePickerView.Type.YEAR_MONTH;
        setView(view);
    }

    public DatePickerView(View view, CustomDatePickerView.Type type) {
        super();
        this.view = view;
        this.type = type;
        setView(view);
    }

    public void setPicker(Context context, int year , int month) {

        pvYear = (PickerView) view.findViewById(R.id.pvYear);
        pvYear.setAdapter(new NumericAdapter(startYear, endYear));
        pvYear.setCurrentItem(year - startYear);


        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, context.getResources().getStringArray(R.array.month));

        pvMonth = (PickerView) view.findViewById(R.id.pvMonth);
        pvMonth.setAdapter(new ArrayAdapter(list));
        pvMonth.setCurrentItem(month);

        int textSize = 6;
        switch(type){
            case YEAR_MONTH:
                textSize = textSize * 4;
        }
        pvMonth.setTextSize(textSize);
        pvYear.setTextSize(textSize);

    }

    public void setCyclic(boolean cyclic){
        pvYear.setCyclic(cyclic);
        pvMonth.setCyclic(cyclic);
    }
    public String getDate() {
        StringBuffer sb = new StringBuffer();
        sb.append((pvYear.getCurrentItem() + startYear)).append("-")
                .append((pvMonth.getCurrentItem() + 1));
        return sb.toString();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
