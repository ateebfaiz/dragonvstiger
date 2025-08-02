package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class j extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17587b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f17588a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(int i10, int i11, Throwable th) {
        super(i10, i11);
        m.f(th, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        this.f17588a = th;
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.f17588a.getMessage());
        return createMap;
    }

    public String getEventName() {
        return "topAnimationFailure";
    }
}
