package g9;

import android.util.Base64;
import java.security.SecureRandom;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final SecureRandom f12228a = new SecureRandom();

    public static String a(int i10) {
        byte[] bArr = new byte[i10];
        f12228a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    public static Object b(Object obj) {
        return "#####";
    }
}
