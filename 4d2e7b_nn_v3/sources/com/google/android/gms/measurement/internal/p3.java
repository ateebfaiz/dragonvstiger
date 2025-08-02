package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzof;

final class p3 {

    /* renamed from: a  reason: collision with root package name */
    protected long f7670a;

    /* renamed from: b  reason: collision with root package name */
    protected long f7671b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7672c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzkc f7673d;

    public p3(zzkc zzkc) {
        this.f7673d = zzkc;
        this.f7672c = new n3(this, zzkc.zzt);
        long elapsedRealtime = zzkc.zzt.zzav().elapsedRealtime();
        this.f7670a = elapsedRealtime;
        this.f7671b = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f7672c.b();
        this.f7670a = 0;
        this.f7671b = 0;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j10) {
        this.f7672c.b();
    }

    /* access modifiers changed from: package-private */
    public final void c(long j10) {
        this.f7673d.zzg();
        this.f7672c.b();
        this.f7670a = j10;
        this.f7671b = j10;
    }

    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f7673d.zzg();
        this.f7673d.zza();
        zzof.zzc();
        if (!this.f7673d.zzt.zzf().zzs((String) null, zzdu.zzad)) {
            this.f7673d.zzt.zzm().f7780m.zzb(this.f7673d.zzt.zzav().currentTimeMillis());
        } else if (this.f7673d.zzt.zzJ()) {
            this.f7673d.zzt.zzm().f7780m.zzb(this.f7673d.zzt.zzav().currentTimeMillis());
        }
        long j11 = j10 - this.f7670a;
        if (z10 || j11 >= 1000) {
            if (!z11) {
                j11 = j10 - this.f7671b;
                this.f7671b = j10;
            }
            this.f7673d.zzt.zzay().zzj().zzb("Recording user engagement, ms", Long.valueOf(j11));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j11);
            zzlb.zzK(this.f7673d.zzt.zzs().zzj(!this.f7673d.zzt.zzf().zzu()), bundle, true);
            if (!z11) {
                this.f7673d.zzt.zzq().zzG("auto", "_e", bundle);
            }
            this.f7670a = j10;
            this.f7672c.b();
            this.f7672c.d(3600000);
            return true;
        }
        this.f7673d.zzt.zzay().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
        return false;
    }
}
