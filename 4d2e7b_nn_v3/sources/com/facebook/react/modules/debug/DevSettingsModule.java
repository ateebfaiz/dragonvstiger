package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import k6.e;
import kotlin.jvm.internal.m;
import s6.a;

@a(name = "DevSettings")
public final class DevSettingsModule extends NativeDevSettingsSpec {
    private final e devSupportManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevSettingsModule(ReactApplicationContext reactApplicationContext, e eVar) {
        super(reactApplicationContext);
        m.f(eVar, "devSupportManager");
        this.devSupportManager = eVar;
    }

    /* access modifiers changed from: private */
    public static final void addMenuItem$lambda$1(String str, DevSettingsModule devSettingsModule) {
        m.f(str, "$title");
        m.f(devSettingsModule, "this$0");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("title", str);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = devSettingsModule.getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("didPressMenuItem", createMap);
        }
    }

    /* access modifiers changed from: private */
    public static final void reload$lambda$0(DevSettingsModule devSettingsModule) {
        m.f(devSettingsModule, "this$0");
        devSettingsModule.devSupportManager.r();
    }

    public void addListener(String str) {
        m.f(str, "eventName");
    }

    public void addMenuItem(String str) {
        m.f(str, "title");
        this.devSupportManager.C(str, new a(str, this));
    }

    public void onFastRefresh() {
    }

    public void openDebugger() {
        this.devSupportManager.E();
    }

    public void reload() {
        if (this.devSupportManager.n()) {
            UiThreadUtil.runOnUiThread(new b(this));
        }
    }

    public void reloadWithReason(String str) {
        m.f(str, "reason");
        reload();
    }

    public void removeListeners(double d10) {
    }

    public void setHotLoadingEnabled(boolean z10) {
        this.devSupportManager.b(z10);
    }

    public void setIsDebuggingRemotely(boolean z10) {
        this.devSupportManager.f(z10);
    }

    public void setIsShakeToShowDevMenuEnabled(boolean z10) {
    }

    public void setProfilingEnabled(boolean z10) {
        this.devSupportManager.e(z10);
    }

    public void toggleElementInspector() {
        this.devSupportManager.h();
    }
}
