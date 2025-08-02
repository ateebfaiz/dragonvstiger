package com.facebook.react.fabric.events;

import androidx.annotation.Nullable;
import c8.a;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.q;

public class FabricEventEmitter implements RCTModernEventEmitter {
    private final FabricUIManager mUIManager;

    public FabricEventEmitter(FabricUIManager fabricUIManager) {
        this.mUIManager = fabricUIManager;
    }

    public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i10, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    public void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap) {
        receiveEvent(i10, i11, str, false, 0, writableMap, 2);
    }

    public void receiveTouches(q qVar) {
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    public void receiveEvent(int i10, int i11, String str, boolean z10, int i12, @Nullable WritableMap writableMap, int i13) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FabricEventEmitter.receiveEvent('");
        String str2 = str;
        sb2.append(str);
        sb2.append("')");
        a.c(0, sb2.toString());
        try {
            this.mUIManager.receiveEvent(i10, i11, str, z10, writableMap, i13);
        } finally {
            a.g(0);
        }
    }
}
