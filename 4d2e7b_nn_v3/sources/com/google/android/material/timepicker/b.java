package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

abstract class b extends AccessibilityDelegateCompat {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat f8715a;

    public b(Context context, int i10) {
        this.f8715a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i10));
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.f8715a);
    }
}
