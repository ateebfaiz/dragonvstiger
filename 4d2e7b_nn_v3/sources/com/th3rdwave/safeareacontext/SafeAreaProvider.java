package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.m;
import vb.n;

public final class SafeAreaProvider extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private n f11698a;

    /* renamed from: b  reason: collision with root package name */
    private a f11699b;

    /* renamed from: c  reason: collision with root package name */
    private c f11700c;

    public SafeAreaProvider(Context context) {
        super(context);
    }

    private final void p() {
        a e10;
        n nVar = this.f11698a;
        if (nVar != null && (e10 = g.e(this)) != null) {
            View rootView = getRootView();
            m.d(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            c a10 = g.a((ViewGroup) rootView, this);
            if (a10 != null) {
                if (!m.b(this.f11699b, e10) || !m.b(this.f11700c, a10)) {
                    nVar.e(this, e10, a10);
                    this.f11699b = e10;
                    this.f11700c = a10;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        p();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        p();
        return true;
    }

    public final void setOnInsetsChangeHandler(n nVar) {
        this.f11698a = nVar;
        p();
    }
}
