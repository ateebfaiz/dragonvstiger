package com.sensorsdata.analytics.android.autotrack.core.beans;

import android.app.Activity;
import android.view.View;

public class ViewContext {
    public Activity activity;
    public Object fragment;
    public View view;

    public ViewContext(Activity activity2, Object obj) {
        this.activity = activity2;
        this.fragment = obj;
    }

    public ViewContext(View view2) {
        this.view = view2;
    }

    public ViewContext(Activity activity2, Object obj, View view2) {
        this.activity = activity2;
        this.fragment = obj;
        this.view = view2;
    }
}
