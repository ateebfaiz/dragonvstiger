package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11711c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a f11712a;

    /* renamed from: b  reason: collision with root package name */
    private final c f11713b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i10, int i11, a aVar, c cVar) {
        super(i11);
        m.f(aVar, "mInsets");
        m.f(cVar, "mFrame");
        this.f11712a = aVar;
        this.f11713b = cVar;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("insets", o.b(this.f11712a));
        createMap.putMap("frame", o.d(this.f11713b));
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createMap);
    }

    public String getEventName() {
        return "topInsetsChange";
    }
}
