package com.rba.custompicker.util;

import android.content.Context;

import com.rba.custompicker.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Ricardo Bravo on 10/06/16.
 */

public class Util {

    public static String getDateString(Context context, Date date){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);

        return getNameMonth(context, month).concat(" - ").concat(String.valueOf(year));
    }

    public static String getNameMonth(Context context, int month){

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, context.getResources().getStringArray(R.array.month_letters));
        return list.get(month-1);
    }

    public static boolean validateDate(Date date1, Date date2){

        switch (date1.compareTo(date2)){
            case 0:
                return true;
            case 1:
                return false;
            case -1:
                return true;
            default:
                break;
        }
        return  false;
    }

}
