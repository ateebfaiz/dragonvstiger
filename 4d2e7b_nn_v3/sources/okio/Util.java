package okio;

import kotlin.jvm.internal.m;
import okio.internal.ByteStringKt;

/* renamed from: okio.-Util  reason: invalid class name */
public final class Util {
    public static final int and(byte b10, int i10) {
        return b10 & i10;
    }

    public static final boolean arrayRangeEquals(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        m.f(bArr, "a");
        m.f(bArr2, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int leftRotate(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public static final long minOf(long j10, int i10) {
        return Math.min(j10, (long) i10);
    }

    public static final int reverseBytes(int i10) {
        return ((i10 & 255) << 24) | ((-16777216 & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final long rightRotate(long j10, int i10) {
        return (j10 << (64 - i10)) | (j10 >>> i10);
    }

    public static final int shl(byte b10, int i10) {
        return b10 << i10;
    }

    public static final int shr(byte b10, int i10) {
        return b10 >> i10;
    }

    public static final String toHexString(byte b10) {
        return new String(new char[]{ByteStringKt.getHEX_DIGIT_CHARS()[(b10 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[b10 & 15]});
    }

    public static final long and(byte b10, long j10) {
        return ((long) b10) & j10;
    }

    public static final long minOf(int i10, long j10) {
        return Math.min((long) i10, j10);
    }

    public static final long reverseBytes(long j10) {
        return ((j10 & 255) << 56) | ((-72057594037927936L & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static final long and(int i10, long j10) {
        return ((long) i10) & j10;
    }

    public static final short reverseBytes(short s10) {
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    public static final String toHexString(int i10) {
        int i11 = 0;
        if (i10 == 0) {
            return "0";
        }
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 28) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 24) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 20) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 16) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 12) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 8) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i10 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return new String(cArr, i11, 8 - i11);
    }

    public static final String toHexString(long j10) {
        if (j10 == 0) {
            return "0";
        }
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 60) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 56) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 52) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 48) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 44) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 40) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 36) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 32) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 28) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 24) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 20) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 16) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 12) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 8) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j10 >> 4) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j10 & 15)]};
        int i10 = 0;
        while (i10 < 16 && cArr[i10] == '0') {
            i10++;
        }
        return new String(cArr, i10, 16 - i10);
    }
}
