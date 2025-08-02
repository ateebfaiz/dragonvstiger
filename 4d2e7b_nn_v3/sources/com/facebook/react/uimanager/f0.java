package com.facebook.react.uimanager;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class f0 extends d {

    /* renamed from: e  reason: collision with root package name */
    private static final Pools.SynchronizedPool f3668e = new Pools.SynchronizedPool(20);

    /* renamed from: a  reason: collision with root package name */
    private int f3669a;

    /* renamed from: b  reason: collision with root package name */
    private int f3670b;

    /* renamed from: c  reason: collision with root package name */
    private int f3671c;

    /* renamed from: d  reason: collision with root package name */
    private int f3672d;

    private f0() {
    }

    public static f0 b(int i10, int i11, int i12, int i13, int i14) {
        return c(-1, i10, i11, i12, i13, i14);
    }

    public static f0 c(int i10, int i11, int i12, int i13, int i14, int i15) {
        f0 f0Var = (f0) f3668e.acquire();
        if (f0Var == null) {
            f0Var = new f0();
        }
        f0Var.a(i10, i11, i12, i13, i14, i15);
        return f0Var;
    }

    /* access modifiers changed from: protected */
    public void a(int i10, int i11, int i12, int i13, int i14, int i15) {
        super.init(i10, i11);
        this.f3669a = i12;
        this.f3670b = i13;
        this.f3671c = i14;
        this.f3672d = i15;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) g0.b((float) this.f3669a));
        createMap.putDouble("y", (double) g0.b((float) this.f3670b));
        createMap.putDouble(Snapshot.WIDTH, (double) g0.b((float) this.f3671c));
        createMap.putDouble(Snapshot.HEIGHT, (double) g0.b((float) this.f3672d));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("layout", createMap);
        createMap2.putInt("target", getViewTag());
        return createMap2;
    }

    public String getEventName() {
        return "topLayout";
    }

    public void onDispose() {
        f3668e.release(this);
    }
}
