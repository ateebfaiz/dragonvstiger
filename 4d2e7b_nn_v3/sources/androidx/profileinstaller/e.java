package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

abstract class e {
    static int a(int i10) {
        return ((i10 + 7) & -8) / 8;
    }

    static byte[] b(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    static RuntimeException c(String str) {
        return new IllegalStateException(str);
    }

    static byte[] d(InputStream inputStream, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, i11, i10 - i11);
            if (read >= 0) {
                i11 += read;
            } else {
                throw c("Not enough bytes to read: " + i10);
            }
        }
        return bArr;
    }

    static byte[] e(InputStream inputStream, int i10, int i11) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i11];
            byte[] bArr2 = new byte[2048];
            int i12 = 0;
            int i13 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i12 < i10) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i13 += inflater.inflate(bArr, i13, i11 - i13);
                    i12 += read;
                } else {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i10 + " bytes");
                }
            }
            if (i12 != i10) {
                throw c("Didn't read enough bytes during decompression. expected=" + i10 + " actual=" + i12);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw c("Inflater did not finish");
            }
        } catch (DataFormatException e10) {
            throw c(e10.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    static String f(InputStream inputStream, int i10) {
        return new String(d(inputStream, i10), StandardCharsets.UTF_8);
    }

    static long g(InputStream inputStream, int i10) {
        byte[] d10 = d(inputStream, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 += ((long) (d10[i11] & 255)) << (i11 * 8);
        }
        return j10;
    }

    static int h(InputStream inputStream) {
        return (int) g(inputStream, 2);
    }

    static long i(InputStream inputStream) {
        return g(inputStream, 4);
    }

    static int j(InputStream inputStream) {
        return (int) g(inputStream, 1);
    }

    static int k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void l(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static void m(OutputStream outputStream, byte[] bArr) {
        q(outputStream, (long) bArr.length);
        byte[] b10 = b(bArr);
        q(outputStream, (long) b10.length);
        outputStream.write(b10);
    }

    static void n(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void o(OutputStream outputStream, long j10, int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) ((int) ((j10 >> (i11 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    static void p(OutputStream outputStream, int i10) {
        o(outputStream, (long) i10, 2);
    }

    static void q(OutputStream outputStream, long j10) {
        o(outputStream, j10, 4);
    }

    static void r(OutputStream outputStream, int i10) {
        o(outputStream, (long) i10, 1);
    }
}
