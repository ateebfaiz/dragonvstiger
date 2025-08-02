package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import bb.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.k1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11398d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Pools.SynchronizedPool f11399e = new Pools.SynchronizedPool(7);

    /* renamed from: a  reason: collision with root package name */
    private b f11400a;

    /* renamed from: b  reason: collision with root package name */
    private short f11401b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11402c;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ c c(a aVar, ab.d dVar, b bVar, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return aVar.b(dVar, bVar, z10);
        }

        public final WritableMap a(b bVar) {
            m.f(bVar, "dataBuilder");
            WritableMap createMap = Arguments.createMap();
            m.c(createMap);
            bVar.a(createMap);
            m.e(createMap, "apply(...)");
            return createMap;
        }

        public final c b(ab.d dVar, b bVar, boolean z10) {
            m.f(dVar, "handler");
            m.f(bVar, "dataBuilder");
            c cVar = (c) c.f11399e.acquire();
            if (cVar == null) {
                cVar = new c((DefaultConstructorMarker) null);
            }
            cVar.c(dVar, bVar, z10);
            return cVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void c(ab.d dVar, b bVar, boolean z10) {
        View U = dVar.U();
        m.c(U);
        super.init(k1.f(U), U.getId());
        this.f11400a = bVar;
        this.f11402c = z10;
        this.f11401b = dVar.G();
    }

    public boolean canCoalesce() {
        return true;
    }

    public short getCoalescingKey() {
        return this.f11401b;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        a aVar = f11398d;
        b bVar = this.f11400a;
        m.c(bVar);
        return aVar.a(bVar);
    }

    public String getEventName() {
        if (this.f11402c) {
            return "topGestureHandlerEvent";
        }
        return "onGestureHandlerEvent";
    }

    public void onDispose() {
        this.f11400a = null;
        f11399e.release(this);
    }

    private c() {
    }
}
