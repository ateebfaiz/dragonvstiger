package com.blankj.utilcode.util;

import android.content.res.Resources;

public abstract class m {
    public static int a(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
