package com.facebook.react.views.swiperefresh;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;

public final class a extends d {
    protected a(int i10, int i11) {
        super(i10, i11);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    public String getEventName() {
        return "topRefresh";
    }
}
