package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class l4 implements ListIterator {

    /* renamed from: a  reason: collision with root package name */
    final ListIterator f7219a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f7220b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzmt f7221c;

    l4(zzmt zzmt, int i10) {
        this.f7221c = zzmt;
        this.f7220b = i10;
        this.f7219a = zzmt.zza.listIterator(i10);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f7219a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f7219a.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f7219a.next();
    }

    public final int nextIndex() {
        return this.f7219a.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f7219a.previous();
    }

    public final int previousIndex() {
        return this.f7219a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
