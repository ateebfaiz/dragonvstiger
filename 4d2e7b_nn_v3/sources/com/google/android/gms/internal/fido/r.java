package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;

final class r extends zzaz {

    /* renamed from: c  reason: collision with root package name */
    static final zzaz f7086c = new r(new Object[0], 0);

    /* renamed from: a  reason: collision with root package name */
    final transient Object[] f7087a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f7088b;

    r(Object[] objArr, int i10) {
        this.f7087a = objArr;
        this.f7088b = i10;
    }

    public final Object get(int i10) {
        zzap.zza(i10, this.f7088b, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f7087a[i10];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.f7088b;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.f7087a, 0, objArr, 0, this.f7088b);
        return this.f7088b;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7088b;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.f7087a;
    }
}
