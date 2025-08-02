package com.facebook.react.runtime;

import com.facebook.react.bridge.MemoryPressureListener;
import java.lang.ref.WeakReference;

public final /* synthetic */ class n0 implements MemoryPressureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f3486a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f3487b;

    public /* synthetic */ n0(ReactHostImpl reactHostImpl, WeakReference weakReference) {
        this.f3486a = reactHostImpl;
        this.f3487b = weakReference;
    }

    public final void handleMemoryPressure(int i10) {
        this.f3486a.L0(this.f3487b, i10);
    }
}
