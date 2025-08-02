package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import s6.a;

@a(name = "DeviceInfo")
public final class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    private float fontScale;
    private ReadableMap previousDisplayMetrics;
    private ReactApplicationContext reactApplicationContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(ReactApplicationContext reactApplicationContext2) {
        super(reactApplicationContext2);
        m.f(reactApplicationContext2, "reactContext");
        g.f(reactApplicationContext2);
        this.fontScale = reactApplicationContext2.getResources().getConfiguration().fontScale;
        reactApplicationContext2.addLifecycleEventListener(this);
        this.reactApplicationContext = reactApplicationContext2;
    }

    public final void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext2 = this.reactApplicationContext;
        if (reactApplicationContext2 == null) {
            return;
        }
        if (reactApplicationContext2.hasActiveReactInstance()) {
            WritableMap a10 = g.a((double) this.fontScale);
            ReadableMap readableMap = this.previousDisplayMetrics;
            if (readableMap == null) {
                this.previousDisplayMetrics = a10.copy();
            } else if (!m.b(a10, readableMap)) {
                this.previousDisplayMetrics = a10.copy();
                reactApplicationContext2.emitDeviceEvent("didUpdateDimensions", a10);
            }
        } else {
            ReactSoftExceptionLogger.logSoftException(NativeDeviceInfoSpec.NAME, new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
        }
    }

    public Map<String, Object> getTypedExportedConstants() {
        WritableMap a10 = g.a((double) this.fontScale);
        this.previousDisplayMetrics = a10.copy();
        return i0.d(t.a("Dimensions", a10.toHashMap()));
    }

    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContext2 = this.reactApplicationContext;
        if (reactApplicationContext2 != null) {
            reactApplicationContext2.removeLifecycleEventListener(this);
        }
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        Float f10;
        Resources resources;
        Configuration configuration;
        ReactApplicationContext reactApplicationContext2 = this.reactApplicationContext;
        if (reactApplicationContext2 == null || (resources = reactApplicationContext2.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            f10 = null;
        } else {
            f10 = Float.valueOf(configuration.fontScale);
        }
        if (f10 != null && !m.a(f10, this.fontScale)) {
            this.fontScale = f10.floatValue();
            emitUpdateDimensionsEvent();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(Context context) {
        super((ReactApplicationContext) null);
        m.f(context, "context");
        this.reactApplicationContext = null;
        g.f(context);
        this.fontScale = context.getResources().getConfiguration().fontScale;
    }
}
