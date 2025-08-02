package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

final class i0 extends k0 {

    /* renamed from: a  reason: collision with root package name */
    private int f7068a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f7069b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzcz f7070c;

    i0(zzcz zzcz) {
        this.f7070c = zzcz;
        this.f7069b = zzcz.zzd();
    }

    public final boolean hasNext() {
        return this.f7068a < this.f7069b;
    }

    public final byte zza() {
        int i10 = this.f7068a;
        if (i10 < this.f7069b) {
            this.f7068a = i10 + 1;
            return this.f7070c.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
