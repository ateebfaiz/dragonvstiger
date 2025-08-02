package i;

import android.text.TextUtils;
import com.alibaba.pdns.j;
import com.mah.ndk.MahxServer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.CRC32;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference f22025a = new AtomicReference((Object) null);

    public static String a() {
        AtomicReference atomicReference = f22025a;
        char[] cArr = (char[]) atomicReference.get();
        if (cArr != null) {
            return new String(cArr);
        }
        String OooO00o = MahxServer.OooO00o();
        if (TextUtils.isEmpty(OooO00o)) {
            return "";
        }
        atomicReference.set(OooO00o.toCharArray());
        return OooO00o;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return f(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String c(String str, String str2) {
        return b(str + a() + str2);
    }

    public static String d(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(r1 << 1)];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 >>> 4) & 15];
            i10 += 2;
            cArr2[i11] = cArr[b10 & 15];
        }
        return new String(cArr2);
    }

    public static String e(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return Long.toHexString(crc32.getValue());
    }

    public static String f(byte[] bArr) {
        byte[] g10;
        if (bArr == null || (g10 = g(bArr)) == null) {
            return null;
        }
        return d(g10);
    }

    public static byte[] g(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
