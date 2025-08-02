package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;

class i0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f4335a;

    /* renamed from: b  reason: collision with root package name */
    private int f4336b;

    public i0(int i10, int i11, int i12, int i13) {
        super(i10, i11);
        this.f4335a = i12;
        this.f4336b = i13;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("end", this.f4336b);
        createMap2.putInt("start", this.f4335a);
        createMap.putMap("selection", createMap2);
        return createMap;
    }

    public String getEventName() {
        return "topSelectionChange";
    }
}
