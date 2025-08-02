package com.google.android.gms.internal.fido;

import java.util.Iterator;

final class w extends zzbc {

    /* renamed from: a  reason: collision with root package name */
    final transient Object f7101a;

    w(Object obj) {
        obj.getClass();
        this.f7101a = obj;
    }

    public final boolean contains(Object obj) {
        return this.f7101a.equals(obj);
    }

    public final int hashCode() {
        return this.f7101a.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new p(this.f7101a);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f7101a.toString();
        return "[" + obj + "]";
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        objArr[0] = this.f7101a;
        return 1;
    }

    public final zzcb zzd() {
        return new p(this.f7101a);
    }

    public final zzaz zzi() {
        return zzaz.zzj(this.f7101a);
    }
}
