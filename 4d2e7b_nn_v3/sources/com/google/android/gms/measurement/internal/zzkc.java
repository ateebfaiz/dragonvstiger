package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzby;

public final class zzkc extends z {
    protected final q3 zza = new q3(this);
    protected final p3 zzb = new p3(this);
    protected final m3 zzc = new m3(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzkc(zzfr zzfr) {
        super(zzfr);
    }

    static /* bridge */ /* synthetic */ void zzj(zzkc zzkc, long j10) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j10));
        zzkc.zzc.a(j10);
        if (zzkc.zzt.zzf().zzu()) {
            zzkc.zzb.b(j10);
        }
    }

    static /* bridge */ /* synthetic */ void zzl(zzkc zzkc, long j10) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j10));
        if (zzkc.zzt.zzf().zzu() || zzkc.zzt.zzm().f7783p.zzb()) {
            zzkc.zzb.c(j10);
        }
        zzkc.zzc.b();
        q3 q3Var = zzkc.zza;
        q3Var.f7688a.zzg();
        if (q3Var.f7688a.zzt.zzJ()) {
            q3Var.b(q3Var.f7688a.zzt.zzav().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }
}
