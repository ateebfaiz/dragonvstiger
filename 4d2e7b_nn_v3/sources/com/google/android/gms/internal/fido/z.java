package com.google.android.gms.internal.fido;

import java.math.RoundingMode;
import java.util.Arrays;

final class z {

    /* renamed from: a  reason: collision with root package name */
    private final String f7102a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final char[] f7103b;

    /* renamed from: c  reason: collision with root package name */
    final int f7104c;

    /* renamed from: d  reason: collision with root package name */
    final int f7105d;

    /* renamed from: e  reason: collision with root package name */
    final int f7106e;

    /* renamed from: f  reason: collision with root package name */
    final int f7107f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f7108g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7109h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    z(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = r3
        L_0x000a:
            int r5 = r11.length
            if (r4 >= r5) goto L_0x002b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L_0x0014
            r7 = r6
            goto L_0x0015
        L_0x0014:
            r7 = r3
        L_0x0015:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r7, r8, r5)
            byte r7 = r1[r5]
            if (r7 != r2) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r6 = r3
        L_0x0020:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto L_0x000a
        L_0x002b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.z.<init>(java.lang.String, char[]):void");
    }

    /* access modifiers changed from: package-private */
    public final char a(int i10) {
        return this.f7103b[i10];
    }

    /* access modifiers changed from: package-private */
    public final z b() {
        int i10;
        boolean z10;
        for (char zza : this.f7103b) {
            if (zzad.zza(zza)) {
                char[] cArr = this.f7103b;
                int length = cArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char c10 = cArr[i11];
                    if (c10 >= 'A' && c10 <= 'Z') {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
                if (!z10) {
                    char[] cArr2 = new char[this.f7103b.length];
                    int i12 = 0;
                    while (true) {
                        char[] cArr3 = this.f7103b;
                        if (i12 >= cArr3.length) {
                            break;
                        }
                        char c11 = cArr3[i12];
                        if (zzad.zza(c11)) {
                            c11 ^= ' ';
                        }
                        cArr2[i12] = (char) c11;
                        i12++;
                    }
                    z zVar = new z(this.f7102a.concat(".upperCase()"), cArr2);
                    if (!this.f7109h || zVar.f7109h) {
                        return zVar;
                    }
                    byte[] bArr = zVar.f7108g;
                    byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                    for (i10 = 65; i10 <= 90; i10++) {
                        int i13 = i10 | 32;
                        byte[] bArr2 = zVar.f7108g;
                        byte b10 = bArr2[i10];
                        byte b11 = bArr2[i13];
                        if (b10 == -1) {
                            copyOf[i10] = b11;
                        } else {
                            char c12 = (char) i10;
                            char c13 = (char) i13;
                            if (b11 == -1) {
                                copyOf[i13] = b10;
                            } else {
                                throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c12), Character.valueOf(c13)));
                            }
                        }
                    }
                    return new z(zVar.f7102a.concat(".ignoreCase()"), zVar.f7103b, copyOf, true);
                }
                throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
            }
        }
        return this;
    }

    public final boolean c(char c10) {
        byte[] bArr = this.f7108g;
        if (bArr.length <= 61 || bArr[61] == -1) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.f7109h != zVar.f7109h || !Arrays.equals(this.f7103b, zVar.f7103b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = Arrays.hashCode(this.f7103b);
        if (true != this.f7109h) {
            i10 = 1237;
        } else {
            i10 = 1231;
        }
        return hashCode + i10;
    }

    public final String toString() {
        return this.f7102a;
    }

    private z(String str, char[] cArr, byte[] bArr, boolean z10) {
        this.f7102a = str;
        cArr.getClass();
        this.f7103b = cArr;
        try {
            int length = cArr.length;
            int zzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.f7105d = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i10 = 1 << (3 - numberOfTrailingZeros);
            this.f7106e = i10;
            this.f7107f = zzb >> numberOfTrailingZeros;
            this.f7104c = length - 1;
            this.f7108g = bArr;
            boolean[] zArr = new boolean[i10];
            for (int i11 = 0; i11 < this.f7107f; i11++) {
                zArr[zzcj.zza(i11 * 8, this.f7105d, RoundingMode.CEILING)] = true;
            }
            this.f7109h = z10;
        } catch (ArithmeticException e10) {
            int length2 = cArr.length;
            throw new IllegalArgumentException("Illegal alphabet length " + length2, e10);
        }
    }
}
