package g3;

import android.util.Base64;
import com.alibaba.pdns.j;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f21686a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17956c);
            instance.update(bArr, 0, bArr.length);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }
}
