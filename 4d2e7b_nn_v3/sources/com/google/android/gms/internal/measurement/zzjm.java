package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjm extends zziu {
    private static final Logger zzb = Logger.getLogger(zzjm.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = r4.C();
    t2 zza;

    private zzjm() {
    }

    public static int zzA(int i10) {
        if ((i10 & -128) == 0) {
            return 1;
        }
        if ((i10 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i10) == 0) {
            return 3;
        }
        return (i10 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j10) {
        int i10;
        if ((-128 & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if ((-34359738368L & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if ((-2097152 & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & -16384) != 0 ? i10 + 1 : i10;
    }

    public static zzjm zzC(byte[] bArr) {
        return new s2(bArr, 0, bArr.length);
    }

    public static int zzt(zzje zzje) {
        int zzd = zzje.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    static int zzu(int i10, zzlm zzlm, w3 w3Var) {
        int zzA = zzA(i10 << 3);
        return zzA + zzA + ((zzio) zzlm).zzbr(w3Var);
    }

    public static int zzv(int i10) {
        if (i10 >= 0) {
            return zzA(i10);
        }
        return 10;
    }

    public static int zzw(zzks zzks) {
        int zza2 = zzks.zza();
        return zzA(zza2) + zza2;
    }

    static int zzx(zzlm zzlm, w3 w3Var) {
        int zzbr = ((zzio) zzlm).zzbr(w3Var);
        return zzA(zzbr) + zzbr;
    }

    public static int zzy(String str) {
        int i10;
        try {
            i10 = w4.c(str);
        } catch (v4 unused) {
            i10 = str.getBytes(zzkn.zzb).length;
        }
        return zzA(i10) + i10;
    }

    public static int zzz(int i10) {
        return zzA(i10 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, v4 v4Var) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", v4Var);
        byte[] bytes = str.getBytes(zzkn.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(e10);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10) throws IOException;

    public abstract void zzd(int i10, boolean z10) throws IOException;

    public abstract void zze(int i10, zzje zzje) throws IOException;

    public abstract void zzf(int i10, int i11) throws IOException;

    public abstract void zzg(int i10) throws IOException;

    public abstract void zzh(int i10, long j10) throws IOException;

    public abstract void zzi(long j10) throws IOException;

    public abstract void zzj(int i10, int i11) throws IOException;

    public abstract void zzk(int i10) throws IOException;

    public abstract void zzl(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void zzm(int i10, String str) throws IOException;

    public abstract void zzo(int i10, int i11) throws IOException;

    public abstract void zzp(int i10, int i11) throws IOException;

    public abstract void zzq(int i10) throws IOException;

    public abstract void zzr(int i10, long j10) throws IOException;

    public abstract void zzs(long j10) throws IOException;

    /* synthetic */ zzjm(zzjl zzjl) {
    }
}
