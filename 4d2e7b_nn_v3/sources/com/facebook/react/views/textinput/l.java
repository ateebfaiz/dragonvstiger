package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;

public class l extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f4347a;

    /* renamed from: b  reason: collision with root package name */
    private int f4348b;

    public l(int i10, int i11, String str, int i12) {
        super(i10, i11);
        this.f4347a = str;
        this.f4348b = i12;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", this.f4347a);
        createMap.putInt("eventCount", this.f4348b);
        createMap.putInt("target", getViewTag());
        return createMap;
    }

    public String getEventName() {
        return "topChange";
    }
}
