package com.shopify.reactnative.flash_list;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11361c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final double f11362a;

    /* renamed from: b  reason: collision with root package name */
    private final double f11363b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(int i10, int i11, double d10, double d11) {
        super(i10, i11);
        this.f11362a = d10;
        this.f11363b = d11;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), getEventData());
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offsetStart", this.f11362a);
        createMap.putDouble("offsetEnd", this.f11363b);
        m.e(createMap, "apply(...)");
        return createMap;
    }

    public String getEventName() {
        return "onBlankAreaEvent";
    }
}
