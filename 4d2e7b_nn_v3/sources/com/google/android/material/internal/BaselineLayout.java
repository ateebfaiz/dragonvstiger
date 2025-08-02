package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline = -1;

    public BaselineLayout(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public int getBaseline() {
        return this.baseline;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i12 - i10) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i16 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.baseline == -1 || childAt.getBaseline() == -1) {
                    i14 = paddingTop;
                } else {
                    i14 = (this.baseline + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i16, i14, measuredWidth + i16, measuredHeight + i14);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                int baseline2 = childAt.getBaseline();
                if (baseline2 != -1) {
                    i15 = Math.max(i15, baseline2);
                    i16 = Math.max(i16, childAt.getMeasuredHeight() - baseline2);
                }
                i13 = Math.max(i13, childAt.getMeasuredWidth());
                i12 = Math.max(i12, childAt.getMeasuredHeight());
                i14 = View.combineMeasuredStates(i14, childAt.getMeasuredState());
            }
        }
        if (i15 != -1) {
            i12 = Math.max(i12, Math.max(i16, getPaddingBottom()) + i15);
            this.baseline = i15;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i13, getSuggestedMinimumWidth()), i10, i14), View.resolveSizeAndState(Math.max(i12, getSuggestedMinimumHeight()), i11, i14 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
