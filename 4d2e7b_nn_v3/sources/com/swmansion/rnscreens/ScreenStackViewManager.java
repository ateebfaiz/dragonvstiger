package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import com.facebook.react.uimanager.v;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import p7.z;

@s6.a(name = "RNSScreenStack")
public final class ScreenStackViewManager extends ViewGroupManager<ScreenStack> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStack";
    private final c2 delegate = new z(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void prepareOutTransition(Screen screen) {
        if (screen != null) {
            screen.k();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return i0.j(t.a("topFinishTransitioning", i0.j(t.a("registrationName", "onFinishTransitioning"))));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public void invalidate() {
        super.invalidate();
        e.f11617a.b();
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    public v createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "context");
        return new w(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public ScreenStack createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new ScreenStack(e1Var);
    }

    public void addView(ScreenStack screenStack, View view, int i10) {
        m.f(screenStack, "parent");
        m.f(view, "child");
        if (view instanceof Screen) {
            Screen screen = (Screen) view;
            e.f11617a.a(screen.getId(), screen);
            screenStack.d(screen, i10);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreen".toString());
    }

    public View getChildAt(ScreenStack screenStack, int i10) {
        m.f(screenStack, "parent");
        return screenStack.l(i10);
    }

    public int getChildCount(ScreenStack screenStack) {
        m.f(screenStack, "parent");
        return screenStack.getScreenCount();
    }

    public void removeViewAt(ScreenStack screenStack, int i10) {
        m.f(screenStack, "parent");
        Screen l10 = screenStack.l(i10);
        prepareOutTransition(l10);
        screenStack.y(i10);
        e.f11617a.c(l10.getId());
    }
}
