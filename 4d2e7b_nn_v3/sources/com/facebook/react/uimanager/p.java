package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;

public abstract /* synthetic */ class p {
    public static void a(q qVar, View view) {
        UiThreadUtil.assertOnUiThread();
        for (int childCount = qVar.getChildCount(view) - 1; childCount >= 0; childCount--) {
            qVar.removeViewAt(view, childCount);
        }
    }
}
