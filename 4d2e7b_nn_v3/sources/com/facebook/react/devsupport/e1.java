package com.facebook.react.devsupport;

import android.os.Build;

public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public static final e1 f3072a = new e1();

    /* renamed from: b  reason: collision with root package name */
    public static final int f3073b;

    static {
        int i10;
        if (Build.VERSION.SDK_INT < 26) {
            i10 = 2006;
        } else {
            i10 = 2038;
        }
        f3073b = i10;
    }

    private e1() {
    }
}
