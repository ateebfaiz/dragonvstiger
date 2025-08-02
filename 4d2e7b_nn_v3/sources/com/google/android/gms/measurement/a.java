package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzkw;
import java.util.List;
import java.util.Map;

final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final zzfr f7374a;

    /* renamed from: b  reason: collision with root package name */
    private final zzhx f7375b;

    public a(zzfr zzfr) {
        super((zzc) null);
        Preconditions.checkNotNull(zzfr);
        this.f7374a = zzfr;
        this.f7375b = zzfr.zzq();
    }

    public final Boolean a() {
        return this.f7375b.zzi();
    }

    public final Double b() {
        return this.f7375b.zzj();
    }

    public final Integer c() {
        return this.f7375b.zzl();
    }

    public final Long d() {
        return this.f7375b.zzm();
    }

    public final String e() {
        return this.f7375b.zzr();
    }

    public final Map f(boolean z10) {
        List<zzkw> zzt = this.f7375b.zzt(z10);
        ArrayMap arrayMap = new ArrayMap(zzt.size());
        for (zzkw zzkw : zzt) {
            Object zza = zzkw.zza();
            if (zza != null) {
                arrayMap.put(zzkw.zzb, zza);
            }
        }
        return arrayMap;
    }

    public final int zza(String str) {
        this.f7375b.zzh(str);
        return 25;
    }

    public final long zzb() {
        return this.f7374a.zzv().zzq();
    }

    public final Object zzg(int i10) {
        if (i10 == 0) {
            return this.f7375b.zzr();
        }
        if (i10 == 1) {
            return this.f7375b.zzm();
        }
        if (i10 == 2) {
            return this.f7375b.zzj();
        }
        if (i10 != 3) {
            return this.f7375b.zzi();
        }
        return this.f7375b.zzl();
    }

    public final String zzh() {
        return this.f7375b.zzo();
    }

    public final String zzi() {
        return this.f7375b.zzp();
    }

    public final String zzj() {
        return this.f7375b.zzq();
    }

    public final String zzk() {
        return this.f7375b.zzo();
    }

    public final List zzm(String str, String str2) {
        return this.f7375b.zzs(str, str2);
    }

    public final Map zzo(String str, String str2, boolean z10) {
        return this.f7375b.zzu(str, str2, z10);
    }

    public final void zzp(String str) {
        this.f7374a.zzd().zzd(str, this.f7374a.zzav().elapsedRealtime());
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.f7374a.zzq().zzA(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.f7374a.zzd().zze(str, this.f7374a.zzav().elapsedRealtime());
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.f7375b.zzD(str, str2, bundle);
    }

    public final void zzt(String str, String str2, Bundle bundle, long j10) {
        this.f7375b.zzE(str, str2, bundle, true, false, j10);
    }

    public final void zzu(zzgs zzgs) {
        this.f7375b.zzJ(zzgs);
    }

    public final void zzv(Bundle bundle) {
        this.f7375b.zzP(bundle);
    }

    public final void zzw(zzgr zzgr) {
        this.f7375b.zzT(zzgr);
    }

    public final void zzx(zzgs zzgs) {
        this.f7375b.zzZ(zzgs);
    }
}
