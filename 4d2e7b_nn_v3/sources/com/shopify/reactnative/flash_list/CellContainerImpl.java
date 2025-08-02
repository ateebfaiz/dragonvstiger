package com.shopify.reactnative.flash_list;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.m;

public final class CellContainerImpl extends ReactViewGroup implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f11350a = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellContainerImpl(Context context) {
        super(context);
        m.f(context, "context");
    }

    public int getIndex() {
        return this.f11350a;
    }

    public void setIndex(int i10) {
        this.f11350a = i10;
    }
}
