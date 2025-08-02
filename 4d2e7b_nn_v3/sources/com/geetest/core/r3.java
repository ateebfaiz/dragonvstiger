package com.geetest.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public abstract class r3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f6158a;

    /* renamed from: b  reason: collision with root package name */
    public final p3 f6159b;

    public r3(p3 p3Var, InputStream inputStream) {
        this.f6159b = p3Var;
        this.f6158a = inputStream;
    }

    public int a() throws q3 {
        try {
            int read = this.f6158a.read();
            if (read != -1) {
                return read;
            }
            throw new IOException("Unexpected end of stream");
        } catch (IOException e10) {
            throw new q3((Throwable) e10);
        }
    }

    public BigInteger b(int i10) throws q3 {
        int ordinal = e4.ofByte(i10).ordinal();
        if (ordinal == 0) {
            return BigInteger.valueOf((long) (i10 & 31));
        }
        if (ordinal == 1) {
            return BigInteger.valueOf((long) a());
        }
        if (ordinal == 2) {
            byte[] c10 = c(2);
            return BigInteger.valueOf(((long) ((c10[0] & 255) << 8)) | ((long) (c10[1] & 255)));
        } else if (ordinal == 3) {
            byte[] c11 = c(4);
            return BigInteger.valueOf((((long) (c11[2] & 255)) << 8) | (((long) (c11[0] & 255)) << 24) | (((long) (c11[1] & 255)) << 16) | ((long) (c11[3] & 255)));
        } else if (ordinal == 4) {
            BigInteger bigInteger = BigInteger.ZERO;
            byte[] c12 = c(8);
            return bigInteger.or(BigInteger.valueOf((long) (c12[0] & 255)).shiftLeft(56)).or(BigInteger.valueOf((long) (c12[1] & 255)).shiftLeft(48)).or(BigInteger.valueOf((long) (c12[2] & 255)).shiftLeft(40)).or(BigInteger.valueOf((long) (c12[3] & 255)).shiftLeft(32)).or(BigInteger.valueOf((long) (c12[4] & 255)).shiftLeft(24)).or(BigInteger.valueOf((long) (c12[5] & 255)).shiftLeft(16)).or(BigInteger.valueOf((long) (c12[6] & 255)).shiftLeft(8)).or(BigInteger.valueOf((long) (c12[7] & 255)).shiftLeft(0));
        } else if (ordinal == 6) {
            return BigInteger.valueOf(-1);
        } else {
            throw new q3("Reserved additional information");
        }
    }

    public byte[] c(int i10) throws q3 {
        try {
            byte[] bArr = new byte[i10];
            int read = this.f6158a.read(bArr);
            if (read == i10) {
                return bArr;
            }
            if (read != -1) {
                int i11 = i10 - read;
                while (i11 > 0) {
                    int read2 = this.f6158a.read(bArr, i10 - i11, i11);
                    if (read2 != -1) {
                        i11 -= read2;
                    } else {
                        throw new IOException("Unexpected end of stream");
                    }
                }
                return bArr;
            }
            throw new IOException("Unexpected end of stream");
        } catch (IOException e10) {
            throw new q3((Throwable) e10);
        }
    }

    public byte[] a(long j10) throws q3 {
        if (j10 <= 2147483647L) {
            int i10 = (int) j10;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.abs(i10));
            if (j10 > 4096) {
                j10 = 4096;
            }
            int i11 = (int) j10;
            byte[] bArr = new byte[i11];
            while (i10 > 0) {
                try {
                    int read = this.f6158a.read(bArr, 0, i10 > i11 ? i11 : i10);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i10 -= read;
                    } else {
                        throw new IOException("Unexpected end of stream");
                    }
                } catch (IOException e10) {
                    throw new q3((Throwable) e10);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new q3("Decoding fixed size items is limited to INTMAX");
    }

    public long a(int i10) throws q3 {
        int ordinal = e4.ofByte(i10).ordinal();
        if (ordinal == 0) {
            return (long) (i10 & 31);
        }
        if (ordinal == 1) {
            return (long) a();
        }
        if (ordinal == 2) {
            byte[] c10 = c(2);
            return ((long) ((c10[0] & 255) << 8)) | ((long) (c10[1] & 255));
        } else if (ordinal == 3) {
            byte[] c11 = c(4);
            return (((long) (c11[2] & 255)) << 8) | (((long) (c11[0] & 255)) << 24) | (((long) (c11[1] & 255)) << 16) | ((long) (c11[3] & 255));
        } else if (ordinal == 4) {
            byte[] c12 = c(8);
            return (((long) (c12[6] & 255)) << 8) | (((long) (c12[5] & 255)) << 16) | (((long) (c12[4] & 255)) << 24) | (((long) (c12[0] & 255)) << 56) | (((long) (c12[1] & 255)) << 48) | (((long) (c12[2] & 255)) << 40) | (((long) (c12[3] & 255)) << 32) | ((long) (c12[7] & 255));
        } else if (ordinal == 6) {
            return -1;
        } else {
            throw new q3("Reserved additional information");
        }
    }
}
