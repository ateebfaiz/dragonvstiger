package u1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import s1.a;

public abstract class g {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a.h("GZipUtil", "closeQuietly failed " + th.getMessage());
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a(byteArrayInputStream);
                    a(gZIPInputStream);
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            a(byteArrayOutputStream);
            a(byteArrayInputStream);
            a(gZIPInputStream);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th) {
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            throw th;
        }
    }
}
