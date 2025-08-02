package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f3588a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3589b;

    public c(int i10, int i11, int i12) {
        this(-1, i10, i11, i12);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(Snapshot.WIDTH, (double) g0.b((float) this.f3588a));
        createMap.putDouble(Snapshot.HEIGHT, (double) g0.b((float) this.f3589b));
        return createMap;
    }

    public String getEventName() {
        return "topContentSizeChange";
    }

    public c(int i10, int i11, int i12, int i13) {
        super(i10, i11);
        this.f3588a = i12;
        this.f3589b = i13;
    }
}
