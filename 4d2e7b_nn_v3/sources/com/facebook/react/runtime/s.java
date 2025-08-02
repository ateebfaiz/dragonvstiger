package com.facebook.react.runtime;

import java.lang.ref.WeakReference;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f3505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3506b;

    public /* synthetic */ s(WeakReference weakReference, int i10) {
        this.f3505a = weakReference;
        this.f3506b = i10;
    }

    public final void run() {
        ReactHostImpl.K0(this.f3505a, this.f3506b);
    }
}
