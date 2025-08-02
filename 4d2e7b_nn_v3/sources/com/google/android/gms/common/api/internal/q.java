package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f6729a;

    /* synthetic */ q(zaaw zaaw, zaau zaau) {
        this.f6729a = zaaw;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        Lock zap;
        this.f6729a.zab.lock();
        try {
            if (Thread.interrupted()) {
                zap = this.f6729a.zab;
            } else {
                a();
                zap = this.f6729a.zab;
            }
        } catch (RuntimeException e10) {
            this.f6729a.zaa.zam(e10);
            zap = this.f6729a.zab;
        } catch (Throwable th) {
            this.f6729a.zab.unlock();
            throw th;
        }
        zap.unlock();
    }
}
