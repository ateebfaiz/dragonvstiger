package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final a f4378a = new a((DefaultConstructorMarker) null);

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(int i10, int i11) {
        super(i10, i11);
    }

    public boolean canCoalesce() {
        return false;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        m.e(createMap, "createMap(...)");
        return createMap;
    }

    public String getEventName() {
        return "topClick";
    }
}
