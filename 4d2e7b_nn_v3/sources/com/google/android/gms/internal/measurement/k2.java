package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class k2 extends m2 {

    /* renamed from: a  reason: collision with root package name */
    private int f7210a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f7211b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzje f7212c;

    k2(zzje zzje) {
        this.f7212c = zzje;
        this.f7211b = zzje.zzd();
    }

    public final boolean hasNext() {
        return this.f7210a < this.f7211b;
    }

    public final byte zza() {
        int i10 = this.f7210a;
        if (i10 < this.f7211b) {
            this.f7210a = i10 + 1;
            return this.f7212c.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
