package com.facebook.react.views.unimplementedview;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "UnimplementedNativeView")
public final class ReactUnimplementedViewManager extends ViewGroupManager<ReactUnimplementedView> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "UnimplementedNativeView";

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

    @h7.a(name = "name")
    public final void setName(ReactUnimplementedView reactUnimplementedView, String str) {
        m.f(reactUnimplementedView, "view");
        m.f(str, "name");
        reactUnimplementedView.setName(str);
    }

    /* access modifiers changed from: protected */
    public ReactUnimplementedView createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new ReactUnimplementedView(e1Var);
    }
}
