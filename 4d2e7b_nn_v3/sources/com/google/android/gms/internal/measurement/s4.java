package com.google.android.gms.internal.measurement;

import okio.Utf8;

abstract class s4 {
    static /* bridge */ /* synthetic */ void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) {
        if (e(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || e(b12) || e(b13)) {
            throw zzkp.zzc();
        }
        byte b14 = ((b10 & 7) << 18) | ((b11 & Utf8.REPLACEMENT_BYTE) << 12) | ((b12 & Utf8.REPLACEMENT_BYTE) << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
        cArr[i10] = (char) ((b14 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i10 + 1] = (char) ((b14 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    static /* bridge */ /* synthetic */ void b(byte b10, byte b11, byte b12, char[] cArr, int i10) {
        if (!e(b11)) {
            if (b10 == -32) {
                if (b11 >= -96) {
                    b10 = -32;
                }
            }
            if (b10 == -19) {
                if (b11 < -96) {
                    b10 = -19;
                }
            }
            if (!e(b12)) {
                cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & Utf8.REPLACEMENT_BYTE) << 6) | (b12 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzkp.zzc();
    }

    static /* bridge */ /* synthetic */ void c(byte b10, byte b11, char[] cArr, int i10) {
        if (b10 < -62 || e(b11)) {
            throw zzkp.zzc();
        }
        cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & Utf8.REPLACEMENT_BYTE));
    }

    static /* bridge */ /* synthetic */ boolean d(byte b10) {
        return b10 >= 0;
    }

    private static boolean e(byte b10) {
        return b10 > -65;
    }
}
