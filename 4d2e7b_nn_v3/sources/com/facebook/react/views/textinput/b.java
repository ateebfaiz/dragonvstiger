package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private float f4322a;

    /* renamed from: b  reason: collision with root package name */
    private float f4323b;

    public b(int i10, int i11, float f10, float f11) {
        super(i10, i11);
        this.f4322a = f10;
        this.f4323b = f11;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(Snapshot.WIDTH, (double) this.f4322a);
        createMap2.putDouble(Snapshot.HEIGHT, (double) this.f4323b);
        createMap.putMap("contentSize", createMap2);
        createMap.putInt("target", getViewTag());
        return createMap;
    }

    public String getEventName() {
        return "topContentSizeChange";
    }
}
