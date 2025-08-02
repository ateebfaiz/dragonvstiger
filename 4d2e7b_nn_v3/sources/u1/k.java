package u1;

import android.text.TextUtils;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import s1.a;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24259a = h.b(new byte[]{69, 80, 102, 71, 100, 72, 81, 92, 90, 95, 122, 80, 96, 96, 114, 126, 97, 72, 77, 84, 83, 97, 97, 93, 91, 97, 80, 71, 115, 88, 66, 84, 80, 124, 16, 107, 98, 97, 103, 0, 77, 95, 123, 89, 40, 99, 112, 64, 90, 47, 89, 90, 20, 95, 94, 47, 75, 125, 116, 120, 57, 82, 41, 65, 68, 125, 89, 93, 103, 70, 79, 119, 58, 84, 92, 104, 78, 90, 101, 100, 101, 0, 108, 67, 109, 99, 85, 4, 24, 67, 111, 125, 80, 74, 70, 79, 113, 100, 83, 97, 78, 65, 123, 114, 122, 92, 76, 123, 56, 84, 122, 114, 65, 86, 71, 32, 118, 123, 109, 90, 73, 97, 84, 113, 97, 72, 53, 43});

    /* renamed from: b  reason: collision with root package name */
    private static final String f24260b = h.b(new byte[]{68, 66, 113, 15, 87, 103, 120, 116, 31, 112, 82, 75, 69, 32, 96, 65, 125, 108, Byte.MAX_VALUE, Byte.MAX_VALUE, 87});

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String b10 = b();
            a.a("RsaUitl", "decodeRsaPubKey " + b10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RSA_MODE ");
            String str2 = f24260b;
            sb2.append(str2);
            a.a("RsaUitl", sb2.toString());
            return e(str, b(), str2);
        } catch (Throwable th) {
            a.a("RsaUitl", "deRsa " + th.getMessage());
            return "";
        }
    }

    private static String b() {
        try {
            return f24259a;
        } catch (Throwable th) {
            a.a("RsaUitl", "decodeRsaPubKey " + th.getMessage());
            return "";
        }
    }

    private static RSAPublicKey c(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            a.a("RsaUitl", "rsa loadRSAKey e=" + th);
            return null;
        }
    }

    private static synchronized byte[] d(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] decode;
        synchronized (k.class) {
            byte[] decode2 = Base64.decode(str, 2);
            Cipher instance = Cipher.getInstance(str2);
            instance.init(2, rSAPublicKey);
            decode = Base64.decode(instance.doFinal(decode2), 2);
        }
        return decode;
    }

    private static String e(String str, String str2, String str3) {
        return new String(Base64.encode(d(str, c(str2), str3), 2), "UTF-8");
    }
}
