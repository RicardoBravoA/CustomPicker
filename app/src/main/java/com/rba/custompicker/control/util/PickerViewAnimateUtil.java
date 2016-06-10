package com.rba.custompicker.control.util;

import android.view.Gravity;

import com.rba.custompicker.R;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int gravity, boolean isInAnimation) {
        switch (gravity) {
            case Gravity.BOTTOM:
                return isInAnimation ? R.anim.slide_in_bottom : R.anim.slide_out_bottom;
        }
        return INVALID;
    }
}
