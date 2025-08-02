package com.facebook.react.uimanager.events;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import d6.a;

@Deprecated
@a
public interface RCTEventEmitter extends JavaScriptModule {
    @Deprecated
    void receiveEvent(int i10, String str, @Nullable WritableMap writableMap);

    @Deprecated
    void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2);
}
