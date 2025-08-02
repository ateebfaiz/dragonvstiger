package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class f implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f7161a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzat f7162b;

    f(zzat zzat) {
        this.f7162b = zzat;
    }

    public final boolean hasNext() {
        return this.f7161a < this.f7162b.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.f7161a;
        zzat zzat = this.f7162b;
        if (i10 < zzat.zza.length()) {
            String zzb = zzat.zza;
            this.f7161a = i10 + 1;
            return new zzat(String.valueOf(zzb.charAt(i10)));
        }
        throw new NoSuchElementException();
    }
}
