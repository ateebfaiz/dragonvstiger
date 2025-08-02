package com.facebook.react.uimanager.events;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.WritableMap;

public interface RCTModernEventEmitter extends RCTEventEmitter {
    void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap);

    void receiveEvent(int i10, int i11, String str, boolean z10, int i12, @Nullable WritableMap writableMap, int i13);

    @Deprecated
    void receiveTouches(q qVar);
}
