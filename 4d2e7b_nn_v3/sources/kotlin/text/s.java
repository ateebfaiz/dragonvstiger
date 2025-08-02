package kotlin.text;

import io.jsonwebtoken.JwtParser;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.g0;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

class s extends r {
    public static final String A(String str, String str2, String str3, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "oldValue");
        m.f(str3, "newValue");
        int V = j.V(str, str2, 0, z10, 2, (Object) null);
        if (V < 0) {
            return str;
        }
        return t.p0(str, V, str2.length() + V, str3).toString();
    }

    public static /* synthetic */ String B(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return A(str, str2, str3, z10);
    }

    public static boolean C(String str, String str2, int i10, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2, i10);
        }
        return t(str, i10, str2, 0, str2.length(), z10);
    }

    public static boolean D(String str, String str2, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2);
        }
        return t(str, 0, str2, 0, str2.length(), z10);
    }

    public static /* synthetic */ boolean E(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return j.C(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean F(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return j.D(str, str2, z10);
    }

    public static String m(byte[] bArr) {
        m.f(bArr, "<this>");
        return new String(bArr, d.f797b);
    }

    public static byte[] n(String str) {
        m.f(str, "<this>");
        byte[] bytes = str.getBytes(d.f797b);
        m.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final boolean o(String str, String str2, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "suffix");
        if (!z10) {
            return str.endsWith(str2);
        }
        return t(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean p(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return o(str, str2, z10);
    }

    public static boolean q(String str, String str2, boolean z10) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z10) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static Comparator r(b0 b0Var) {
        m.f(b0Var, "<this>");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        m.e(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static boolean s(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            IntRange O = t.O(charSequence);
            if (!(O instanceof Collection) || !((Collection) O).isEmpty()) {
                Iterator it = O.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((g0) it).nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean t(String str, int i10, String str2, int i11, int i12, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "other");
        if (!z10) {
            return str.regionMatches(i10, str2, i11, i12);
        }
        return str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static /* synthetic */ boolean u(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return t(str, i10, str2, i11, i12, z10);
    }

    public static String v(CharSequence charSequence, int i10) {
        m.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + JwtParser.SEPARATOR_CHAR).toString());
        } else if (i10 == 0) {
            return "";
        } else {
            if (i10 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
                g0 e10 = new IntRange(1, i10).iterator();
                while (e10.hasNext()) {
                    e10.nextInt();
                    sb2.append(charSequence);
                }
                String sb3 = sb2.toString();
                m.c(sb3);
                return sb3;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String w(String str, char c10, char c11, boolean z10) {
        m.f(str, "<this>");
        if (!z10) {
            String replace = str.replace(c10, c11);
            m.e(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (c.e(charAt, c10, z10)) {
                charAt = c11;
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }

    public static final String x(String str, String str2, String str3, boolean z10) {
        m.f(str, "<this>");
        m.f(str2, "oldValue");
        m.f(str3, "newValue");
        int i10 = 0;
        int R = t.R(str, str2, 0, z10);
        if (R < 0) {
            return str;
        }
        int length = str2.length();
        int c10 = l.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append(str, i10, R);
                sb2.append(str3);
                i10 = R + length;
                if (R >= str.length() || (R = t.R(str, str2, R + c10, z10)) <= 0) {
                    sb2.append(str, i10, str.length());
                    String sb3 = sb2.toString();
                    m.e(sb3, "toString(...)");
                }
                sb2.append(str, i10, R);
                sb2.append(str3);
                i10 = R + length;
                break;
            } while ((R = t.R(str, str2, R + c10, z10)) <= 0);
            sb2.append(str, i10, str.length());
            String sb32 = sb2.toString();
            m.e(sb32, "toString(...)");
            return sb32;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String y(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return w(str, c10, c11, z10);
    }

    public static /* synthetic */ String z(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return x(str, str2, str3, z10);
    }
}
