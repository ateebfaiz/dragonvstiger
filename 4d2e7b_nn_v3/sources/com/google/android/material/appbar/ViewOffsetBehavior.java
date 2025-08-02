package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private f viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public int getLeftAndRightOffset() {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.c();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.d();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        f fVar = this.viewOffsetHelper;
        if (fVar == null || !fVar.e()) {
            return false;
        }
        return true;
    }

    public boolean isVerticalOffsetEnabled() {
        f fVar = this.viewOffsetHelper;
        if (fVar == null || !fVar.f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        coordinatorLayout.onLayoutChild(v10, i10);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
        layoutChild(coordinatorLayout, view, i10);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new f(view);
        }
        this.viewOffsetHelper.g();
        this.viewOffsetHelper.a();
        int i11 = this.tempTopBottomOffset;
        if (i11 != 0) {
            this.viewOffsetHelper.j(i11);
            this.tempTopBottomOffset = 0;
        }
        int i12 = this.tempLeftRightOffset;
        if (i12 == 0) {
            return true;
        }
        this.viewOffsetHelper.i(i12);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.h(z10);
        }
    }

    public boolean setLeftAndRightOffset(int i10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.i(i10);
        }
        this.tempLeftRightOffset = i10;
        return false;
    }

    public boolean setTopAndBottomOffset(int i10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.j(i10);
        }
        this.tempTopBottomOffset = i10;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.k(z10);
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
