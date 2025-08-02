package com.bugsnag.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class BugsnagReactNativePlugin implements i3 {
    private final l appSerializer = new l();
    private final q breadcrumbSerializer = new q();
    public z client;
    private final e0 configSerializer = new e0();
    private final h1 deviceSerializer = new h1();
    private boolean ignoreJsExceptionCallbackAdded;
    public f2 internalHooks;
    private Function1<? super x2, Unit> jsCallback;
    public s2 logger;
    private u observerBridge;
    private final e4 threadSerializer = new e4();

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BugsnagReactNativePlugin f18586a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BugsnagReactNativePlugin bugsnagReactNativePlugin) {
            super(1);
            this.f18586a = bugsnagReactNativePlugin;
        }

        public final void a(x2 x2Var) {
            Function1<x2, Unit> jsCallback = this.f18586a.getJsCallback();
            if (jsCallback != null) {
                jsCallback.invoke(x2Var);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((x2) obj);
            return Unit.f12577a;
        }
    }

    private final void ignoreJavaScriptExceptions() {
        this.ignoreJsExceptionCallbackAdded = true;
        getClient$bugsnag_plugin_react_native_release().e(new w());
    }

    /* access modifiers changed from: private */
    /* renamed from: ignoreJavaScriptExceptions$lambda-2  reason: not valid java name */
    public static final boolean m168ignoreJavaScriptExceptions$lambda2(o1 o1Var) {
        return !m.b(((k1) o1Var.h().get(0)).b(), "com.facebook.react.common.JavascriptException");
    }

    private final void updateNotifierInfo(Map<String, ? extends Object> map) {
        String str = (String) map.get("reactNativeVersion");
        if (str != null) {
            getClient$bugsnag_plugin_react_native_release().f("reactNative", str);
        }
        String str2 = (String) map.get("engine");
        if (str2 != null) {
            getClient$bugsnag_plugin_react_native_release().f("reactNativeJsEngine", str2);
        }
        Object obj = map.get("notifierVersion");
        if (obj != null) {
            e3 e3Var = getClient$bugsnag_plugin_react_native_release().f19179v;
            e3Var.f("Bugsnag React Native");
            e3Var.g("https://github.com/bugsnag/bugsnag-js");
            e3Var.h((String) obj);
            e3Var.e(r.e(new e3((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null)));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void addFeatureFlag(String str, String str2) {
        getClient$bugsnag_plugin_react_native_release().a(str, str2);
    }

    public final void addMetadata(String str, Map<String, ? extends Object> map) {
        if (map == null) {
            getClient$bugsnag_plugin_react_native_release().i(str);
        } else {
            getClient$bugsnag_plugin_react_native_release().c(str, map);
        }
    }

    public final void clearFeatureFlag(String str) {
        getClient$bugsnag_plugin_react_native_release().g(str);
    }

    public final void clearFeatureFlags() {
        getClient$bugsnag_plugin_react_native_release().h();
    }

    public final void clearMetadata(String str, String str2) {
        if (str2 == null) {
            getClient$bugsnag_plugin_react_native_release().i(str);
        } else {
            getClient$bugsnag_plugin_react_native_release().j(str, str2);
        }
    }

    public final Map<String, Object> configure(Map<String, ? extends Object> map) {
        if (map != null) {
            updateNotifierInfo(map);
            if (!this.ignoreJsExceptionCallbackAdded) {
                ignoreJavaScriptExceptions();
            }
            HashMap hashMap = new HashMap();
            this.configSerializer.a(hashMap, getClient$bugsnag_plugin_react_native_release().m());
            return hashMap;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void dispatch(Map<String, Object> map) {
        if (map != null) {
            o1 a10 = new p1(getClient$bugsnag_plugin_react_native_release(), getInternalHooks$bugsnag_plugin_react_native_release().e(getClient$bugsnag_plugin_react_native_release().m())).a(map);
            if (!a10.h().isEmpty()) {
                if (!getClient$bugsnag_plugin_react_native_release().f19158a.N(((k1) a10.h().get(0)).b())) {
                    getClient$bugsnag_plugin_react_native_release().G(a10, (h3) null);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final z getClient$bugsnag_plugin_react_native_release() {
        z zVar = this.client;
        if (zVar != null) {
            return zVar;
        }
        m.u("client");
        return null;
    }

    public final f2 getInternalHooks$bugsnag_plugin_react_native_release() {
        f2 f2Var = this.internalHooks;
        if (f2Var != null) {
            return f2Var;
        }
        m.u("internalHooks");
        return null;
    }

    public final Function1<x2, Unit> getJsCallback() {
        return this.jsCallback;
    }

    public final s2 getLogger() {
        s2 s2Var = this.logger;
        if (s2Var != null) {
            return s2Var;
        }
        m.u("logger");
        return null;
    }

    public final Map<String, Object> getPayloadInfo(boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.appSerializer.a(linkedHashMap2, getInternalHooks$bugsnag_plugin_react_native_release().b());
        linkedHashMap.put("app", linkedHashMap2);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.deviceSerializer.a(linkedHashMap3, getInternalHooks$bugsnag_plugin_react_native_release().d());
        linkedHashMap.put("device", linkedHashMap3);
        Iterable<Breadcrumb> l10 = getClient$bugsnag_plugin_react_native_release().l();
        ArrayList arrayList = new ArrayList(r.v(l10, 10));
        for (Breadcrumb a10 : l10) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            this.breadcrumbSerializer.a(linkedHashMap4, a10);
            arrayList.add(linkedHashMap4);
        }
        linkedHashMap.put("breadcrumbs", arrayList);
        Iterable<a4> f10 = getInternalHooks$bugsnag_plugin_react_native_release().f(z10);
        ArrayList arrayList2 = new ArrayList(r.v(f10, 10));
        for (a4 a11 : f10) {
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            this.threadSerializer.a(linkedHashMap5, a11);
            arrayList2.add(linkedHashMap5);
        }
        linkedHashMap.put("threads", arrayList2);
        linkedHashMap.put("appMetadata", getInternalHooks$bugsnag_plugin_react_native_release().a());
        linkedHashMap.put("deviceMetadata", getInternalHooks$bugsnag_plugin_react_native_release().c());
        return linkedHashMap;
    }

    public final void leaveBreadcrumb(Map<String, ? extends Object> map) {
        if (map != null) {
            Object obj = map.get("message");
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = map.get("type");
                if (obj2 != null) {
                    String upperCase = ((String) obj2).toUpperCase(Locale.ROOT);
                    m.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    BreadcrumbType valueOf = BreadcrumbType.valueOf(upperCase);
                    Object obj3 = map.get("metadata");
                    if (obj3 == null) {
                        obj3 = i0.f();
                    }
                    getClient$bugsnag_plugin_react_native_release().B(str, (Map) obj3, valueOf);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void load(z zVar) {
        setClient$bugsnag_plugin_react_native_release(zVar);
        setLogger(zVar.f19174q);
        setInternalHooks$bugsnag_plugin_react_native_release(new f2(zVar));
        u uVar = new u(zVar, new a(this));
        this.observerBridge = uVar;
        zVar.d(uVar);
        zVar.f19174q.f("Initialized React Native Plugin");
    }

    public final void pauseSession() {
        getClient$bugsnag_plugin_react_native_release().I();
    }

    public final void registerForMessageEvents(Function1<? super x2, Unit> function1) {
        this.jsCallback = function1;
        getClient$bugsnag_plugin_react_native_release().a0();
    }

    public final void resumeSession() {
        getClient$bugsnag_plugin_react_native_release().P();
    }

    public final void setClient$bugsnag_plugin_react_native_release(z zVar) {
        this.client = zVar;
    }

    public final void setInternalHooks$bugsnag_plugin_react_native_release(f2 f2Var) {
        this.internalHooks = f2Var;
    }

    public final void setJsCallback(Function1<? super x2, Unit> function1) {
        this.jsCallback = function1;
    }

    public final void setLogger(s2 s2Var) {
        this.logger = s2Var;
    }

    public final void startSession() {
        getClient$bugsnag_plugin_react_native_release().Z();
    }

    public void unload() {
    }

    public final void updateCodeBundleId(String str) {
        getClient$bugsnag_plugin_react_native_release().T(str);
    }

    public final void updateContext(String str) {
        getClient$bugsnag_plugin_react_native_release().U(str);
    }

    public final void updateUser(String str, String str2, String str3) {
        getClient$bugsnag_plugin_react_native_release().V(str, str2, str3);
    }
}
