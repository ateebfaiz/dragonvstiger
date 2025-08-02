package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class b implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f7120a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzae f7121b;

    b(zzae zzae) {
        this.f7121b = zzae;
    }

    public final boolean hasNext() {
        if (this.f7120a < this.f7121b.zzc()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f7120a < this.f7121b.zzc()) {
            zzae zzae = this.f7121b;
            int i10 = this.f7120a;
            this.f7120a = i10 + 1;
            return zzae.zze(i10);
        }
        int i11 = this.f7120a;
        throw new NoSuchElementException("Out of bounds index: " + i11);
    }
}
