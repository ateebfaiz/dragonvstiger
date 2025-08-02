package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator f7110a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Iterator f7111b;

    a(zzae zzae, Iterator it, Iterator it2) {
        this.f7110a = it;
        this.f7111b = it2;
    }

    public final boolean hasNext() {
        if (this.f7110a.hasNext()) {
            return true;
        }
        return this.f7111b.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f7110a.hasNext()) {
            return new zzat(((Integer) this.f7110a.next()).toString());
        }
        if (this.f7111b.hasNext()) {
            return new zzat((String) this.f7111b.next());
        }
        throw new NoSuchElementException();
    }
}
