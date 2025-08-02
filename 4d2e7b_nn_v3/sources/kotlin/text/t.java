package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.g0;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.IntRange;
import kotlin.ranges.g;
import kotlin.ranges.l;
import kotlin.sequences.Sequence;
import kotlin.sequences.h;

class t extends s {

    static final class a extends n implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char[] f827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f828b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z10) {
            super(2);
            this.f827a = cArr;
            this.f828b = z10;
        }

        public final Pair<Integer, Integer> a(CharSequence charSequence, int i10) {
            m.f(charSequence, "$this$$receiver");
            int W = t.W(charSequence, this.f827a, i10, this.f828b);
            if (W < 0) {
                return null;
            }
            return kotlin.t.a(Integer.valueOf(W), 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class b extends n implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f829a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f830b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list, boolean z10) {
            super(2);
            this.f829a = list;
            this.f830b = z10;
        }

        public final Pair<Integer, Integer> a(CharSequence charSequence, int i10) {
            m.f(charSequence, "$this$$receiver");
            Pair G = t.N(charSequence, this.f829a, i10, this.f830b, false);
            if (G != null) {
                return kotlin.t.a(G.c(), Integer.valueOf(((String) G.d()).length()));
            }
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class c extends n implements Function1<IntRange, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f831a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f831a = charSequence;
        }

        /* renamed from: a */
        public final String invoke(IntRange intRange) {
            m.f(intRange, "it");
            return t.C0(this.f831a, intRange);
        }
    }

    static final class d extends n implements Function1<IntRange, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f832a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence) {
            super(1);
            this.f832a = charSequence;
        }

        /* renamed from: a */
        public final String invoke(IntRange intRange) {
            m.f(intRange, "it");
            return t.C0(this.f832a, intRange);
        }
    }

    public static final boolean A0(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "prefix");
        if (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return j.F((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return k0(charSequence, 0, charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ boolean B0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return A0(charSequence, charSequence2, z10);
    }

    public static final String C0(CharSequence charSequence, IntRange intRange) {
        m.f(charSequence, "<this>");
        m.f(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static final String D0(String str, char c10, String str2) {
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        int U = j.U(str, c10, 0, false, 6, (Object) null);
        if (U == -1) {
            return str2;
        }
        String substring = str.substring(U + 1, str.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static final String E0(String str, String str2, String str3) {
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        int V = j.V(str, str2, 0, false, 6, (Object) null);
        if (V == -1) {
            return str3;
        }
        String substring = str.substring(V + str2.length(), str.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String F0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return D0(str, c10, str2);
    }

    public static /* synthetic */ String G0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return E0(str, str2, str3);
    }

    public static final boolean H(CharSequence charSequence, char c10, boolean z10) {
        m.f(charSequence, "<this>");
        if (j.U(charSequence, c10, 0, z10, 2, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static final String H0(String str, char c10, String str2) {
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        int Z = j.Z(str, c10, 0, false, 6, (Object) null);
        if (Z == -1) {
            return str2;
        }
        String substring = str.substring(Z + 1, str.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (j.V(charSequence, (String) charSequence2, 0, z10, 2, (Object) null) < 0) {
                return false;
            }
        } else {
            if (T(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, (Object) null) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String I0(String str, String str2, String str3) {
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        int a02 = j.a0(str, str2, 0, false, 6, (Object) null);
        if (a02 == -1) {
            return str3;
        }
        String substring = str.substring(a02 + str2.length(), str.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ boolean J(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return H(charSequence, c10, z10);
    }

    public static /* synthetic */ String J0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return H0(str, c10, str2);
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return j.I(charSequence, charSequence2, z10);
    }

    public static final String K0(String str, char c10, String str2) {
        m.f(str, "<this>");
        m.f(str2, "missingDelimiterValue");
        int U = j.U(str, c10, 0, false, 6, (Object) null);
        if (U == -1) {
            return str2;
        }
        String substring = str.substring(0, U);
        m.e(substring, "substring(...)");
        return substring;
    }

    public static final boolean L(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "suffix");
        if (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return j.p((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return k0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z10);
    }

    public static String L0(String str, String str2, String str3) {
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        int V = j.V(str, str2, 0, false, 6, (Object) null);
        if (V == -1) {
            return str3;
        }
        String substring = str.substring(0, V);
        m.e(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return L(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String M0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return K0(str, c10, str2);
    }

    /* access modifiers changed from: private */
    public static final Pair N(CharSequence charSequence, Collection collection, int i10, boolean z10, boolean z11) {
        g gVar;
        Object obj;
        Object obj2;
        int i11;
        if (z10 || collection.size() != 1) {
            if (!z11) {
                gVar = new IntRange(l.c(i10, 0), charSequence.length());
            } else {
                gVar = l.i(l.f(i10, P(charSequence)), 0);
            }
            if (charSequence instanceof String) {
                int a10 = gVar.a();
                int c10 = gVar.c();
                int d10 = gVar.d();
                if ((d10 > 0 && a10 <= c10) || (d10 < 0 && c10 <= a10)) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (s.t(str, 0, (String) charSequence, a10, str.length(), z10)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (a10 == c10) {
                                break;
                            }
                            a10 += d10;
                        } else {
                            return kotlin.t.a(Integer.valueOf(a10), str2);
                        }
                    }
                }
            } else {
                int a11 = gVar.a();
                int c11 = gVar.c();
                int d11 = gVar.d();
                if ((d11 > 0 && a11 <= c11) || (d11 < 0 && c11 <= a11)) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (k0(str3, 0, charSequence, a11, str3.length(), z10)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (a11 == c11) {
                                break;
                            }
                            a11 += d11;
                        } else {
                            return kotlin.t.a(Integer.valueOf(a11), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) r.n0(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i12 = i10;
        if (!z11) {
            i11 = j.V(charSequence2, str6, i12, false, 4, (Object) null);
        } else {
            i11 = j.a0(charSequence2, str6, i12, false, 4, (Object) null);
        }
        if (i11 < 0) {
            return null;
        }
        return kotlin.t.a(Integer.valueOf(i11), str5);
    }

    public static final String N0(String str, String str2, String str3) {
        m.f(str, "<this>");
        m.f(str2, "delimiter");
        m.f(str3, "missingDelimiterValue");
        int a02 = j.a0(str, str2, 0, false, 6, (Object) null);
        if (a02 == -1) {
            return str3;
        }
        String substring = str.substring(0, a02);
        m.e(substring, "substring(...)");
        return substring;
    }

    public static final IntRange O(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static /* synthetic */ String O0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return N0(str, str2, str3);
    }

    public static final int P(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static CharSequence P0(CharSequence charSequence) {
        int i10;
        m.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            if (!z10) {
                i10 = i11;
            } else {
                i10 = length;
            }
            boolean c10 = a.c(charSequence.charAt(i10));
            if (!z10) {
                if (!c10) {
                    z10 = true;
                } else {
                    i11++;
                }
            } else if (!c10) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static final int Q(CharSequence charSequence, char c10, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        return W(charSequence, new char[]{c10}, i10, z10);
    }

    public static String Q0(String str, char... cArr) {
        Object obj;
        m.f(str, "<this>");
        m.f(cArr, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!j.r(cArr, str.charAt(length))) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i10 < 0) {
                    break;
                } else {
                    length = i10;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    public static final int R(CharSequence charSequence, String str, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(str, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i10);
        }
        return T(charSequence, str, i10, charSequence.length(), z10, false, 16, (Object) null);
    }

    private static final int S(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        g gVar;
        if (!z11) {
            gVar = new IntRange(l.c(i10, 0), l.f(i11, charSequence.length()));
        } else {
            gVar = l.i(l.f(i10, P(charSequence)), l.c(i11, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a10 = gVar.a();
            int c10 = gVar.c();
            int d10 = gVar.d();
            if ((d10 <= 0 || a10 > c10) && (d10 >= 0 || c10 > a10)) {
                return -1;
            }
            while (true) {
                if (k0(charSequence2, 0, charSequence, a10, charSequence2.length(), z10)) {
                    return a10;
                }
                if (a10 == c10) {
                    return -1;
                }
                a10 += d10;
            }
        } else {
            int a11 = gVar.a();
            int c11 = gVar.c();
            int d11 = gVar.d();
            if ((d11 <= 0 || a11 > c11) && (d11 >= 0 || c11 > a11)) {
                return -1;
            }
            while (true) {
                if (s.t((String) charSequence2, 0, (String) charSequence, a11, charSequence2.length(), z10)) {
                    return a11;
                }
                if (a11 == c11) {
                    return -1;
                }
                a11 += d11;
            }
        }
    }

    static /* synthetic */ int T(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return S(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static /* synthetic */ int U(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Q(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int V(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return R(charSequence, str, i10, z10);
    }

    public static final int W(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(cArr, "chars");
        if (z10 || cArr.length != 1 || !(charSequence instanceof String)) {
            g0 e10 = new IntRange(l.c(i10, 0), P(charSequence)).iterator();
            while (e10.hasNext()) {
                int nextInt = e10.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length) {
                        if (c.e(cArr[i11], charAt, z10)) {
                            return nextInt;
                        }
                        i11++;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(j.P(cArr), i10);
    }

    public static final int X(CharSequence charSequence, char c10, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c10, i10);
        }
        return b0(charSequence, new char[]{c10}, i10, z10);
    }

    public static final int Y(CharSequence charSequence, String str, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(str, "string");
        if (z10 || !(charSequence instanceof String)) {
            return S(charSequence, str, i10, 0, z10, true);
        }
        return ((String) charSequence).lastIndexOf(str, i10);
    }

    public static /* synthetic */ int Z(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = P(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return X(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = P(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Y(charSequence, str, i10, z10);
    }

    public static final int b0(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(cArr, "chars");
        if (z10 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int f10 = l.f(i10, P(charSequence)); -1 < f10; f10--) {
                char charAt = charSequence.charAt(f10);
                for (char e10 : cArr) {
                    if (c.e(e10, charAt, z10)) {
                        return f10;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(j.P(cArr), i10);
    }

    public static final Sequence c0(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return z0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List d0(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        return h.u(c0(charSequence));
    }

    public static final CharSequence e0(CharSequence charSequence, int i10, char c10) {
        m.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        } else if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i10);
            g0 e10 = new IntRange(1, i10 - charSequence.length()).iterator();
            while (e10.hasNext()) {
                e10.nextInt();
                sb2.append(c10);
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    public static String f0(String str, int i10, char c10) {
        m.f(str, "<this>");
        return e0(str, i10, c10).toString();
    }

    private static final Sequence g0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11) {
        q0(i11);
        return new e(charSequence, i10, i11, new a(cArr, z10));
    }

    private static final Sequence h0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        q0(i11);
        return new e(charSequence, i10, i11, new b(j.c(strArr), z10));
    }

    static /* synthetic */ Sequence i0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return g0(charSequence, cArr, i10, z10, i11);
    }

    static /* synthetic */ Sequence j0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return h0(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean k0(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!c.e(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String l0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "prefix");
        if (!B0(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static String m0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "suffix");
        if (!M(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static String n0(String str, CharSequence charSequence) {
        m.f(str, "<this>");
        m.f(charSequence, "delimiter");
        return o0(str, charSequence, charSequence);
    }

    public static final String o0(String str, CharSequence charSequence, CharSequence charSequence2) {
        m.f(str, "<this>");
        m.f(charSequence, "prefix");
        m.f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !B0(str, charSequence, false, 2, (Object) null) || !M(str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        m.e(substring, "substring(...)");
        return substring;
    }

    public static final CharSequence p0(CharSequence charSequence, int i10, int i11, CharSequence charSequence2) {
        m.f(charSequence, "<this>");
        m.f(charSequence2, "replacement");
        if (i11 >= i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i10);
            m.e(sb2, "append(...)");
            sb2.append(charSequence2);
            sb2.append(charSequence, i11, charSequence.length());
            m.e(sb2, "append(...)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    public static final void q0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
        }
    }

    public static final List r0(CharSequence charSequence, char[] cArr, boolean z10, int i10) {
        m.f(charSequence, "<this>");
        m.f(cArr, "delimiters");
        if (cArr.length == 1) {
            return t0(charSequence, String.valueOf(cArr[0]), z10, i10);
        }
        Iterable<IntRange> h10 = h.h(i0(charSequence, cArr, 0, z10, i10, 2, (Object) null));
        ArrayList arrayList = new ArrayList(r.v(h10, 10));
        for (IntRange C0 : h10) {
            arrayList.add(C0(charSequence, C0));
        }
        return arrayList;
    }

    public static final List s0(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        m.f(charSequence, "<this>");
        m.f(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return t0(charSequence, str, z10, i10);
            }
        }
        Iterable<IntRange> h10 = h.h(j0(charSequence, strArr, 0, z10, i10, 2, (Object) null));
        ArrayList arrayList = new ArrayList(r.v(h10, 10));
        for (IntRange C0 : h10) {
            arrayList.add(C0(charSequence, C0));
        }
        return arrayList;
    }

    private static final List t0(CharSequence charSequence, String str, boolean z10, int i10) {
        boolean z11;
        q0(i10);
        int i11 = 0;
        int R = R(charSequence, str, 0, z10);
        if (R == -1 || i10 == 1) {
            return r.e(charSequence.toString());
        }
        if (i10 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = 10;
        if (z11) {
            i12 = l.f(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i12);
        do {
            arrayList.add(charSequence.subSequence(i11, R).toString());
            i11 = str.length() + R;
            if ((z11 && arrayList.size() == i10 - 1) || (R = R(charSequence, str, i11, z10)) == -1) {
                arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i11, R).toString());
            i11 = str.length() + R;
            break;
        } while ((R = R(charSequence, str, i11, z10)) == -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List u0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return r0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List v0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return s0(charSequence, strArr, z10, i10);
    }

    public static final Sequence w0(CharSequence charSequence, char[] cArr, boolean z10, int i10) {
        m.f(charSequence, "<this>");
        m.f(cArr, "delimiters");
        return h.q(i0(charSequence, cArr, 0, z10, i10, 2, (Object) null), new d(charSequence));
    }

    public static final Sequence x0(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        m.f(charSequence, "<this>");
        m.f(strArr, "delimiters");
        return h.q(j0(charSequence, strArr, 0, z10, i10, 2, (Object) null), new c(charSequence));
    }

    public static /* synthetic */ Sequence y0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return w0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ Sequence z0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return x0(charSequence, strArr, z10, i10);
    }
}
