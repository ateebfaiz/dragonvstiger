package com.facebook.react.views.scroll;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.a;
import com.facebook.react.views.view.ReactViewGroup;

public class ReactHorizontalScrollContainerView extends ReactViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f4064a;

    public ReactHorizontalScrollContainerView(Context context) {
        super(context);
        this.f4064a = a.f().i(context) ? 1 : 0;
    }

    public int getLayoutDirection() {
        if (o6.a.d()) {
            return super.getLayoutDirection();
        }
        return this.f4064a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (getLayoutDirection() == 1) {
            setLeft(0);
            setTop(i11);
            setRight(i12 - i10);
            setBottom(i13);
        }
    }

    public void setRemoveClippedSubviews(boolean z10) {
        if (getLayoutDirection() == 1) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z10);
        }
    }
}
