package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgi extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgi zza;
    /* access modifiers changed from: private */
    public zzkl zzd = zzkf.zzbC();
    /* access modifiers changed from: private */
    public zzkl zze = zzkf.zzbC();
    /* access modifiers changed from: private */
    public zzkm zzf = zzkf.zzbE();
    /* access modifiers changed from: private */
    public zzkm zzg = zzkf.zzbE();

    static {
        zzgi zzgi = new zzgi();
        zza = zzgi;
        zzkf.zzbL(zzgi.class, zzgi);
    }

    private zzgi() {
    }

    public static zzgh zzf() {
        return (zzgh) zza.zzbx();
    }

    public static zzgi zzh() {
        return zza;
    }

    static /* synthetic */ void zzo(zzgi zzgi, Iterable iterable) {
        zzkl zzkl = zzgi.zzd;
        if (!zzkl.zzc()) {
            zzgi.zzd = zzkf.zzbD(zzkl);
        }
        zzio.zzbt(iterable, zzgi.zzd);
    }

    static /* synthetic */ void zzq(zzgi zzgi, Iterable iterable) {
        zzkl zzkl = zzgi.zze;
        if (!zzkl.zzc()) {
            zzgi.zze = zzkf.zzbD(zzkl);
        }
        zzio.zzbt(iterable, zzgi.zze);
    }

    static /* synthetic */ void zzs(zzgi zzgi, Iterable iterable) {
        zzgi.zzy();
        zzio.zzbt(iterable, zzgi.zzf);
    }

    static /* synthetic */ void zzu(zzgi zzgi, int i10) {
        zzgi.zzy();
        zzgi.zzf.remove(i10);
    }

    static /* synthetic */ void zzv(zzgi zzgi, Iterable iterable) {
        zzgi.zzz();
        zzio.zzbt(iterable, zzgi.zzg);
    }

    static /* synthetic */ void zzx(zzgi zzgi, int i10) {
        zzgi.zzz();
        zzgi.zzg.remove(i10);
    }

    private final void zzy() {
        zzkm zzkm = this.zzf;
        if (!zzkm.zzc()) {
            this.zzf = zzkf.zzbF(zzkm);
        }
    }

    private final void zzz() {
        zzkm zzkm = this.zzg;
        if (!zzkm.zzc()) {
            this.zzg = zzkf.zzbF(zzkm);
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final zzfr zze(int i10) {
        return (zzfr) this.zzf.get(i10);
    }

    public final zzgk zzi(int i10) {
        return (zzgk) this.zzg.get(i10);
    }

    public final List zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", zzfr.class, "zzg", zzgk.class});
        } else if (i11 == 3) {
            return new zzgi();
        } else {
            if (i11 == 4) {
                return new zzgh((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return this.zzd;
    }
}
