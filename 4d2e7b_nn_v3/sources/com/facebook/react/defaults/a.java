package com.facebook.react.defaults;

import android.content.Context;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.h;
import com.facebook.react.k0;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSCInstance;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.facebook.react.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2947a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static x f2948b;

    private a() {
    }

    public static final x a(Context context, k0 k0Var) {
        m.f(context, "context");
        m.f(k0Var, "reactNativeHost");
        if (k0Var instanceof b) {
            return ((b) k0Var).B(context);
        }
        throw new IllegalArgumentException("You can call getDefaultReactHost only with instances of DefaultReactNativeHost".toString());
    }

    public static final x b(Context context, List list, String str, String str2, boolean z10, boolean z11, List list2) {
        JSRuntimeFactory jSCInstance;
        h hVar;
        Context context2 = context;
        String str3 = str2;
        List<Function1> list3 = list2;
        m.f(context, "context");
        m.f(list, "packageList");
        m.f(str, "jsMainModulePath");
        m.f(str3, "jsBundleAssetPath");
        m.f(list3, "cxxReactPackageProviders");
        if (f2948b == null) {
            JSBundleLoader createAssetLoader = JSBundleLoader.createAssetLoader(context, "assets://" + str3, true);
            if (z10) {
                jSCInstance = new HermesInstance();
            } else {
                jSCInstance = new JSCInstance();
            }
            JSRuntimeFactory jSRuntimeFactory = jSCInstance;
            DefaultTurboModuleManagerDelegate.a aVar = new DefaultTurboModuleManagerDelegate.a();
            for (Function1 e10 : list3) {
                aVar.e(e10);
            }
            m.c(createAssetLoader);
            DefaultReactHostDelegate defaultReactHostDelegate = new DefaultReactHostDelegate(str, createAssetLoader, list, jSRuntimeFactory, (BindingsInstaller) null, (ReactNativeConfig) null, (Function1) null, aVar, 112, (DefaultConstructorMarker) null);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.f2935a.register(componentFactory);
            ReactHostImpl reactHostImpl = new ReactHostImpl(context, defaultReactHostDelegate, componentFactory, true, z11);
            if (z10) {
                hVar = h.HERMES;
            } else {
                hVar = h.JSC;
            }
            reactHostImpl.B1(hVar);
            f2948b = reactHostImpl;
        }
        x xVar = f2948b;
        m.d(xVar, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return xVar;
    }

    public static /* synthetic */ x c(Context context, List list, String str, String str2, boolean z10, boolean z11, List list2, int i10, Object obj) {
        String str3;
        boolean z12;
        boolean z13;
        List list3;
        int i11 = i10 & 4;
        String str4 = FirebaseAnalytics.Param.INDEX;
        if (i11 != 0) {
            str3 = str4;
        } else {
            str3 = str;
        }
        if ((i10 & 8) == 0) {
            str4 = str2;
        }
        if ((i10 & 16) != 0) {
            z12 = true;
        } else {
            z12 = z10;
        }
        if ((i10 & 32) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        if ((i10 & 64) != 0) {
            list3 = r.l();
        } else {
            list3 = list2;
        }
        return b(context, list, str3, str4, z12, z13, list3);
    }
}
