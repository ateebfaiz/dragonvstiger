package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.v;
import kotlin.jvm.internal.m;

public final class w extends v {
    private ReactContext A;

    public w(ReactContext reactContext) {
        m.f(reactContext, "context");
        this.A = reactContext;
    }

    /* access modifiers changed from: private */
    public static final void x1(w wVar, c0 c0Var) {
        m.f(wVar, "this$0");
        m.f(c0Var, "nativeViewHierarchyManager");
        View resolveView = c0Var.resolveView(wVar.q());
        if (resolveView instanceof ScreenContainer) {
            ((ScreenContainer) resolveView).u();
        }
    }

    public void V(d0 d0Var) {
        m.f(d0Var, "nativeViewHierarchyOptimizer");
        super.V(d0Var);
        UIManagerModule uIManagerModule = (UIManagerModule) this.A.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.addUIBlock(new v(this));
        }
    }
}
