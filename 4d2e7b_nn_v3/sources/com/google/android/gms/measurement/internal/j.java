package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class j implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f7562a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzau f7563b;

    j(zzau zzau) {
        this.f7563b = zzau;
        this.f7562a = zzau.zza.keySet().iterator();
    }

    /* renamed from: a */
    public final String next() {
        return (String) this.f7562a.next();
    }

    public final boolean hasNext() {
        return this.f7562a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
