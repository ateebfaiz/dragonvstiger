package com.blankj.utilcode.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public final class ToastUtils$UtilsMaxWidthRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18394a = s.a(80.0f);

    public ToastUtils$UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(s.c() - f18394a, Integer.MIN_VALUE), i11);
    }

    public ToastUtils$UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
