package com.google.android.gms.internal.measurement;

abstract class j2 {
    static int a(byte[] bArr, int i10, i2 i2Var) {
        int j10 = j(bArr, i10, i2Var);
        int i11 = i2Var.f7198a;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 > bArr.length - j10) {
            throw zzkp.zzf();
        } else if (i11 == 0) {
            i2Var.f7200c = zzje.zzb;
            return j10;
        } else {
            i2Var.f7200c = zzje.zzl(bArr, j10, i11);
            return j10 + i11;
        }
    }

    static int b(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    static int c(w3 w3Var, byte[] bArr, int i10, int i11, int i12, i2 i2Var) {
        Object zze = w3Var.zze();
        int n10 = n(zze, w3Var, bArr, i10, i11, i12, i2Var);
        w3Var.b(zze);
        i2Var.f7200c = zze;
        return n10;
    }

    static int d(w3 w3Var, byte[] bArr, int i10, int i11, i2 i2Var) {
        Object zze = w3Var.zze();
        int o10 = o(zze, w3Var, bArr, i10, i11, i2Var);
        w3Var.b(zze);
        i2Var.f7200c = zze;
        return o10;
    }

    static int e(w3 w3Var, int i10, byte[] bArr, int i11, int i12, zzkm zzkm, i2 i2Var) {
        int d10 = d(w3Var, bArr, i11, i12, i2Var);
        zzkm.add(i2Var.f7200c);
        while (d10 < i12) {
            int j10 = j(bArr, d10, i2Var);
            if (i10 != i2Var.f7198a) {
                break;
            }
            d10 = d(w3Var, bArr, j10, i12, i2Var);
            zzkm.add(i2Var.f7200c);
        }
        return d10;
    }

    static int f(byte[] bArr, int i10, zzkm zzkm, i2 i2Var) {
        b3 b3Var = (b3) zzkm;
        int j10 = j(bArr, i10, i2Var);
        int i11 = i2Var.f7198a + j10;
        while (j10 < i11) {
            j10 = j(bArr, j10, i2Var);
            b3Var.d(i2Var.f7198a);
        }
        if (j10 == i11) {
            return j10;
        }
        throw zzkp.zzf();
    }

    static int g(byte[] bArr, int i10, i2 i2Var) {
        int j10 = j(bArr, i10, i2Var);
        int i11 = i2Var.f7198a;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 == 0) {
            i2Var.f7200c = "";
            return j10;
        } else {
            i2Var.f7200c = new String(bArr, j10, i11, zzkn.zzb);
            return j10 + i11;
        }
    }

    static int h(byte[] bArr, int i10, i2 i2Var) {
        int j10 = j(bArr, i10, i2Var);
        int i11 = i2Var.f7198a;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 == 0) {
            i2Var.f7200c = "";
            return j10;
        } else {
            i2Var.f7200c = w4.d(bArr, j10, i11);
            return j10 + i11;
        }
    }

    static int i(int i10, byte[] bArr, int i11, int i12, zzmp zzmp, i2 i2Var) {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int m10 = m(bArr, i11, i2Var);
                zzmp.zzj(i10, Long.valueOf(i2Var.f7199b));
                return m10;
            } else if (i13 == 1) {
                zzmp.zzj(i10, Long.valueOf(p(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int j10 = j(bArr, i11, i2Var);
                int i14 = i2Var.f7198a;
                if (i14 < 0) {
                    throw zzkp.zzd();
                } else if (i14 <= bArr.length - j10) {
                    if (i14 == 0) {
                        zzmp.zzj(i10, zzje.zzb);
                    } else {
                        zzmp.zzj(i10, zzje.zzl(bArr, j10, i14));
                    }
                    return j10 + i14;
                } else {
                    throw zzkp.zzf();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zzmp zzf = zzmp.zzf();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int j11 = j(bArr, i11, i2Var);
                    int i17 = i2Var.f7198a;
                    if (i17 == i15) {
                        i16 = i17;
                        i11 = j11;
                        break;
                    }
                    i16 = i17;
                    i11 = i(i17, bArr, j11, i12, zzf, i2Var);
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzkp.zze();
                }
                zzmp.zzj(i10, zzf);
                return i11;
            } else if (i13 == 5) {
                zzmp.zzj(i10, Integer.valueOf(b(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzkp.zzb();
            }
        } else {
            throw zzkp.zzb();
        }
    }

    static int j(byte[] bArr, int i10, i2 i2Var) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return k(b10, bArr, i11, i2Var);
        }
        i2Var.f7198a = b10;
        return i11;
    }

    static int k(int i10, byte[] bArr, int i11, i2 i2Var) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            i2Var.f7198a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            i2Var.f7198a = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            i2Var.f7198a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            i2Var.f7198a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                i2Var.f7198a = i20;
                return i21;
            }
        }
    }

    static int l(int i10, byte[] bArr, int i11, int i12, zzkm zzkm, i2 i2Var) {
        b3 b3Var = (b3) zzkm;
        int j10 = j(bArr, i11, i2Var);
        b3Var.d(i2Var.f7198a);
        while (j10 < i12) {
            int j11 = j(bArr, j10, i2Var);
            if (i10 != i2Var.f7198a) {
                break;
            }
            j10 = j(bArr, j11, i2Var);
            b3Var.d(i2Var.f7198a);
        }
        return j10;
    }

    static int m(byte[] bArr, int i10, i2 i2Var) {
        int i11 = i10 + 1;
        long j10 = (long) bArr[i10];
        if (j10 >= 0) {
            i2Var.f7199b = j10;
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
        i2Var.f7199b = j11;
        return i12;
    }

    static int n(Object obj, w3 w3Var, byte[] bArr, int i10, int i11, int i12, i2 i2Var) {
        int I = ((o3) w3Var).I(obj, bArr, i10, i11, i12, i2Var);
        i2Var.f7200c = obj;
        return I;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int o(java.lang.Object r6, com.google.android.gms.internal.measurement.w3 r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.i2 r11) {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = k(r9, r8, r0, r11)
            int r9 = r11.f7198a
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.g(r1, r2, r3, r4, r5)
            r11.f7200c = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.measurement.zzkp r6 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.j2.o(java.lang.Object, com.google.android.gms.internal.measurement.w3, byte[], int, int, com.google.android.gms.internal.measurement.i2):int");
    }

    static long p(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }
}
