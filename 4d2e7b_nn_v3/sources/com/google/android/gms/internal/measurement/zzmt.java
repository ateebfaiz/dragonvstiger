package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzmt extends AbstractList implements RandomAccess, zzku {
    /* access modifiers changed from: private */
    public final zzku zza;

    public zzmt(zzku zzku) {
        this.zza = zzku;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzkt) this.zza).get(i10);
    }

    public final Iterator iterator() {
        return new m4(this);
    }

    public final ListIterator listIterator(int i10) {
        return new l4(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzku zze() {
        return this;
    }

    public final Object zzf(int i10) {
        return this.zza.zzf(i10);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzje zzje) {
        throw new UnsupportedOperationException();
    }
}
