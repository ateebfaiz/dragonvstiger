package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.text.j;

class n extends m {
    public static int A(Object[] objArr) {
        m.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Integer B(int[] iArr, int i10) {
        m.f(iArr, "<this>");
        if (i10 < 0 || i10 > j.z(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static Object C(Object[] objArr, int i10) {
        m.f(objArr, "<this>");
        if (i10 < 0 || i10 > j.A(objArr)) {
            return null;
        }
        return objArr[i10];
    }

    public static final int D(char[] cArr, char c10) {
        m.f(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int E(Object[] objArr, Object obj) {
        m.f(objArr, "<this>");
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (m.b(obj, objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final Appendable F(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(bArr, "<this>");
        m.f(appendable, "buffer");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                appendable.append((CharSequence) function1.invoke(Byte.valueOf(b10)));
            } else {
                appendable.append(String.valueOf(b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final Appendable G(int[] iArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(iArr, "<this>");
        m.f(appendable, "buffer");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (function1 != null) {
                appendable.append((CharSequence) function1.invoke(Integer.valueOf(i12)));
            } else {
                appendable.append(String.valueOf(i12));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final Appendable H(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(objArr, "<this>");
        m.f(appendable, "buffer");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (Object obj : objArr) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            j.a(appendable, obj, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String I(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(bArr, "<this>");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        String sb2 = ((StringBuilder) F(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        m.e(sb2, "toString(...)");
        return sb2;
    }

    public static final String J(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(iArr, "<this>");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        String sb2 = ((StringBuilder) G(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        m.e(sb2, "toString(...)");
        return sb2;
    }

    public static final String K(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(objArr, "<this>");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        String sb2 = ((StringBuilder) H(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        m.e(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String L(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        CharSequence charSequence5;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return I(bArr, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static /* synthetic */ String M(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        CharSequence charSequence5;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return J(iArr, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static /* synthetic */ String N(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        CharSequence charSequence5;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return K(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static Comparable O(Comparable[] comparableArr) {
        m.f(comparableArr, "<this>");
        if (comparableArr.length == 0) {
            return null;
        }
        Comparable comparable = comparableArr[0];
        g0 e10 = new IntRange(1, j.A(comparableArr)).iterator();
        while (e10.hasNext()) {
            Comparable comparable2 = comparableArr[e10.nextInt()];
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static char P(char[] cArr) {
        m.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static Object Q(Object[] objArr) {
        m.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static byte[] R(byte[] bArr, IntRange intRange) {
        m.f(bArr, "<this>");
        m.f(intRange, "indices");
        if (intRange.isEmpty()) {
            return new byte[0];
        }
        return j.h(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final Object[] S(Object[] objArr, Comparator comparator) {
        m.f(objArr, "<this>");
        m.f(comparator, "comparator");
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        m.e(copyOf, "copyOf(...)");
        j.q(copyOf, comparator);
        return copyOf;
    }

    public static List T(Object[] objArr, Comparator comparator) {
        m.f(objArr, "<this>");
        m.f(comparator, "comparator");
        return j.c(S(objArr, comparator));
    }

    public static final Collection U(Object[] objArr, Collection collection) {
        m.f(objArr, "<this>");
        m.f(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object add : objArr) {
            collection.add(add);
        }
        return collection;
    }

    public static HashSet V(Object[] objArr) {
        m.f(objArr, "<this>");
        return (HashSet) U(objArr, new HashSet(i0.c(objArr.length)));
    }

    public static List W(Object[] objArr) {
        m.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return r.l();
        }
        if (length != 1) {
            return j.X(objArr);
        }
        return r.e(objArr[0]);
    }

    public static List X(Object[] objArr) {
        m.f(objArr, "<this>");
        return new ArrayList(t.h(objArr));
    }

    public static final Set Y(Object[] objArr) {
        m.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return r0.d();
        }
        if (length != 1) {
            return (Set) U(objArr, new LinkedHashSet(i0.c(objArr.length)));
        }
        return r0.c(objArr[0]);
    }

    public static boolean r(char[] cArr, char c10) {
        m.f(cArr, "<this>");
        if (D(cArr, c10) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean s(Object[] objArr, Object obj) {
        m.f(objArr, "<this>");
        if (E(objArr, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static List t(Object[] objArr) {
        m.f(objArr, "<this>");
        return (List) u(objArr, new ArrayList());
    }

    public static final Collection u(Object[] objArr, Collection collection) {
        m.f(objArr, "<this>");
        m.f(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object v(Object[] objArr) {
        m.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static IntRange w(byte[] bArr) {
        m.f(bArr, "<this>");
        return new IntRange(0, y(bArr));
    }

    public static IntRange x(Object[] objArr) {
        m.f(objArr, "<this>");
        return new IntRange(0, j.A(objArr));
    }

    public static final int y(byte[] bArr) {
        m.f(bArr, "<this>");
        return bArr.length - 1;
    }

    public static int z(int[] iArr) {
        m.f(iArr, "<this>");
        return iArr.length - 1;
    }
}
