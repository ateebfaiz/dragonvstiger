package com.google.android.gms.internal.fido;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

class n0 extends m0 {

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f7078a;

    n0(byte[] bArr) {
        bArr.getClass();
        this.f7078a = bArr;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcz) || zzd() != ((zzcz) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return obj.equals(this);
        }
        n0 n0Var = (n0) obj;
        int zzk = zzk();
        int zzk2 = n0Var.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > n0Var.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= n0Var.zzd()) {
            byte[] bArr = this.f7078a;
            byte[] bArr2 = n0Var.f7078a;
            int a10 = a() + zzd;
            int a11 = a();
            int a12 = n0Var.a();
            while (a11 < a10) {
                if (bArr[a11] != bArr2[a12]) {
                    return false;
                }
                a11++;
                a12++;
            }
            return true;
        } else {
            int zzd3 = n0Var.zzd();
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
        }
    }

    public byte zza(int i10) {
        return this.f7078a[i10];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i10) {
        return this.f7078a[i10];
    }

    public int zzd() {
        return this.f7078a.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f7078a, 0, bArr, 0, i12);
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i10, int i11, int i12) {
        byte[] bArr = this.f7078a;
        int a10 = a();
        byte[] bArr2 = zzde.zzd;
        for (int i13 = a10; i13 < a10 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public final zzcz zzg(int i10, int i11) {
        int zzj = zzcz.zzj(i10, i11, zzd());
        if (zzj == 0) {
            return zzcz.zzb;
        }
        return new l0(this.f7078a, a() + i10, zzj);
    }

    public final InputStream zzh() {
        return new ByteArrayInputStream(this.f7078a, a(), zzd());
    }

    public final ByteBuffer zzi() {
        return ByteBuffer.wrap(this.f7078a, a(), zzd()).asReadOnlyBuffer();
    }
}
