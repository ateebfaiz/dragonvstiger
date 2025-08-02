package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

class u0 extends t0 {

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f7002a;

    u0(byte[] bArr) {
        bArr.getClass();
        this.f7002a = bArr;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || zzd() != ((zzee) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return obj.equals(this);
        }
        u0 u0Var = (u0) obj;
        int zzj = zzj();
        int zzj2 = u0Var.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > u0Var.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= u0Var.zzd()) {
            byte[] bArr = this.f7002a;
            byte[] bArr2 = u0Var.f7002a;
            u0Var.a();
            int i10 = 0;
            int i11 = 0;
            while (i10 < zzd) {
                if (bArr[i10] != bArr2[i11]) {
                    return false;
                }
                i10++;
                i11++;
            }
            return true;
        } else {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + u0Var.zzd());
        }
    }

    public byte zza(int i10) {
        return this.f7002a[i10];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i10) {
        return this.f7002a[i10];
    }

    public int zzd() {
        return this.f7002a.length;
    }

    /* access modifiers changed from: protected */
    public final int zze(int i10, int i11, int i12) {
        return zzez.zzd(i10, this.f7002a, 0, i12);
    }

    public final zzee zzf(int i10, int i11) {
        int zzi = zzee.zzi(0, i11, zzd());
        if (zzi == 0) {
            return zzee.zzb;
        }
        return new s0(this.f7002a, 0, zzi);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.f7002a, 0, zzd(), charset);
    }

    public final boolean zzh() {
        return t2.d(this.f7002a, 0, zzd());
    }
}
