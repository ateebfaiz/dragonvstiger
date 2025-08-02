package com.google.android.gms.internal.auth;

import java.util.ListIterator;

final class j2 implements ListIterator {

    /* renamed from: a  reason: collision with root package name */
    final ListIterator f6943a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f6944b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzhd f6945c;

    j2(zzhd zzhd, int i10) {
        this.f6945c = zzhd;
        this.f6944b = i10;
        this.f6943a = zzhd.zza.listIterator(i10);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f6943a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f6943a.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f6943a.next();
    }

    public final int nextIndex() {
        return this.f6943a.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f6943a.previous();
    }

    public final int previousIndex() {
        return this.f6943a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
