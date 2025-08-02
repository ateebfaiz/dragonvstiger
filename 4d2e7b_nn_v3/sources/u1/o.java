package u1;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f24263a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap f24264b = new ConcurrentHashMap();

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] b(InputStream inputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("InputStream is null");
    }
}
