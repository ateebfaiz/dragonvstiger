package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzmp {
    private static final zzmp zza = new zzmp(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmp(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzmp zzc() {
        return zza;
    }

    static zzmp zze(zzmp zzmp, zzmp zzmp2) {
        int i10 = zzmp.zzb + zzmp2.zzb;
        int[] copyOf = Arrays.copyOf(zzmp.zzc, i10);
        System.arraycopy(zzmp2.zzc, 0, copyOf, zzmp.zzb, zzmp2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmp.zzd, i10);
        System.arraycopy(zzmp2.zzd, 0, copyOf2, zzmp.zzb, zzmp2.zzb);
        return new zzmp(i10, copyOf, copyOf2, true);
    }

    static zzmp zzf() {
        return new zzmp(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmp)) {
            return false;
        }
        zzmp zzmp = (zzmp) obj;
        int i10 = this.zzb;
        if (i10 == zzmp.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmp.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmp.zzd;
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

    public final int zza() {
        int zzA;
        int zzB;
        int i10;
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            int i14 = this.zzc[i13];
            int i15 = i14 >>> 3;
            int i16 = i14 & 7;
            if (i16 == 0) {
                long longValue = ((Long) this.zzd[i13]).longValue();
                zzA = zzjm.zzA(i15 << 3);
                zzB = zzjm.zzB(longValue);
                i10 = zzA + zzB;
            } else if (i16 == 1) {
                ((Long) this.zzd[i13]).longValue();
                i10 = zzjm.zzA(i15 << 3) + 8;
            } else if (i16 == 2) {
                int zzA2 = zzjm.zzA(i15 << 3);
                int zzd2 = ((zzje) this.zzd[i13]).zzd();
                i12 += zzA2 + zzjm.zzA(zzd2) + zzd2;
            } else if (i16 == 3) {
                int zzz = zzjm.zzz(i15);
                zzA = zzz + zzz;
                zzB = ((zzmp) this.zzd[i13]).zza();
                i10 = zzA + zzB;
            } else if (i16 == 5) {
                ((Integer) this.zzd[i13]).intValue();
                i10 = zzjm.zzA(i15 << 3) + 4;
            } else {
                throw new IllegalStateException(zzkp.zza());
            }
            i12 += i10;
        }
        this.zze = i12;
        return i12;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            int zzA = zzjm.zzA(8);
            int zzd2 = ((zzje) this.zzd[i12]).zzd();
            i11 += zzA + zzA + zzjm.zzA(16) + zzjm.zzA(i13 >>> 3) + zzjm.zzA(24) + zzjm.zzA(zzd2) + zzd2;
        }
        this.zze = i11;
        return i11;
    }

    /* access modifiers changed from: package-private */
    public final zzmp zzd(zzmp zzmp) {
        if (zzmp.equals(zza)) {
            return this;
        }
        zzg();
        int i10 = this.zzb + zzmp.zzb;
        zzl(i10);
        System.arraycopy(zzmp.zzc, 0, this.zzc, this.zzb, zzmp.zzb);
        System.arraycopy(zzmp.zzd, 0, this.zzd, this.zzb, zzmp.zzb);
        this.zzb = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            n3.b(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i10, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    public final void zzk(x4 x4Var) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 >>> 3;
                int i13 = i11 & 7;
                if (i13 == 0) {
                    x4Var.h(i12, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    x4Var.F(i12, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    x4Var.n(i12, (zzje) obj);
                } else if (i13 == 3) {
                    x4Var.D(i12);
                    ((zzmp) obj).zzk(x4Var);
                    x4Var.J(i12);
                } else if (i13 == 5) {
                    x4Var.d(i12, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzkp.zza());
                }
            }
        }
    }

    private zzmp() {
        this(0, new int[8], new Object[8], true);
    }
}
