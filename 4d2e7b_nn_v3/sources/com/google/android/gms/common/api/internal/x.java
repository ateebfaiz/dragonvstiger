package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private final zabf f6753a;

    protected x(zabf zabf) {
        this.f6753a = zabf;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void b(zabi zabi) {
        Lock zah;
        zabi.zai.lock();
        try {
            if (zabi.zan != this.f6753a) {
                zah = zabi.zai;
            } else {
                a();
                zah = zabi.zai;
            }
            zah.unlock();
        } catch (Throwable th) {
            zabi.zai.unlock();
            throw th;
        }
    }
}
