package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class j extends zzaz {

    /* renamed from: a  reason: collision with root package name */
    final transient int f7071a;

    /* renamed from: b  reason: collision with root package name */
    final transient int f7072b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzaz f7073c;

    j(zzaz zzaz, int i10, int i11) {
        this.f7073c = zzaz;
        this.f7071a = i10;
        this.f7072b = i11;
    }

    public final Object get(int i10) {
        zzap.zza(i10, this.f7072b, FirebaseAnalytics.Param.INDEX);
        return this.f7073c.get(i10 + this.f7071a);
    }

    public final int size() {
        return this.f7072b;
    }

    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.f7073c.zzc() + this.f7071a + this.f7072b;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.f7073c.zzc() + this.f7071a;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.f7073c.zze();
    }

    public final zzaz zzg(int i10, int i11) {
        zzap.zze(i10, i11, this.f7072b);
        zzaz zzaz = this.f7073c;
        int i12 = this.f7071a;
        return zzaz.subList(i10 + i12, i11 + i12);
    }
}
