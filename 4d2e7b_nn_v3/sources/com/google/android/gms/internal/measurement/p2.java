package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

class p2 extends o2 {

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f7265a;

    p2(byte[] bArr) {
        bArr.getClass();
        this.f7265a = bArr;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzje) || zzd() != ((zzje) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof p2)) {
            return obj.equals(this);
        }
        p2 p2Var = (p2) obj;
        int zzk = zzk();
        int zzk2 = p2Var.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > p2Var.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= p2Var.zzd()) {
            byte[] bArr = this.f7265a;
            byte[] bArr2 = p2Var.f7265a;
            p2Var.a();
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
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + p2Var.zzd());
        }
    }

    public byte zza(int i10) {
        return this.f7265a[i10];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i10) {
        return this.f7265a[i10];
    }

    public int zzd() {
        return this.f7265a.length;
    }

    /* access modifiers changed from: protected */
    public final int zze(int i10, int i11, int i12) {
        return zzkn.zzd(i10, this.f7265a, 0, i12);
    }

    public final zzje zzf(int i10, int i11) {
        int zzj = zzje.zzj(0, i11, zzd());
        if (zzj == 0) {
            return zzje.zzb;
        }
        return new n2(this.f7265a, 0, zzj);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.f7265a, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zziu zziu) {
        ((s2) zziu).a(this.f7265a, 0, zzd());
    }

    public final boolean zzi() {
        return w4.f(this.f7265a, 0, zzd());
    }
}
