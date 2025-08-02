package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class c extends zzag {

    /* renamed from: a  reason: collision with root package name */
    final transient int f7028a;

    /* renamed from: b  reason: collision with root package name */
    final transient int f7029b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzag f7030c;

    c(zzag zzag, int i10, int i11) {
        this.f7030c = zzag;
        this.f7028a = i10;
        this.f7029b = i11;
    }

    public final Object get(int i10) {
        zzs.zza(i10, this.f7029b, FirebaseAnalytics.Param.INDEX);
        return this.f7030c.get(i10 + this.f7028a);
    }

    public final int size() {
        return this.f7029b;
    }

    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7030c.zzc() + this.f7028a + this.f7029b;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.f7030c.zzc() + this.f7028a;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.f7030c.zzg();
    }

    public final zzag zzh(int i10, int i11) {
        zzs.zzc(i10, i11, this.f7029b);
        zzag zzag = this.f7030c;
        int i12 = this.f7028a;
        return zzag.subList(i10 + i12, i11 + i12);
    }
}
