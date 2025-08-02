package com.facebook.react.views.scroll;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.g0;
import com.facebook.react.views.scroll.f;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class e extends d {

    /* renamed from: k  reason: collision with root package name */
    public static final a f4154k = new a((DefaultConstructorMarker) null);

    /* renamed from: l  reason: collision with root package name */
    private static final String f4155l = e.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Pools.SynchronizedPool f4156m = new Pools.SynchronizedPool(3);

    /* renamed from: a  reason: collision with root package name */
    private float f4157a;

    /* renamed from: b  reason: collision with root package name */
    private float f4158b;

    /* renamed from: c  reason: collision with root package name */
    private float f4159c;

    /* renamed from: d  reason: collision with root package name */
    private float f4160d;

    /* renamed from: e  reason: collision with root package name */
    private int f4161e;

    /* renamed from: f  reason: collision with root package name */
    private int f4162f;

    /* renamed from: g  reason: collision with root package name */
    private int f4163g;

    /* renamed from: h  reason: collision with root package name */
    private int f4164h;

    /* renamed from: i  reason: collision with root package name */
    private f f4165i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4166j;

    public static final class a {
        private a() {
        }

        public final e a(int i10, int i11, f fVar, float f10, float f11, float f12, float f13, int i12, int i13, int i14, int i15, boolean z10) {
            e eVar = (e) e.f4156m.acquire();
            if (eVar == null) {
                eVar = new e((DefaultConstructorMarker) null);
            }
            eVar.c(i10, i11, fVar, f10, f11, f12, f13, i12, i13, i14, i15, z10);
            return eVar;
        }

        public final e b(int i10, f fVar, float f10, float f11, float f12, float f13, int i11, int i12, int i13, int i14) {
            return a(-1, i10, fVar, f10, f11, f12, f13, i11, i12, i13, i14, false);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void c(int i10, int i11, f fVar, float f10, float f11, float f12, float f13, int i12, int i13, int i14, int i15, boolean z10) {
        super.init(i10, i11);
        this.f4165i = fVar;
        this.f4157a = f10;
        this.f4158b = f11;
        this.f4159c = f12;
        this.f4160d = f13;
        this.f4161e = i12;
        this.f4162f = i13;
        this.f4163g = i14;
        this.f4164h = i15;
        this.f4166j = z10;
    }

    public static final e d(int i10, int i11, f fVar, float f10, float f11, float f12, float f13, int i12, int i13, int i14, int i15, boolean z10) {
        return f4154k.a(i10, i11, fVar, f10, f11, f12, f13, i12, i13, i14, i15, z10);
    }

    public static final e e(int i10, f fVar, float f10, float f11, float f12, float f13, int i11, int i12, int i13, int i14) {
        return f4154k.b(i10, fVar, f10, f11, f12, f13, i11, i12, i13, i14);
    }

    public boolean canCoalesce() {
        if (this.f4165i == f.SCROLL) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean experimental_isSynchronous() {
        return this.f4166j;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", 0.0d);
        createMap.putDouble("bottom", 0.0d);
        createMap.putDouble("left", 0.0d);
        createMap.putDouble("right", 0.0d);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("x", (double) g0.b(this.f4157a));
        createMap2.putDouble("y", (double) g0.b(this.f4158b));
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble(Snapshot.WIDTH, (double) g0.b((float) this.f4161e));
        createMap3.putDouble(Snapshot.HEIGHT, (double) g0.b((float) this.f4162f));
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putDouble(Snapshot.WIDTH, (double) g0.b((float) this.f4163g));
        createMap4.putDouble(Snapshot.HEIGHT, (double) g0.b((float) this.f4164h));
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putDouble("x", (double) this.f4159c);
        createMap5.putDouble("y", (double) this.f4160d);
        WritableMap createMap6 = Arguments.createMap();
        createMap6.putMap("contentInset", createMap);
        createMap6.putMap("contentOffset", createMap2);
        createMap6.putMap("contentSize", createMap3);
        createMap6.putMap("layoutMeasurement", createMap4);
        createMap6.putMap("velocity", createMap5);
        createMap6.putInt("target", getViewTag());
        createMap6.putBoolean("responderIgnoreScroll", true);
        m.c(createMap6);
        return createMap6;
    }

    public String getEventName() {
        f.a aVar = f.f4167a;
        Object c10 = p5.a.c(this.f4165i);
        m.e(c10, "assertNotNull(...)");
        return aVar.a((f) c10);
    }

    public void onDispose() {
        try {
            f4156m.release(this);
        } catch (IllegalStateException e10) {
            ReactSoftExceptionLogger.logSoftException(f4155l, e10);
        }
    }

    private e() {
    }
}
