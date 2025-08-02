package com.horcrux.svg.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import t7.a;

public class SvgLoadEvent extends d {
    public static final String EVENT_NAME = "topLoad";
    private final float height;
    private final String uri;
    private final float width;

    public SvgLoadEvent(int i10, int i11, ReactContext reactContext, String str, float f10, float f11) {
        super(i10, i11);
        this.uri = new a(reactContext, str).d();
        this.width = f10;
        this.height = f11;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), getEventData());
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(Snapshot.WIDTH, (double) this.width);
        createMap.putDouble(Snapshot.HEIGHT, (double) this.height);
        createMap.putString("uri", this.uri);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("source", createMap);
        return createMap2;
    }

    public String getEventName() {
        return EVENT_NAME;
    }
}
