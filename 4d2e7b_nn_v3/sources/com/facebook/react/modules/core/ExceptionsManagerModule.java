package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import k6.e;
import o7.b;
import s6.a;

@a(name = "ExceptionsManager")
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {
    private final e mDevSupportManager;

    public ExceptionsManagerModule(e eVar) {
        super((ReactApplicationContext) null);
        this.mDevSupportManager = eVar;
    }

    public void dismissRedbox() {
        if (this.mDevSupportManager.n()) {
            this.mDevSupportManager.p();
        }
    }

    public void reportException(ReadableMap readableMap) {
        String str;
        ReadableArray readableArray;
        boolean z10;
        if (readableMap.hasKey("message")) {
            str = readableMap.getString("message");
        } else {
            str = "";
        }
        if (readableMap.hasKey("stack")) {
            readableArray = readableMap.getArray("stack");
        } else {
            readableArray = Arguments.createArray();
        }
        if (readableMap.hasKey("isFatal")) {
            z10 = readableMap.getBoolean("isFatal");
        } else {
            z10 = false;
        }
        String a10 = o7.a.a(readableMap);
        if (!z10) {
            z2.a.j("ReactNative", b.a(str, readableArray));
            if (a10 != null) {
                z2.a.c("ReactNative", "extraData: %s", a10);
                return;
            }
            return;
        }
        throw new JavascriptException(b.a(str, readableArray)).setExtraDataAsJson(a10);
    }

    public void reportFatalException(String str, ReadableArray readableArray, double d10) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d10);
        javaOnlyMap.putBoolean("isFatal", true);
        reportException(javaOnlyMap);
    }

    public void reportSoftException(String str, ReadableArray readableArray, double d10) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d10);
        javaOnlyMap.putBoolean("isFatal", false);
        reportException(javaOnlyMap);
    }

    public void updateExceptionMessage(String str, ReadableArray readableArray, double d10) {
        int i10 = (int) d10;
        if (this.mDevSupportManager.n()) {
            this.mDevSupportManager.F(str, readableArray, i10);
        }
    }
}
