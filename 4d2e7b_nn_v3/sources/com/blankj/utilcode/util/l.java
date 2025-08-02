package com.blankj.utilcode.util;

import android.graphics.Point;
import android.view.WindowManager;

public abstract class l {
    public static int a() {
        WindowManager windowManager = (WindowManager) p.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }
}
