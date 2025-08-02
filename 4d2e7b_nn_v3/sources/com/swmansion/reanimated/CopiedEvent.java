package com.swmansion.reanimated;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;

public class CopiedEvent {
    /* access modifiers changed from: private */
    public String eventName;
    /* access modifiers changed from: private */
    public WritableMap payload;
    /* access modifiers changed from: private */
    public int targetTag;

    CopiedEvent(d dVar) {
        dVar.dispatch(new RCTEventEmitter() {
            public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
                CopiedEvent.this.targetTag = i10;
                CopiedEvent.this.eventName = str;
                CopiedEvent.this.payload = writableMap.copy();
            }

            public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
            }
        });
    }

    public String getEventName() {
        return this.eventName;
    }

    public WritableMap getPayload() {
        return this.payload;
    }

    public int getTargetTag() {
        return this.targetTag;
    }
}
