package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4057a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(int i10, int i11) {
        super(i10, i11);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        m.e(createMap, "createMap(...)");
        return createMap;
    }

    public String getEventName() {
        return "topRequestClose";
    }
}
