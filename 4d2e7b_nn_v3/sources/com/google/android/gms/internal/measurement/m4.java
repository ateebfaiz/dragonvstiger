package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class m4 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f7227a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzmt f7228b;

    m4(zzmt zzmt) {
        this.f7228b = zzmt;
        this.f7227a = zzmt.zza.iterator();
    }

    public final boolean hasNext() {
        return this.f7227a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f7227a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
