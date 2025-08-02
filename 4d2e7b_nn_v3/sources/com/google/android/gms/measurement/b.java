package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhy;
import java.util.List;
import java.util.Map;

final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final zzhy f7376a;

    public b(zzhy zzhy) {
        super((zzc) null);
        Preconditions.checkNotNull(zzhy);
        this.f7376a = zzhy;
    }

    public final Boolean a() {
        return (Boolean) this.f7376a.zzg(4);
    }

    public final Double b() {
        return (Double) this.f7376a.zzg(2);
    }

    public final Integer c() {
        return (Integer) this.f7376a.zzg(3);
    }

    public final Long d() {
        return (Long) this.f7376a.zzg(1);
    }

    public final String e() {
        return (String) this.f7376a.zzg(0);
    }

    public final Map f(boolean z10) {
        return this.f7376a.zzo((String) null, (String) null, z10);
    }

    public final int zza(String str) {
        return this.f7376a.zza(str);
    }

    public final long zzb() {
        return this.f7376a.zzb();
    }

    public final Object zzg(int i10) {
        return this.f7376a.zzg(i10);
    }

    public final String zzh() {
        return this.f7376a.zzh();
    }

    public final String zzi() {
        return this.f7376a.zzi();
    }

    public final String zzj() {
        return this.f7376a.zzj();
    }

    public final String zzk() {
        return this.f7376a.zzk();
    }

    public final List zzm(String str, String str2) {
        return this.f7376a.zzm(str, str2);
    }

    public final Map zzo(String str, String str2, boolean z10) {
        return this.f7376a.zzo(str, str2, z10);
    }

    public final void zzp(String str) {
        this.f7376a.zzp(str);
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.f7376a.zzq(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.f7376a.zzr(str);
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.f7376a.zzs(str, str2, bundle);
    }

    public final void zzt(String str, String str2, Bundle bundle, long j10) {
        this.f7376a.zzt(str, str2, bundle, j10);
    }

    public final void zzu(zzgs zzgs) {
        this.f7376a.zzu(zzgs);
    }

    public final void zzv(Bundle bundle) {
        this.f7376a.zzv(bundle);
    }

    public final void zzw(zzgr zzgr) {
        this.f7376a.zzw(zzgr);
    }

    public final void zzx(zzgs zzgs) {
        this.f7376a.zzx(zzgs);
    }
}
