package com.facebook.react.defaults;

import android.app.Application;
import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManagerProviderImpl;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.h;
import com.facebook.react.k0;
import com.facebook.react.s0;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.j2;
import com.facebook.react.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.n;

public abstract class b extends k0 {

    public static final class a implements j2 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f2949a;

        a(b bVar) {
            this.f2949a = bVar;
        }

        public Collection a() {
            return this.f2949a.p().H();
        }

        public ViewManager b(String str) {
            m.f(str, "viewManagerName");
            return this.f2949a.p().y(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected b(Application application) {
        super(application);
        m.f(application, "application");
    }

    /* access modifiers changed from: private */
    public static final UIManager y(b bVar, ReactApplicationContext reactApplicationContext) {
        i2 i2Var;
        m.f(bVar, "this$0");
        m.f(reactApplicationContext, "reactApplicationContext");
        ComponentFactory componentFactory = new ComponentFactory();
        DefaultComponentsRegistry.f2935a.register(componentFactory);
        if (bVar.m()) {
            i2Var = new i2((j2) new a(bVar));
        } else {
            i2Var = new i2(bVar.p().G(reactApplicationContext));
        }
        return new FabricUIManagerProviderImpl(componentFactory, ReactNativeConfig.DEFAULT_CONFIG, i2Var).createUIManager(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public abstract boolean A();

    public final x B(Context context) {
        boolean z10;
        m.f(context, "context");
        List n10 = n();
        m.e(n10, "getPackages(...)");
        String k10 = k();
        m.e(k10, "getJSMainModuleName(...)");
        String d10 = d();
        if (d10 == null) {
            d10 = FirebaseAnalytics.Param.INDEX;
        }
        String str = d10;
        Boolean z11 = z();
        if (z11 != null) {
            z10 = z11.booleanValue();
        } else {
            z10 = true;
        }
        return a.c(context, n10, k10, str, z10, v(), (List) null, 64, (Object) null);
    }

    /* access modifiers changed from: protected */
    public h i() {
        Boolean z10 = z();
        if (m.b(z10, Boolean.TRUE)) {
            return h.HERMES;
        }
        if (m.b(z10, Boolean.FALSE)) {
            return h.JSC;
        }
        if (z10 == null) {
            return null;
        }
        throw new n();
    }

    /* access modifiers changed from: protected */
    public s0.a q() {
        if (A()) {
            return new DefaultTurboModuleManagerDelegate.a();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public UIManagerProvider u() {
        if (A()) {
            return new j6.a(this);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Boolean z();
}
