package com.facebook.react.views.modal;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.p;
import com.facebook.react.uimanager.v;
import com.facebook.react.uimanager.v0;
import e6.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p7.m;
import p7.n;

@s6.a(name = "RCTModalHostView")
public final class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> implements n {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RCTModalHostView";
    private final c2 delegate = new m(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final void addEventEmitters$lambda$0(e eVar, e1 e1Var, ReactModalHostView reactModalHostView, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.f(e1Var, "$reactContext");
        kotlin.jvm.internal.m.f(reactModalHostView, "$view");
        eVar.c(new f(k1.e(e1Var), reactModalHostView.getId()));
    }

    /* access modifiers changed from: private */
    public static final void addEventEmitters$lambda$1(e eVar, e1 e1Var, ReactModalHostView reactModalHostView, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.f(e1Var, "$reactContext");
        kotlin.jvm.internal.m.f(reactModalHostView, "$view");
        eVar.c(new g(k1.e(e1Var), reactModalHostView.getId()));
    }

    public c2 getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap<>();
        }
        Map a10 = f.a().b("topRequestClose", f.d("registrationName", "onRequestClose")).b("topShow", f.d("registrationName", "onShow")).b("topDismiss", f.d("registrationName", "onDismiss")).b("topOrientationChange", f.d("registrationName", "onOrientationChange")).a();
        kotlin.jvm.internal.m.e(a10, "build(...)");
        exportedCustomDirectEventTypeConstants.putAll(a10);
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<? extends v> getShadowNodeClass() {
        return b.class;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @h7.a(name = "animated")
    public void setAnimated(ReactModalHostView reactModalHostView, boolean z10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
    }

    @h7.a(name = "identifier")
    public void setIdentifier(ReactModalHostView reactModalHostView, int i10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
    }

    @h7.a(name = "presentationStyle")
    public void setPresentationStyle(ReactModalHostView reactModalHostView, String str) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
    }

    @h7.a(name = "supportedOrientations")
    public void setSupportedOrientations(ReactModalHostView reactModalHostView, ReadableArray readableArray) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
    }

    @h7.a(name = "visible")
    public void setVisible(ReactModalHostView reactModalHostView, boolean z10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(e1 e1Var, ReactModalHostView reactModalHostView) {
        kotlin.jvm.internal.m.f(e1Var, "reactContext");
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        e c10 = k1.c(e1Var, reactModalHostView.getId());
        if (c10 != null) {
            reactModalHostView.setOnRequestCloseListener(new c(c10, e1Var, reactModalHostView));
            reactModalHostView.setOnShowListener(new d(c10, e1Var, reactModalHostView));
            reactModalHostView.setEventDispatcher(c10);
        }
    }

    public v createShadowNodeInstance() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public ReactModalHostView createViewInstance(e1 e1Var) {
        kotlin.jvm.internal.m.f(e1Var, "reactContext");
        return new ReactModalHostView(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactModalHostView reactModalHostView) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        super.onAfterUpdateTransaction(reactModalHostView);
        reactModalHostView.showOrUpdate();
    }

    public void onDropViewInstance(ReactModalHostView reactModalHostView) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        super.onDropViewInstance(reactModalHostView);
        reactModalHostView.b();
    }

    @h7.a(name = "animationType")
    public void setAnimationType(ReactModalHostView reactModalHostView, String str) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        if (str != null) {
            reactModalHostView.setAnimationType(str);
        }
    }

    @h7.a(name = "hardwareAccelerated")
    public void setHardwareAccelerated(ReactModalHostView reactModalHostView, boolean z10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        reactModalHostView.setHardwareAccelerated(z10);
    }

    @h7.a(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(ReactModalHostView reactModalHostView, boolean z10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        reactModalHostView.setStatusBarTranslucent(z10);
    }

    @h7.a(name = "transparent")
    public void setTransparent(ReactModalHostView reactModalHostView, boolean z10) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        reactModalHostView.setTransparent(z10);
    }

    public Object updateState(ReactModalHostView reactModalHostView, v0 v0Var, d1 d1Var) {
        kotlin.jvm.internal.m.f(reactModalHostView, "view");
        kotlin.jvm.internal.m.f(v0Var, "props");
        kotlin.jvm.internal.m.f(d1Var, "stateWrapper");
        reactModalHostView.setStateWrapper(d1Var);
        Context context = reactModalHostView.getContext();
        kotlin.jvm.internal.m.e(context, "getContext(...)");
        Point a10 = a.a(context);
        reactModalHostView.d(a10.x, a10.y);
        return null;
    }
}
