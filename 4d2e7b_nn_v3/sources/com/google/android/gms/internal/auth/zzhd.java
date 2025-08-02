package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhd extends AbstractList implements RandomAccess, zzfe {
    /* access modifiers changed from: private */
    public final zzfe zza;

    public zzhd(zzfe zzfe) {
        this.zza = zzfe;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzfd) this.zza).get(i10);
    }

    public final Iterator iterator() {
        return new k2(this);
    }

    public final ListIterator listIterator(int i10) {
        return new j2(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfe zze() {
        return this;
    }

    public final List zzg() {
        return this.zza.zzg();
    }
}
