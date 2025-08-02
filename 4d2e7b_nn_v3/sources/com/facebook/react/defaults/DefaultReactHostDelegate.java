package com.facebook.react.defaults;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.g;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.facebook.react.s0;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@DoNotStrip
public final class DefaultReactHostDelegate implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f2936a;

    /* renamed from: b  reason: collision with root package name */
    private final JSBundleLoader f2937b;

    /* renamed from: c  reason: collision with root package name */
    private final List f2938c;

    /* renamed from: d  reason: collision with root package name */
    private final JSRuntimeFactory f2939d;

    /* renamed from: e  reason: collision with root package name */
    private final BindingsInstaller f2940e;

    /* renamed from: f  reason: collision with root package name */
    private final ReactNativeConfig f2941f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1 f2942g;

    /* renamed from: h  reason: collision with root package name */
    private final s0.a f2943h;

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f2944a = new a();

        a() {
            super(1);
        }

        public final void a(Exception exc) {
            m.f(exc, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Exception) obj);
            return Unit.f12577a;
        }
    }

    public DefaultReactHostDelegate(String str, JSBundleLoader jSBundleLoader, List list, JSRuntimeFactory jSRuntimeFactory, BindingsInstaller bindingsInstaller, ReactNativeConfig reactNativeConfig, Function1 function1, s0.a aVar) {
        m.f(str, "jsMainModulePath");
        m.f(jSBundleLoader, "jsBundleLoader");
        m.f(list, "reactPackages");
        m.f(jSRuntimeFactory, "jsRuntimeFactory");
        m.f(reactNativeConfig, "reactNativeConfig");
        m.f(function1, "exceptionHandler");
        m.f(aVar, "turboModuleManagerDelegateBuilder");
        this.f2936a = str;
        this.f2937b = jSBundleLoader;
        this.f2938c = list;
        this.f2939d = jSRuntimeFactory;
        this.f2940e = bindingsInstaller;
        this.f2941f = reactNativeConfig;
        this.f2942g = function1;
        this.f2943h = aVar;
    }

    public JSRuntimeFactory a() {
        return this.f2939d;
    }

    public ReactNativeConfig b() {
        return this.f2941f;
    }

    public List c() {
        return this.f2938c;
    }

    public void d(Exception exc) {
        m.f(exc, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        this.f2942g.invoke(exc);
    }

    public JSBundleLoader e() {
        return this.f2937b;
    }

    public s0.a f() {
        return this.f2943h;
    }

    public String g() {
        return this.f2936a;
    }

    public BindingsInstaller getBindingsInstaller() {
        return this.f2940e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultReactHostDelegate(String str, JSBundleLoader jSBundleLoader, List list, JSRuntimeFactory jSRuntimeFactory, BindingsInstaller bindingsInstaller, ReactNativeConfig reactNativeConfig, Function1 function1, s0.a aVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jSBundleLoader, (i10 & 4) != 0 ? r.l() : list, (i10 & 8) != 0 ? new HermesInstance() : jSRuntimeFactory, (i10 & 16) != 0 ? null : bindingsInstaller, (i10 & 32) != 0 ? ReactNativeConfig.DEFAULT_CONFIG : reactNativeConfig, (i10 & 64) != 0 ? a.f2944a : function1, aVar);
    }
}
