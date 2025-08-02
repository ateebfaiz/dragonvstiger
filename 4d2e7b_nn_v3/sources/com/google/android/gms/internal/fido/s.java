package com.google.android.gms.internal.fido;

import java.util.Iterator;

final class s extends zzbc {

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f7089f;

    /* renamed from: g  reason: collision with root package name */
    static final s f7090g;

    /* renamed from: a  reason: collision with root package name */
    final transient Object[] f7091a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f7092b;

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f7093c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f7094d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f7095e;

    static {
        Object[] objArr = new Object[0];
        f7089f = objArr;
        f7090g = new s(objArr, 0, objArr, 0, 0);
    }

    s(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f7091a = objArr;
        this.f7092b = i10;
        this.f7093c = objArr2;
        this.f7094d = i11;
        this.f7095e = i12;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.f7093c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int a10 = g.a(obj.hashCode());
        while (true) {
            int i10 = a10 & this.f7094d;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a10 = i10 + 1;
        }
    }

    public final int hashCode() {
        return this.f7092b;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzi().listIterator(0);
    }

    public final int size() {
        return this.f7095e;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.f7091a, 0, objArr, 0, this.f7095e);
        return this.f7095e;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7095e;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    public final zzcb zzd() {
        return zzi().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.f7091a;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzaz zzj() {
        return zzaz.zzh(this.f7091a, this.f7095e);
    }
}
