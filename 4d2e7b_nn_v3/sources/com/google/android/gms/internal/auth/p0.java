package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

final class p0 extends r0 {

    /* renamed from: a  reason: collision with root package name */
    private int f6978a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f6979b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzee f6980c;

    p0(zzee zzee) {
        this.f6980c = zzee;
        this.f6979b = zzee.zzd();
    }

    public final boolean hasNext() {
        return this.f6978a < this.f6979b;
    }

    public final byte zza() {
        int i10 = this.f6978a;
        if (i10 < this.f6979b) {
            this.f6978a = i10 + 1;
            return this.f6980c.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
