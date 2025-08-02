package com.facebook.react.internal.interop;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import kotlin.jvm.internal.m;
import p6.a;

public final class InteropEventEmitter implements RCTEventEmitter {
    private e eventDispatcherOverride;
    private final ReactContext reactContext;

    public InteropEventEmitter(ReactContext reactContext2) {
        m.f(reactContext2, "reactContext");
        this.reactContext = reactContext2;
    }

    public final void overrideEventDispatcher(e eVar) {
        this.eventDispatcherOverride = eVar;
    }

    public void receiveEvent(int i10, String str, WritableMap writableMap) {
        m.f(str, "eventName");
        e eVar = this.eventDispatcherOverride;
        if (eVar == null) {
            eVar = k1.c(this.reactContext, i10);
        }
        int e10 = k1.e(this.reactContext);
        if (eVar != null) {
            eVar.c(new a(str, writableMap, e10, i10));
        }
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        m.f(str, "eventName");
        m.f(writableArray, "touches");
        m.f(writableArray2, "changedIndices");
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by the Fabric Interop Layer");
    }
}
