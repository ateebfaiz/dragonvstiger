package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class d extends zzag {

    /* renamed from: c  reason: collision with root package name */
    static final zzag f7031c = new d(new Object[0], 0);

    /* renamed from: a  reason: collision with root package name */
    final transient Object[] f7032a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f7033b;

    d(Object[] objArr, int i10) {
        this.f7032a = objArr;
        this.f7033b = i10;
    }

    public final Object get(int i10) {
        zzs.zza(i10, this.f7033b, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f7032a[i10];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.f7033b;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.f7032a, 0, objArr, 0, this.f7033b);
        return this.f7033b;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7033b;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.f7032a;
    }
}
