package com.google.android.gms.internal.auth;

import java.util.Arrays;

public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgz(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z10;
    }

    public static zzgz zza() {
        return zza;
    }

    static zzgz zzb(zzgz zzgz, zzgz zzgz2) {
        int i10 = zzgz.zzb + zzgz2.zzb;
        int[] copyOf = Arrays.copyOf(zzgz.zzc, i10);
        System.arraycopy(zzgz2.zzc, 0, copyOf, zzgz.zzb, zzgz2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgz.zzd, i10);
        System.arraycopy(zzgz2.zzd, 0, copyOf2, zzgz.zzb, zzgz2.zzb);
        return new zzgz(i10, copyOf, copyOf2, true);
    }

    static zzgz zzc() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgz = (zzgz) obj;
        int i10 = this.zzb;
        if (i10 == zzgz.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgz.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgz.zzd;
                    int i12 = this.zzb;
                    int i13 = 0;
                    while (i13 < i12) {
                        if (objArr[i13].equals(objArr2[i13])) {
                            i13++;
                        }
                    }
                    return true;
                } else if (iArr[i11] != iArr2[i11]) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = (i10 + 527) * 31;
        int[] iArr = this.zzc;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 + i13) * 31;
        Object[] objArr = this.zzd;
        int i16 = this.zzb;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final void zzd() {
        this.zze = false;
    }

    /* access modifiers changed from: package-private */
    public final void zze(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            m1.b(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i10, Object obj) {
        int i11;
        if (this.zze) {
            int i12 = this.zzb;
            int[] iArr = this.zzc;
            if (i12 == iArr.length) {
                if (i12 < 4) {
                    i11 = 8;
                } else {
                    i11 = i12 >> 1;
                }
                int i13 = i12 + i11;
                this.zzc = Arrays.copyOf(iArr, i13);
                this.zzd = Arrays.copyOf(this.zzd, i13);
            }
            int[] iArr2 = this.zzc;
            int i14 = this.zzb;
            iArr2[i14] = i10;
            this.zzd[i14] = obj;
            this.zzb = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }
}
