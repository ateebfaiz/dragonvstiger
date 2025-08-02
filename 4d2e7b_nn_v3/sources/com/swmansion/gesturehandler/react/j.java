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

public final class j extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11420d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Pools.SynchronizedPool f11421e = new Pools.SynchronizedPool(7);

    /* renamed from: a  reason: collision with root package name */
    private b f11422a;

    /* renamed from: b  reason: collision with root package name */
    private int f11423b;

    /* renamed from: c  reason: collision with root package name */
    private int f11424c;

    public static final class a {
        private a() {
        }

        public final WritableMap a(b bVar, int i10, int i11) {
            m.f(bVar, "dataBuilder");
            WritableMap createMap = Arguments.createMap();
            m.c(createMap);
            bVar.a(createMap);
            createMap.putInt("state", i10);
            createMap.putInt("oldState", i11);
            m.e(createMap, "apply(...)");
            return createMap;
        }

        public final j b(ab.d dVar, int i10, int i11, b bVar) {
            m.f(dVar, "handler");
            m.f(bVar, "dataBuilder");
            j jVar = (j) j.f11421e.acquire();
            if (jVar == null) {
                jVar = new j((DefaultConstructorMarker) null);
            }
            jVar.c(dVar, i10, i11, bVar);
            return jVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void c(ab.d dVar, int i10, int i11, b bVar) {
        View U = dVar.U();
        m.c(U);
        super.init(k1.f(U), U.getId());
        this.f11422a = bVar;
        this.f11423b = i10;
        this.f11424c = i11;
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        a aVar = f11420d;
        b bVar = this.f11422a;
        m.c(bVar);
        return aVar.a(bVar, this.f11423b, this.f11424c);
    }

    public String getEventName() {
        return "onGestureHandlerStateChange";
    }

    public void onDispose() {
        this.f11422a = null;
        this.f11423b = 0;
        this.f11424c = 0;
        f11421e.release(this);
    }

    private j() {
    }
}
