package com.sensorsdata.analytics.android.sdk.exposure;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewTreeObserver;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform;

@SuppressLint({"NewApi"})
public class AppPageChange implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnWindowFocusChangeListener {
    private static final String TAG = "SA.AppPageChange";
    private final ExposedTransform.LayoutCallBack mLayoutCallBack;

    public AppPageChange(ExposedTransform.LayoutCallBack layoutCallBack) {
        this.mLayoutCallBack = layoutCallBack;
    }

    public void onGlobalFocusChanged(View view, View view2) {
        SALog.i(TAG, "onGlobalFocusChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }

    public void onGlobalLayout() {
        SALog.i(TAG, "onGlobalLayout");
        this.mLayoutCallBack.viewLayoutChange();
    }

    public void onScrollChanged() {
        SALog.i(TAG, "onScrollChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }

    public void onWindowFocusChanged(boolean z10) {
        SALog.i(TAG, "onWindowFocusChanged");
        this.mLayoutCallBack.viewLayoutChange();
    }
}
