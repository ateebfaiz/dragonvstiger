package com.google.android.gms.internal.auth;

import c.d;

abstract class o0 {
    static int a(byte[] bArr, int i10, n0 n0Var) {
        int j10 = j(bArr, i10, n0Var);
        int i11 = n0Var.f6952a;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 > bArr.length - j10) {
            throw zzfa.zzf();
        } else if (i11 == 0) {
            n0Var.f6954c = zzee.zzb;
            return j10;
        } else {
            n0Var.f6954c = zzee.zzk(bArr, j10, i11);
            return j10 + i11;
        }
    }

    static int b(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    static int c(v1 v1Var, byte[] bArr, int i10, int i11, int i12, n0 n0Var) {
        n1 n1Var = (n1) v1Var;
        Object zzd = n1Var.zzd();
        int q10 = n1Var.q(zzd, bArr, i10, i11, i12, n0Var);
        n1Var.c(zzd);
        n0Var.f6954c = zzd;
        return q10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int d(com.google.android.gms.internal.auth.v1 r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.auth.n0 r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = k(r8, r7, r0, r10)
            int r8 = r10.f6952a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zzd()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.b(r1, r2, r3, r4, r5)
            r6.c(r9)
            r10.f6954c = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.auth.zzfa r6 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.o0.d(com.google.android.gms.internal.auth.v1, byte[], int, int, com.google.android.gms.internal.auth.n0):int");
    }

    static int e(v1 v1Var, int i10, byte[] bArr, int i11, int i12, zzey zzey, n0 n0Var) {
        int d10 = d(v1Var, bArr, i11, i12, n0Var);
        zzey.add(n0Var.f6954c);
        while (d10 < i12) {
            int j10 = j(bArr, d10, n0Var);
            if (i10 != n0Var.f6952a) {
                break;
            }
            d10 = d(v1Var, bArr, j10, i12, n0Var);
            zzey.add(n0Var.f6954c);
        }
        return d10;
    }

    static int f(byte[] bArr, int i10, zzey zzey, n0 n0Var) {
        d.a(zzey);
        int j10 = j(bArr, i10, n0Var);
        int i11 = n0Var.f6952a + j10;
        if (j10 < i11) {
            j(bArr, j10, n0Var);
            throw null;
        } else if (j10 == i11) {
            return j10;
        } else {
            throw zzfa.zzf();
        }
    }

    static int g(byte[] bArr, int i10, n0 n0Var) {
        int j10 = j(bArr, i10, n0Var);
        int i11 = n0Var.f6952a;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 == 0) {
            n0Var.f6954c = "";
            return j10;
        } else {
            n0Var.f6954c = new String(bArr, j10, i11, zzez.zzb);
            return j10 + i11;
        }
    }

    static int h(byte[] bArr, int i10, n0 n0Var) {
        int j10 = j(bArr, i10, n0Var);
        int i11 = n0Var.f6952a;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 == 0) {
            n0Var.f6954c = "";
            return j10;
        } else {
            n0Var.f6954c = t2.b(bArr, j10, i11);
            return j10 + i11;
        }
    }

    static int i(int i10, byte[] bArr, int i11, int i12, zzgz zzgz, n0 n0Var) {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int m10 = m(bArr, i11, n0Var);
                zzgz.zzf(i10, Long.valueOf(n0Var.f6953b));
                return m10;
            } else if (i13 == 1) {
                zzgz.zzf(i10, Long.valueOf(n(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int j10 = j(bArr, i11, n0Var);
                int i14 = n0Var.f6952a;
                if (i14 < 0) {
                    throw zzfa.zzc();
                } else if (i14 <= bArr.length - j10) {
                    if (i14 == 0) {
                        zzgz.zzf(i10, zzee.zzb);
                    } else {
                        zzgz.zzf(i10, zzee.zzk(bArr, j10, i14));
                    }
                    return j10 + i14;
                } else {
                    throw zzfa.zzf();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zzgz zzc = zzgz.zzc();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int j11 = j(bArr, i11, n0Var);
                    int i17 = n0Var.f6952a;
                    if (i17 == i15) {
                        i16 = i17;
                        i11 = j11;
                        break;
                    }
                    i16 = i17;
                    i11 = i(i17, bArr, j11, i12, zzc, n0Var);
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzfa.zzd();
                }
                zzgz.zzf(i10, zzc);
                return i11;
            } else if (i13 == 5) {
                zzgz.zzf(i10, Integer.valueOf(b(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzfa.zza();
            }
        } else {
            throw zzfa.zza();
        }
    }

    static int j(byte[] bArr, int i10, n0 n0Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return k(b10, bArr, i11, n0Var);
        }
        n0Var.f6952a = b10;
        return i11;
    }

    static int k(int i10, byte[] bArr, int i11, n0 n0Var) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            n0Var.f6952a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            n0Var.f6952a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            n0Var.f6952a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            n0Var.f6952a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                n0Var.f6952a = i20;
                return i21;
            }
        }
    }

    static int l(int i10, byte[] bArr, int i11, int i12, zzey zzey, n0 n0Var) {
        d.a(zzey);
        j(bArr, i11, n0Var);
        int i13 = n0Var.f6952a;
        throw null;
    }

    static int m(byte[] bArr, int i10, n0 n0Var) {
        int i11 = i10 + 1;
        long j10 = (long) bArr[i10];
        if (j10 >= 0) {
            n0Var.f6953b = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & Byte.MAX_VALUE)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & Byte.MAX_VALUE)) << i13;
            int i15 = i14;
            b10 = b11;
            i12 = i15;
        }
        n0Var.f6953b = j11;
        return i12;
    }

    static long n(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }
}
