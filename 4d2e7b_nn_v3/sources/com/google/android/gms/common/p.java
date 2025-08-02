package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class p extends q {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f6825f;

    /* synthetic */ p(Callable callable, zzu zzu) {
        super(false, 1, 5, (String) null, (Throwable) null, (zzw) null);
        this.f6825f = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f6825f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
