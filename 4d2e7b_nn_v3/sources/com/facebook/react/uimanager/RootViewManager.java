package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class RootViewManager extends ViewGroupManager<ViewGroup> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RootView";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public ViewGroup createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new FrameLayout(e1Var);
    }
}
