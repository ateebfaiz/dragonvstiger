package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.d1;
import d6.a;

@SuppressLint({"MissingNativeLoadLibrary"})
@a
public class StateWrapperImpl implements d1 {
    private static final String TAG = "StateWrapperImpl";
    private volatile boolean mDestroyed = false;
    @a
    private final HybridData mHybridData = initHybrid();

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    private native ReadableNativeMap getStateDataImpl();

    private native ReadableMapBuffer getStateMapBufferDataImpl();

    private static native HybridData initHybrid();

    public void destroyState() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            this.mHybridData.resetNative();
        }
    }

    @Nullable
    public ReadableNativeMap getStateData() {
        if (!this.mDestroyed) {
            return getStateDataImpl();
        }
        z2.a.j(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    @Nullable
    public ReadableMapBuffer getStateDataMapBuffer() {
        if (!this.mDestroyed) {
            return getStateMapBufferDataImpl();
        }
        z2.a.j(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    public String toString() {
        if (this.mDestroyed) {
            return "<destroyed>";
        }
        ReadableMapBuffer stateMapBufferDataImpl = getStateMapBufferDataImpl();
        if (stateMapBufferDataImpl != null) {
            return stateMapBufferDataImpl.toString();
        }
        ReadableNativeMap stateDataImpl = getStateDataImpl();
        if (stateDataImpl == null) {
            return "<unexpected null>";
        }
        return stateDataImpl.toString();
    }

    public void updateState(@NonNull WritableMap writableMap) {
        if (this.mDestroyed) {
            z2.a.j(TAG, "Race between StateWrapperImpl destruction and updateState");
        } else {
            updateStateImpl((NativeMap) writableMap);
        }
    }

    public native void updateStateImpl(@NonNull NativeMap nativeMap);
}
