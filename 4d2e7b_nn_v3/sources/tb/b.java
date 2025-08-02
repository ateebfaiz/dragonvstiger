package tb;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.m;

public abstract class b {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i10) {
        m.f(inputStream, "<this>");
        m.f(outputStream, "out");
        byte[] bArr = new byte[i10];
        int read = inputStream.read(bArr);
        long j10 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j10 += (long) read;
            read = inputStream.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(inputStream, outputStream, i10);
    }

    public static final byte[] c(InputStream inputStream) {
        m.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        m.e(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
