package org.cocos2dx.okio;

import java.nio.charset.Charset;

abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1800a = Charset.forName("UTF-8");

    public static boolean a(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12)}));
        }
    }

    public static int c(int i10) {
        return ((i10 & 255) << 24) | ((-16777216 & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static long d(long j10) {
        return ((j10 & 255) << 56) | ((-72057594037927936L & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static short e(short s10) {
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    public static void f(Throwable th) {
        g(th);
    }

    private static void g(Throwable th) {
        throw th;
    }
}
