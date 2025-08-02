package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class d implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator f7137a;

    d(Iterator it) {
        this.f7137a = it;
    }

    public final boolean hasNext() {
        return this.f7137a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return new zzat((String) this.f7137a.next());
    }
}
