package com.rba.custompicker.control.lib;

import android.view.MotionEvent;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

final class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    final PickerView loopView;

    LoopViewGestureListener(PickerView loopview) {
        loopView = loopview;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        loopView.scrollBy(velocityY);
        return true;
    }
}

