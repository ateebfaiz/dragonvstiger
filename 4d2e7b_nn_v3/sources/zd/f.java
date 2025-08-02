package zd;

import java.security.AccessController;
import java.security.PrivilegedAction;
import okio.Utf8;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f2247a;

    static class a implements PrivilegedAction {
        a() {
        }

        /* renamed from: a */
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            f2247a = (String) AccessController.doPrivileged(new a());
        } catch (Exception unused) {
            try {
                f2247a = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                f2247a = "\n";
            }
        }
    }

    public static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    public static String c(byte[] bArr) {
        char c10;
        int i10;
        byte b10;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i13 + 1;
            byte b11 = bArr[i12];
            if ((b11 & 240) == 240) {
                i13 += 2;
                i12 += 4;
            } else {
                if ((b11 & 224) == 224) {
                    i12 += 3;
                } else if ((b11 & 192) == 192) {
                    i12 += 2;
                } else {
                    i12++;
                }
                i13 = i14;
            }
        }
        char[] cArr = new char[i13];
        int i15 = 0;
        while (i11 < bArr.length) {
            byte b12 = bArr[i11];
            if ((b12 & 240) == 240) {
                int i16 = (((((b12 & 3) << 18) | ((bArr[i11 + 1] & Utf8.REPLACEMENT_BYTE) << 12)) | ((bArr[i11 + 2] & Utf8.REPLACEMENT_BYTE) << 6)) | (bArr[i11 + 3] & Utf8.REPLACEMENT_BYTE)) - 65536;
                c10 = (char) ((i16 & 1023) | Utf8.LOG_SURROGATE_HEADER);
                cArr[i15] = (char) ((i16 >> 10) | 55296);
                i11 += 4;
                i15++;
            } else if ((b12 & 224) == 224) {
                c10 = (char) (((b12 & 15) << 12) | ((bArr[i11 + 1] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i11 + 2] & Utf8.REPLACEMENT_BYTE));
                i11 += 3;
            } else {
                if ((b12 & 208) == 208) {
                    i10 = (b12 & 31) << 6;
                    b10 = bArr[i11 + 1];
                } else if ((b12 & 192) == 192) {
                    i10 = (b12 & 31) << 6;
                    b10 = bArr[i11 + 1];
                } else {
                    c10 = (char) (b12 & 255);
                    i11++;
                }
                c10 = (char) (i10 | (b10 & Utf8.REPLACEMENT_BYTE));
                i11 += 2;
            }
            cArr[i15] = c10;
            i15++;
        }
        return new String(cArr);
    }

    public static String d(String str) {
        char[] charArray = str.toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 != charArray.length; i10++) {
            char c10 = charArray[i10];
            if ('A' <= c10 && 'Z' >= c10) {
                charArray[i10] = (char) (c10 + ' ');
                z10 = true;
            }
        }
        if (z10) {
            return new String(charArray);
        }
        return str;
    }

    public static String e(String str) {
        char[] charArray = str.toCharArray();
        boolean z10 = false;
        for (int i10 = 0; i10 != charArray.length; i10++) {
            char c10 = charArray[i10];
            if ('a' <= c10 && 'z' >= c10) {
                charArray[i10] = (char) (c10 - ' ');
                z10 = true;
            }
        }
        if (z10) {
            return new String(charArray);
        }
        return str;
    }
}
