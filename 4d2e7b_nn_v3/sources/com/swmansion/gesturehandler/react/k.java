package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.k1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class k extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11425c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Pools.SynchronizedPool f11426d = new Pools.SynchronizedPool(7);

    /* renamed from: a  reason: collision with root package name */
    private WritableMap f11427a;

    /* renamed from: b  reason: collision with root package name */
    private short f11428b;

    public static final class a {
        private a() {
        }

        public final WritableMap a(ab.d dVar) {
            m.f(dVar, "handler");
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("handlerTag", dVar.R());
            createMap.putInt("state", dVar.Q());
            createMap.putInt("numberOfTouches", dVar.T());
            createMap.putInt("eventType", dVar.S());
            createMap.putInt("pointerType", dVar.O());
            WritableArray r10 = dVar.r();
            if (r10 != null) {
                createMap.putArray("changedTouches", r10);
            }
            WritableArray q10 = dVar.q();
            if (q10 != null) {
                createMap.putArray("allTouches", q10);
            }
            if (dVar.Y() && dVar.Q() == 4) {
                createMap.putInt("state", 2);
            }
            m.e(createMap, "apply(...)");
            return createMap;
        }

        public final k b(ab.d dVar) {
            m.f(dVar, "handler");
            k kVar = (k) k.f11426d.acquire();
            if (kVar == null) {
                kVar = new k((DefaultConstructorMarker) null);
            }
            kVar.c(dVar);
            return kVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void c(ab.d dVar) {
        View U = dVar.U();
        m.c(U);
        super.init(k1.f(U), U.getId());
        this.f11427a = f11425c.a(dVar);
        this.f11428b = dVar.G();
    }

    public boolean canCoalesce() {
        return true;
    }

    public short getCoalescingKey() {
        return this.f11428b;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return this.f11427a;
    }

    public String getEventName() {
        return "onGestureHandlerEvent";
    }

    public void onDispose() {
        this.f11427a = null;
        f11426d.release(this);
    }

    private k() {
    }
}
