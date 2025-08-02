package com.facebook.react.modules.network;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.net.SocketTimeoutException;

public abstract class o {
    public static void a(ReactApplicationContext reactApplicationContext, int i10, WritableMap writableMap) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushMap(writableMap);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkData", createArray);
        }
    }

    public static void b(ReactApplicationContext reactApplicationContext, int i10, String str) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushString(str);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkData", createArray);
        }
    }

    public static void c(ReactApplicationContext reactApplicationContext, int i10, long j10, long j11) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushInt((int) j10);
        createArray.pushInt((int) j11);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkDataProgress", createArray);
        }
    }

    public static void d(ReactApplicationContext reactApplicationContext, int i10, long j10, long j11) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushInt((int) j10);
        createArray.pushInt((int) j11);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didSendNetworkData", createArray);
        }
    }

    public static void e(ReactApplicationContext reactApplicationContext, int i10, String str, long j10, long j11) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushString(str);
        createArray.pushInt((int) j10);
        createArray.pushInt((int) j11);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkIncrementalData", createArray);
        }
    }

    public static void f(ReactApplicationContext reactApplicationContext, int i10, String str, Throwable th) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushString(str);
        if (th != null && th.getClass() == SocketTimeoutException.class) {
            createArray.pushBoolean(true);
        }
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didCompleteNetworkResponse", createArray);
        }
    }

    public static void g(ReactApplicationContext reactApplicationContext, int i10) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushNull();
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didCompleteNetworkResponse", createArray);
        }
    }

    public static void h(ReactApplicationContext reactApplicationContext, int i10, int i11, WritableMap writableMap, String str) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        createArray.pushInt(i11);
        createArray.pushMap(writableMap);
        createArray.pushString(str);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkResponse", createArray);
        }
    }
}
