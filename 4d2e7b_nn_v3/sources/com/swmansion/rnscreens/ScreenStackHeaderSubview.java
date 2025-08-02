package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.m;

@SuppressLint({"ViewConstructor"})
public final class ScreenStackHeaderSubview extends ReactViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f11572a;

    /* renamed from: b  reason: collision with root package name */
    private int f11573b;

    /* renamed from: c  reason: collision with root package name */
    private a f11574c = a.RIGHT;

    public enum a {
        LEFT,
        CENTER,
        RIGHT,
        BACK,
        SEARCH_BAR;

        static {
            a[] a10;
            f11581g = pb.a.a(a10);
        }
    }

    public ScreenStackHeaderSubview(ReactContext reactContext) {
        super(reactContext);
    }

    public final ScreenStackHeaderConfig getConfig() {
        CustomToolbar customToolbar;
        ViewParent parent = getParent();
        if (parent instanceof CustomToolbar) {
            customToolbar = (CustomToolbar) parent;
        } else {
            customToolbar = null;
        }
        if (customToolbar != null) {
            return customToolbar.getConfig();
        }
        return null;
    }

    public final a getType() {
        return this.f11574c;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) == 1073741824 && View.MeasureSpec.getMode(i11) == 1073741824) {
            this.f11572a = View.MeasureSpec.getSize(i10);
            this.f11573b = View.MeasureSpec.getSize(i11);
            ViewParent parent = getParent();
            if (parent != null) {
                forceLayout();
                ((View) parent).requestLayout();
            }
        }
        setMeasuredDimension(this.f11572a, this.f11573b);
    }

    public final void setType(a aVar) {
        m.f(aVar, "<set-?>");
        this.f11574c = aVar;
    }
}
