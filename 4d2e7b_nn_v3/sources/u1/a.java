package u1;

import androidx.core.view.ViewCompat;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class a {
    private static byte[] a(byte[] bArr, String str, String str2, int i10) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(g(str, o1.a.f22951b), "AES");
        IvParameterSpec k10 = k(str2.getBytes(o1.a.f22951b));
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(i10, secretKeySpec, k10);
        return instance.doFinal(bArr);
    }

    private static byte[] b(byte[] bArr, String str, int i10) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(g(str, o1.a.f22951b), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(i10, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static byte[] c(byte[] bArr, String str) {
        return b(bArr, str, 2);
    }

    public static byte[] d(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, 2);
    }

    public static byte[] e(byte[] bArr, String str) {
        return b(bArr, str, 1);
    }

    public static byte[] f(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, 1);
    }

    private static byte[] g(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static int h() {
        return Math.abs(new SecureRandom().nextInt()) & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static String i(String str, char c10) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        for (int i10 = 0; i10 < bytes.length; i10++) {
            bytes[i10] = (byte) (bytes[i10] ^ c10);
        }
        return new String(bytes, 0, bytes.length);
    }

    public static String j(long j10) {
        long j11;
        long j12;
        switch ((int) (j10 % 10)) {
            case 1:
                j11 = 5 * j10;
                j12 = j10 % 88;
                break;
            case 2:
                j11 = 23 * j10;
                j12 = j10 % 15;
                break;
            case 3:
                j11 = 3 * j10;
                j12 = j10 % 73;
                break;
            case 4:
                j11 = 13 * j10;
                j12 = j10 % 96;
                break;
            case 5:
                j11 = 17 * j10;
                j12 = j10 % 49;
                break;
            case 6:
                j11 = 7 * j10;
                j12 = j10 % 68;
                break;
            case 7:
                j11 = 31 * j10;
                j12 = j10 % 39;
                break;
            case 8:
                j11 = 29 * j10;
                j12 = j10 % 41;
                break;
            case 9:
                j11 = 37 * j10;
                j12 = j10 % 91;
                break;
            default:
                j11 = 8 * j10;
                j12 = j10 % 74;
                break;
        }
        long j13 = j11 + j12;
        return m.b("JCKP" + j13);
    }

    private static IvParameterSpec k(byte[] bArr) {
        return (IvParameterSpec) j.c(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
    }
}
