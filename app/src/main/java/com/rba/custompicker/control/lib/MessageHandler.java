package com.rba.custompicker.control.lib;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public static final int WHAT_ITEM_SELECTED = 3000;

    final PickerView loopview;

    MessageHandler(PickerView loopview) {
        this.loopview = loopview;
    }

    @Override
    public final void handleMessage(Message msg) {
        switch (msg.what) {
            case WHAT_INVALIDATE_LOOP_VIEW:
                loopview.invalidate();
                break;

            case WHAT_SMOOTH_SCROLL:
                loopview.smoothScroll(PickerView.ACTION.FLING);
                break;

            case WHAT_ITEM_SELECTED:
                loopview.onItemSelected();
                break;
        }
    }

}
