package com.rba.custompicker.control.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.rba.custompicker.R;
import com.rba.custompicker.control.listener.OnDateSelectListener;
import com.rba.custompicker.util.Constant;
import com.rba.custompicker.util.Util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class CustomDatePickerView extends BasePickerView implements View.OnClickListener {
    public enum Type {
        YEAR_MONTH
    }

    DatePickerView datePickerView;
    private View btnSubmit;
    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";
    private OnDateSelectListener dateSelectListener;
    private Context context;
    private int variable;
    private Date to, since;

    public CustomDatePickerView(Context context, Type type) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.date_picker, contentContainer);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setTag(TAG_SUBMIT);
        btnSubmit.setOnClickListener(this);

        final View linPicker = findViewById(R.id.linPicker);
        datePickerView = new DatePickerView(linPicker, type);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        datePickerView.setPicker(context, year, month);

    }

    public void setRange(int startYear, int endYear) {
        datePickerView.setStartYear(startYear);
        datePickerView.setEndYear(endYear);
    }

    public void setVariable(int variable){
        this.variable = variable;
    }

    public void verifyDates(Date since, Date to){
        this.since = since;
        this.to = to;
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
            calendar.setTimeInMillis(System.currentTimeMillis());
        else
            calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        datePickerView.setPicker(context, year, month);
    }

    public void setCyclic(boolean cyclic) {
        datePickerView.setCyclic(cyclic);
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_CANCEL)) {
            dismiss();
            return;
        } else {
            if (dateSelectListener != null) {
                try {
                    Date date = DatePickerView.dateFormat.parse(datePickerView.getDate());

                    switch (variable){
                        case Constant.VARIABLE_SINCE:

                            if(to!=null){
                                if(Util.validateDate(date, to)){
                                    dateSelectListener.onDateSelect(date, variable);
                                    dismiss();
                                }else{
                                    Toast.makeText(context, context.getString(R.string.select_correct_dates), Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                dateSelectListener.onDateSelect(date, variable);
                                dismiss();
                            }

                            break;
                        case Constant.VARIABLE_TO:
                            if(since!=null){
                                if(Util.validateDate(since, date)){
                                    dateSelectListener.onDateSelect(date, variable);
                                    dismiss();
                                }else{
                                    Toast.makeText(context, context.getString(R.string.select_correct_dates), Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                dateSelectListener.onDateSelect(date, variable);
                                dismiss();
                            }
                            break;
                        default:
                            break;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
    }


    public void setOnDateSelectListener(OnDateSelectListener timeSelectListener) {
        this.dateSelectListener = timeSelectListener;
    }

}
