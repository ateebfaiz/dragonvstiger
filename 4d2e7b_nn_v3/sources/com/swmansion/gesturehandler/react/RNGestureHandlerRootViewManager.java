package com.swmansion.gesturehandler.react;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import p7.r;

@s6.a(name = "RNGestureHandlerRootView")
public final class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNGestureHandlerRootView";
    private final c2 mDelegate = new r(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return i0.j(t.a("onGestureHandlerEvent", i0.j(t.a("registrationName", "onGestureHandlerEvent"))), t.a("onGestureHandlerStateChange", i0.j(t.a("registrationName", "onGestureHandlerStateChange"))));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public RNGestureHandlerRootView createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new RNGestureHandlerRootView(e1Var);
    }

    public void onDropViewInstance(RNGestureHandlerRootView rNGestureHandlerRootView) {
        m.f(rNGestureHandlerRootView, "view");
        rNGestureHandlerRootView.q();
    }
}
