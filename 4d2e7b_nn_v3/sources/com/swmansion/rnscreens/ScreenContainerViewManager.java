package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.v;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.s;

@s6.a(name = "RNSScreenContainer")
public final class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenContainer";
    private final c2 delegate = new s(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public v createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "context");
        return new w(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public ScreenContainer createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new ScreenContainer(e1Var);
    }

    public void removeAllViews(ScreenContainer screenContainer) {
        m.f(screenContainer, "parent");
        screenContainer.w();
    }

    public void addView(ScreenContainer screenContainer, View view, int i10) {
        m.f(screenContainer, "parent");
        m.f(view, "child");
        if (view instanceof Screen) {
            screenContainer.d((Screen) view, i10);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens".toString());
    }

    public View getChildAt(ScreenContainer screenContainer, int i10) {
        m.f(screenContainer, "parent");
        return screenContainer.l(i10);
    }

    public int getChildCount(ScreenContainer screenContainer) {
        m.f(screenContainer, "parent");
        return screenContainer.getScreenCount();
    }

    public void removeViewAt(ScreenContainer screenContainer, int i10) {
        m.f(screenContainer, "parent");
        screenContainer.y(i10);
    }
}
