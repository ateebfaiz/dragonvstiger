package com.facebook.react.uimanager;

import android.view.View;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f3545a = new a0();

    private a0() {
    }

    public static final void a(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
        }
    }
}
