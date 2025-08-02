package com.bugsnag.android;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class v {

    /* renamed from: a  reason: collision with root package name */
    private final ReactApplicationContext f19025a;

    /* renamed from: b  reason: collision with root package name */
    private DeviceEventManagerModule.RCTDeviceEventEmitter f19026b;

    /* renamed from: c  reason: collision with root package name */
    private BugsnagReactNativePlugin f19027c;

    /* renamed from: d  reason: collision with root package name */
    private s2 f19028d;

    class a implements Function1 {
        a() {
        }

        /* renamed from: a */
        public Unit invoke(x2 x2Var) {
            v.this.k(x2Var);
            return Unit.f12577a;
        }
    }

    public v(ReactApplicationContext reactApplicationContext) {
        this.f19025a = reactApplicationContext;
    }

    private void o(String str, Throwable th) {
        s2 s2Var = this.f19028d;
        s2Var.e("Failed to call " + str + " on bugsnag-plugin-react-native, continuing", th);
    }

    private String s(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            this.f19027c.addFeatureFlag(str, str2);
        } catch (Throwable th) {
            o("addFeatureFlag", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ReadableArray readableArray) {
        try {
            int size = readableArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                ReadableMap map = readableArray.getMap(i10);
                String s10 = s(map, "name");
                if (s10 != null) {
                    this.f19027c.addFeatureFlag(s10, s(map, "variant"));
                }
            }
        } catch (Throwable th) {
            o("addFeatureFlags", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str, ReadableMap readableMap) {
        HashMap<String, Object> hashMap;
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.f19027c;
            if (readableMap != null) {
                hashMap = readableMap.toHashMap();
            } else {
                hashMap = null;
            }
            bugsnagReactNativePlugin.addMetadata(str, hashMap);
        } catch (Throwable th) {
            o("addMetadata", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        try {
            this.f19027c.clearFeatureFlag(str);
        } catch (Throwable th) {
            o("clearFeatureFlag", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        try {
            this.f19027c.clearFeatureFlags();
        } catch (Throwable th) {
            o("clearFeatureFlags", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(String str, String str2) {
        try {
            this.f19027c.clearMetadata(str, str2);
        } catch (Throwable th) {
            o("clearMetadata", th);
        }
    }

    public WritableMap g(ReadableMap readableMap) {
        try {
            z a10 = r.a();
            try {
                this.f19026b = (DeviceEventManagerModule.RCTDeviceEventEmitter) this.f19025a.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                this.f19028d = a10.t();
                BugsnagReactNativePlugin bugsnagReactNativePlugin = (BugsnagReactNativePlugin) a10.x(BugsnagReactNativePlugin.class);
                this.f19027c = bugsnagReactNativePlugin;
                bugsnagReactNativePlugin.registerForMessageEvents(new a());
                return k3.b(this.f19027c.configure(readableMap.toHashMap()));
            } catch (Throwable th) {
                o("configure", th);
                return new WritableNativeMap();
            }
        } catch (IllegalStateException unused) {
            throw new IllegalStateException("Failed to initialise the native Bugsnag Android client, please check you have added Bugsnag.start() in the onCreate() method of your Application subclass");
        }
    }

    public void h(ReadableMap readableMap, Promise promise) {
        promise.resolve(g(readableMap));
    }

    /* access modifiers changed from: package-private */
    public boolean i(ReadableMap readableMap) {
        try {
            this.f19027c.dispatch(readableMap.toHashMap());
            return true;
        } catch (Throwable th) {
            o("dispatch", th);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void j(ReadableMap readableMap, Promise promise) {
        promise.resolve(Boolean.valueOf(i(readableMap)));
    }

    /* access modifiers changed from: package-private */
    public void k(x2 x2Var) {
        WritableNativeMap writableNativeMap;
        s2 s2Var = this.f19028d;
        s2Var.d("Received MessageEvent: " + x2Var.b());
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", x2Var.b());
        String b10 = x2Var.b();
        b10.hashCode();
        char c10 = 65535;
        switch (b10.hashCode()) {
            case -758218687:
                if (b10.equals("AddFeatureFlag")) {
                    c10 = 0;
                    break;
                }
                break;
            case -656234348:
                if (b10.equals("UserUpdate")) {
                    c10 = 1;
                    break;
                }
                break;
            case 669693717:
                if (b10.equals("ClearFeatureFlag")) {
                    c10 = 2;
                    break;
                }
                break;
            case 773999416:
                if (b10.equals("ContextUpdate")) {
                    c10 = 3;
                    break;
                }
                break;
            case 1070992632:
                if (b10.equals("MetadataUpdate")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
            case 4:
                if (x2Var.a() != null) {
                    writableNativeMap = Arguments.makeNativeMap((Map<String, Object>) (Map) x2Var.a());
                } else {
                    writableNativeMap = null;
                }
                createMap.putMap("data", writableNativeMap);
                break;
            case 3:
                createMap.putString("data", (String) x2Var.a());
                break;
            default:
                s2 s2Var2 = this.f19028d;
                s2Var2.g("Received unknown message event " + x2Var.b() + ", ignoring");
                break;
        }
        this.f19026b.emit("bugsnag::sync", createMap);
    }

    /* access modifiers changed from: package-private */
    public WritableMap l(ReadableMap readableMap) {
        try {
            return k3.b(this.f19027c.getPayloadInfo(readableMap.getBoolean("unhandled")));
        } catch (Throwable th) {
            o("dispatch", th);
            return new WritableNativeMap();
        }
    }

    /* access modifiers changed from: package-private */
    public void m(ReadableMap readableMap, Promise promise) {
        promise.resolve(l(readableMap));
    }

    /* access modifiers changed from: package-private */
    public void n(ReadableMap readableMap) {
        try {
            this.f19027c.leaveBreadcrumb(readableMap.toHashMap());
        } catch (Throwable th) {
            o("leaveBreadcrumb", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        try {
            this.f19027c.pauseSession();
        } catch (Throwable th) {
            o("pauseSession", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        try {
            this.f19027c.resumeSession();
        } catch (Throwable th) {
            o("resumeSession", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        try {
            if (Boolean.TRUE.equals(Boolean.valueOf(r.a().f19172o.k()))) {
                this.f19027c.resumeSession();
            }
        } catch (Throwable th) {
            o("resumeSessionOnStartup", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        try {
            this.f19027c.startSession();
        } catch (Throwable th) {
            o("startSession", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(String str) {
        try {
            this.f19027c.updateCodeBundleId(str);
        } catch (Throwable th) {
            o("updateCodeBundleId", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(String str) {
        try {
            this.f19027c.updateContext(str);
        } catch (Throwable th) {
            o("updateContext", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(String str, String str2, String str3) {
        try {
            this.f19027c.updateUser(str, str2, str3);
        } catch (Throwable th) {
            o("updateUser", th);
        }
    }
}
