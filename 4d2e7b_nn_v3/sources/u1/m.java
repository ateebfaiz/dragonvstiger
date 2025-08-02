package u1;

import android.text.TextUtils;
import com.alibaba.pdns.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import o1.a;

public abstract class m {
    public static String a(String str) {
        return b(str).substring(8, 24);
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i10 = 0; i10 < charArray.length; i10++) {
                bArr[i10] = (byte) charArray[i10];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : digest) {
                byte b11 = b10 & 255;
                if (b11 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b11));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            return d(str.getBytes(a.f22951b));
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String d(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                byte b11 = b10 & 255;
                if (b11 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(b11));
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(j.f17955b).digest(str.getBytes(a.f22951b));
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                byte b11 = b10 & 255;
                if (b11 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(b11));
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return "";
        }
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, a.f22951b);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            return str.getBytes(a.f22951b);
        } catch (Throwable unused) {
            return str.getBytes();
        }
    }

    public static String h(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append("0123456789ABCDEF".charAt((b10 >> 4) & 15));
            sb2.append("0123456789ABCDEF".charAt(b10 & 15));
        }
        return sb2.toString();
    }

    public static String i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            instance.update(str.getBytes());
            return h(instance.digest());
        } catch (Throwable unused) {
            return null;
        }
    }
}
