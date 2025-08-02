package com.facebook.react.fabric.events;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricSoLoader;
import d6.a;

@SuppressLint({"MissingNativeLoadLibrary"})
@a
public class EventEmitterWrapper {
    @a
    private final HybridData mHybridData;

    static {
        FabricSoLoader.staticInit();
    }

    @a
    private EventEmitterWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private native void dispatchEvent(String str, @Nullable NativeMap nativeMap, int i10);

    private native void dispatchEventSynchronously(String str, @Nullable NativeMap nativeMap);

    private native void dispatchUniqueEvent(String str, @Nullable NativeMap nativeMap);

    private boolean isValid() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            return hybridData.isValid();
        }
        return false;
    }

    public synchronized void destroy() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            hybridData.resetNative();
        }
    }

    public synchronized void dispatch(String str, @Nullable WritableMap writableMap, int i10) {
        if (isValid()) {
            dispatchEvent(str, (NativeMap) writableMap, i10);
        }
    }

    public synchronized void dispatchEventSynchronously(String str, @Nullable WritableMap writableMap) {
        if (isValid()) {
            dispatchEventSynchronously(str, (NativeMap) writableMap);
        }
    }

    public synchronized void dispatchUnique(String str, @Nullable WritableMap writableMap) {
        if (isValid()) {
            dispatchUniqueEvent(str, (NativeMap) writableMap);
        }
    }
}
