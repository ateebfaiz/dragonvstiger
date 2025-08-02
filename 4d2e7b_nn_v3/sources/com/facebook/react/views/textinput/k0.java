package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;

class k0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f4346a;

    public k0(int i10, int i11, String str) {
        super(i10, i11);
        this.f4346a = str;
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putString("text", this.f4346a);
        return createMap;
    }

    public String getEventName() {
        return "topSubmitEditing";
    }
}
