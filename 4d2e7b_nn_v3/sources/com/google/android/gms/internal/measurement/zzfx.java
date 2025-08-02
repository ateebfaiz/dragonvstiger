package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfx extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzfx zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;
    /* access modifiers changed from: private */
    public zzkm zzj = zzkf.zzbE();

    static {
        zzfx zzfx = new zzfx();
        zza = zzfx;
        zzkf.zzbL(zzfx.class, zzfx);
    }

    private zzfx() {
    }

    public static zzfw zze() {
        return (zzfw) zza.zzbx();
    }

    static /* synthetic */ void zzj(zzfx zzfx, String str) {
        str.getClass();
        zzfx.zzd |= 1;
        zzfx.zze = str;
    }

    static /* synthetic */ void zzk(zzfx zzfx, String str) {
        str.getClass();
        zzfx.zzd |= 2;
        zzfx.zzf = str;
    }

    static /* synthetic */ void zzm(zzfx zzfx) {
        zzfx.zzd &= -3;
        zzfx.zzf = zza.zzf;
    }

    static /* synthetic */ void zzn(zzfx zzfx, long j10) {
        zzfx.zzd |= 4;
        zzfx.zzg = j10;
    }

    static /* synthetic */ void zzo(zzfx zzfx) {
        zzfx.zzd &= -5;
        zzfx.zzg = 0;
    }

    static /* synthetic */ void zzp(zzfx zzfx, double d10) {
        zzfx.zzd |= 16;
        zzfx.zzi = d10;
    }

    static /* synthetic */ void zzq(zzfx zzfx) {
        zzfx.zzd &= -17;
        zzfx.zzi = 0.0d;
    }

    static /* synthetic */ void zzr(zzfx zzfx, zzfx zzfx2) {
        zzfx2.getClass();
        zzfx.zzz();
        zzfx.zzj.add(zzfx2);
    }

    static /* synthetic */ void zzs(zzfx zzfx, Iterable iterable) {
        zzfx.zzz();
        zzio.zzbt(iterable, zzfx.zzj);
    }

    private final void zzz() {
        zzkm zzkm = this.zzj;
        if (!zzkm.zzc()) {
            this.zzj = zzkf.zzbF(zzkm);
        }
    }

    public final double zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfx.class});
        } else if (i11 == 3) {
            return new zzfx();
        } else {
            if (i11 == 4) {
                return new zzfw((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzu() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzv() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzw() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzx() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzy() {
        return (this.zzd & 2) != 0;
    }
}
