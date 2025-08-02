package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import androidx.annotation.DoNotInline;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class a {

    /* renamed from: androidx.exifinterface.media.a$a  reason: collision with other inner class name */
    static class C0200a {
        @DoNotInline
        static void a(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        @DoNotInline
        static FileDescriptor b(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        @DoNotInline
        static long c(FileDescriptor fileDescriptor, long j10, int i10) throws ErrnoException {
            return Os.lseek(fileDescriptor, j10, i10);
        }
    }

    static class b {
        @DoNotInline
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i10])}));
        }
        return sb2.toString();
    }

    static void b(FileDescriptor fileDescriptor) {
        try {
            C0200a.a(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterfaceUtils", "Error closing fd.");
        }
    }

    static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    static long[] d(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                jArr[i10] = (long) iArr[i10];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    static int e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i10;
            }
            i10 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    static void f(InputStream inputStream, OutputStream outputStream, int i10) {
        byte[] bArr = new byte[8192];
        while (i10 > 0) {
            int min = Math.min(i10, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i10 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    static long g(String str) {
        try {
            int min = Math.min(str.length(), 3);
            long parseLong = Long.parseLong(str.substring(0, min));
            while (min < 3) {
                parseLong *= 10;
                min++;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    static boolean h(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
