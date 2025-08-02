package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzpd;

final class q3 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzkc f7688a;

    q3(zzkc zzkc) {
        this.f7688a = zzkc;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f7688a.zzg();
        if (this.f7688a.zzt.zzm().h(this.f7688a.zzt.zzav().currentTimeMillis())) {
            this.f7688a.zzt.zzm().f7777j.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f7688a.zzt.zzay().zzj().zza("Detected application was in foreground");
                c(this.f7688a.zzt.zzav().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j10, boolean z10) {
        this.f7688a.zzg();
        this.f7688a.zzm();
        if (this.f7688a.zzt.zzm().h(j10)) {
            this.f7688a.zzt.zzm().f7777j.zza(true);
            zzpd.zzc();
            if (this.f7688a.zzt.zzf().zzs((String) null, zzdu.zzam)) {
                this.f7688a.zzt.zzh().zzo();
            }
        }
        this.f7688a.zzt.zzm().f7780m.zzb(j10);
        if (this.f7688a.zzt.zzm().f7777j.zzb()) {
            c(j10, z10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(long j10, boolean z10) {
        this.f7688a.zzg();
        if (this.f7688a.zzt.zzJ()) {
            this.f7688a.zzt.zzm().f7780m.zzb(j10);
            this.f7688a.zzt.zzay().zzj().zzb("Session started, time", Long.valueOf(this.f7688a.zzt.zzav().elapsedRealtime()));
            long j11 = j10 / 1000;
            this.f7688a.zzt.zzq().zzY("auto", "_sid", Long.valueOf(j11), j10);
            this.f7688a.zzt.zzm().f7781n.zzb(j11);
            this.f7688a.zzt.zzm().f7777j.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            if (this.f7688a.zzt.zzf().zzs((String) null, zzdu.zzZ) && z10) {
                bundle.putLong("_aib", 1);
            }
            this.f7688a.zzt.zzq().zzH("auto", "_s", j10, bundle);
            zznw.zzc();
            if (this.f7688a.zzt.zzf().zzs((String) null, zzdu.zzac)) {
                String zza = this.f7688a.zzt.zzm().f7786s.zza();
                if (!TextUtils.isEmpty(zza)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza);
                    this.f7688a.zzt.zzq().zzH("auto", "_ssr", j10, bundle2);
                }
            }
        }
    }
}
