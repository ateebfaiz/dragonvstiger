package y2;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class a {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        l.g(inputStream);
        l.g(outputStream);
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += (long) read;
        }
    }

    public static int b(InputStream inputStream, byte[] bArr, int i10, int i11) {
        l.g(inputStream);
        l.g(bArr);
        if (i11 >= 0) {
            int i12 = 0;
            while (i12 < i11) {
                int read = inputStream.read(bArr, i10 + i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            }
            return i12;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }
}
