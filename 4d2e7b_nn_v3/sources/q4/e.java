package q4;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.g0;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f23239a = new e();

    private e() {
    }

    public static final byte[] a(String str) {
        m.f(str, "value");
        try {
            Charset forName = Charset.forName("ASCII");
            m.e(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            m.e(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("ASCII not found!", e10);
        }
    }

    public static final boolean b(byte[] bArr, byte[] bArr2, int i10) {
        m.f(bArr, "byteArray");
        m.f(bArr2, "pattern");
        if (bArr2.length + i10 > bArr.length) {
            return false;
        }
        IntRange w10 = j.w(bArr2);
        if (!(w10 instanceof Collection) || !((Collection) w10).isEmpty()) {
            Iterator it = w10.iterator();
            while (it.hasNext()) {
                int nextInt = ((g0) it).nextInt();
                if (bArr[i10 + nextInt] != bArr2[nextInt]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean c(byte[] bArr, byte[] bArr2) {
        m.f(bArr, "byteArray");
        m.f(bArr2, "pattern");
        return b(bArr, bArr2, 0);
    }
}
