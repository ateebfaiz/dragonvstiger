package com.google.android.gms.common.api.internal;

final class z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6757a;

    z0(b bVar) {
        this.f6757a = bVar;
    }

    public final void run() {
        this.f6757a.f6666o.lock();
        try {
            b.p(this.f6757a);
        } finally {
            this.f6757a.f6666o.unlock();
        }
    }
}
