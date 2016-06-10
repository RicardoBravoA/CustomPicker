package com.rba.custompicker.control.lib;

/**
 * Created by Ricardo Bravo on 9/06/16.
 */

final class OnItemSelectedRunnable implements Runnable {
    final PickerView loopView;

    OnItemSelectedRunnable(PickerView loopview) {
        loopView = loopview;
    }

    @Override
    public final void run() {
        loopView.onItemSelectedListener.onItemSelected(loopView.getCurrentItem());
    }
}

