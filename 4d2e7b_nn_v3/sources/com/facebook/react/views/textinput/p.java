package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;

class p extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f4350a;

    p(int i10, String str) {
        this(-1, i10, str);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", this.f4350a);
        return createMap;
    }

    public String getEventName() {
        return "topKeyPress";
    }

    p(int i10, int i11, String str) {
        super(i10, i11);
        this.f4350a = str;
    }
}
