package ae;

import java.io.ByteArrayOutputStream;
import zd.f;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final b f17a = new e();

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f17a.a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new a("exception decoding Hex string: " + e10.getMessage(), e10);
        }
    }

    public static byte[] b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public static byte[] c(byte[] bArr, int i10, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f17a.b(bArr, i10, i11, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e10) {
            throw new c("exception encoding Hex string: " + e10.getMessage(), e10);
        }
    }

    public static String d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static String e(byte[] bArr, int i10, int i11) {
        return f.b(c(bArr, i10, i11));
    }
}
