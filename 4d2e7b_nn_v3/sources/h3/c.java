package h3;

import com.facebook.webpsupport.WebpBitmapFactoryImpl;
import java.io.UnsupportedEncodingException;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f21889a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f21890b = e();

    /* renamed from: c  reason: collision with root package name */
    public static b f21891c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f21892d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f21893e = a("RIFF");

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f21894f = a("WEBP");

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f21895g = a("VP8 ");

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f21896h = a("VP8L");

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f21897i = a("VP8X");

    private static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("ASCII not found!", e10);
        }
    }

    public static boolean b(byte[] bArr, int i10) {
        boolean z10;
        boolean j10 = j(bArr, i10 + 12, f21897i);
        if ((bArr[i10 + 20] & 2) == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!j10 || !z10) {
            return false;
        }
        return true;
    }

    public static boolean c(byte[] bArr, int i10, int i11) {
        if (i11 < 21 || !j(bArr, i10 + 12, f21897i)) {
            return false;
        }
        return true;
    }

    public static boolean d(byte[] bArr, int i10) {
        boolean z10;
        boolean j10 = j(bArr, i10 + 12, f21897i);
        if ((bArr[i10 + 20] & 16) == 16) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!j10 || !z10) {
            return false;
        }
        return true;
    }

    private static boolean e() {
        return true;
    }

    public static boolean f(byte[] bArr, int i10) {
        return j(bArr, i10 + 12, f21896h);
    }

    public static boolean g(byte[] bArr, int i10) {
        return j(bArr, i10 + 12, f21895g);
    }

    public static boolean h(byte[] bArr, int i10, int i11) {
        if (i11 < 20 || !j(bArr, i10, f21893e) || !j(bArr, i10 + 8, f21894f)) {
            return false;
        }
        return true;
    }

    public static b i() {
        b bVar;
        if (f21892d) {
            return f21891c;
        }
        try {
            bVar = WebpBitmapFactoryImpl.class.newInstance();
        } catch (Throwable unused) {
            bVar = null;
        }
        f21892d = true;
        return bVar;
    }

    private static boolean j(byte[] bArr, int i10, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i10 > bArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            if (bArr[i11 + i10] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }
}
