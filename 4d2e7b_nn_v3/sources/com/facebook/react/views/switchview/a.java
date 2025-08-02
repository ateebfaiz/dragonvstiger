package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final C0061a f4189b = new C0061a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4190a;

    /* renamed from: com.facebook.react.views.switchview.a$a  reason: collision with other inner class name */
    private static final class C0061a {
        private C0061a() {
        }

        public /* synthetic */ C0061a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10, int i11, boolean z10) {
        super(i10, i11);
        this.f4190a = z10;
    }

    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putBoolean("value", this.f4190a);
        return createMap;
    }

    public String getEventName() {
        return "topChange";
    }
}
