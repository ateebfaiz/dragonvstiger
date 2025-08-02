package g1;

import android.text.TextUtils;
import o1.a;
import w1.b;

public abstract class d {
    public static byte[] a(byte b10, String str, String str2) {
        byte[] bArr;
        int i10;
        try {
            byte[] bytes = str.getBytes(a.f22951b);
            if (!TextUtils.isEmpty(str2)) {
                bArr = str2.getBytes(a.f22951b);
            } else {
                bArr = null;
            }
            if (bArr == null || bArr.length <= 0) {
                i10 = bytes.length + 1;
            } else {
                i10 = bytes.length + 1 + bArr.length;
            }
            b bVar = new b(i10);
            bVar.g(bytes);
            bVar.l(b10);
            if (bArr != null && bArr.length > 0) {
                bVar.g(bArr);
            }
            return bVar.d();
        } catch (Throwable th) {
            s1.a.h("MTPushProtocol", "packagePlatformTokenBody failed " + th.getMessage());
            return null;
        }
    }

    public static byte[] b(int i10, long j10) {
        b bVar = new b(11);
        bVar.h(0);
        bVar.l((byte) i10);
        bVar.k(j10);
        return bVar.d();
    }

    public static byte[] c(String str) {
        try {
            byte[] bytes = str.getBytes(a.f22951b);
            b bVar = new b(bytes.length + 2);
            bVar.l(7);
            bVar.l(1);
            bVar.g(bytes);
            return bVar.d();
        } catch (Throwable th) {
            s1.a.h("MTPushProtocol", "packageMobileNumberBody failed " + th.getMessage());
            return null;
        }
    }

    public static byte[] d(String str) {
        try {
            byte[] bytes = str.getBytes(a.f22951b);
            b bVar = new b(bytes.length);
            bVar.g(bytes);
            return bVar.d();
        } catch (Throwable th) {
            s1.a.h("MTPushProtocol", "packageAliasRequest failed " + th.getMessage());
            return null;
        }
    }
}
