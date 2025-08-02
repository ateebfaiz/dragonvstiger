package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

class l extends k {

    static final class a extends n implements Function1<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f825a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            m.f(str, "line");
            return str;
        }
    }

    static final class b extends n implements Function1<String, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f826a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f826a = str;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            m.f(str, "line");
            return this.f826a + str;
        }
    }

    private static final Function1 b(String str) {
        if (str.length() == 0) {
            return a.f825a;
        }
        return new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (!a.c(str.charAt(i10))) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    public static final String d(String str, String str2) {
        int i10;
        String str3;
        m.f(str, "<this>");
        m.f(str2, "newIndent");
        List d02 = t.d0(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Object next : d02) {
            if (!j.s((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.v(arrayList, 10));
        for (String c10 : arrayList) {
            arrayList2.add(Integer.valueOf(c(c10)));
        }
        Integer num = (Integer) r.h0(arrayList2);
        int i11 = 0;
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        int length = str.length() + (str2.length() * d02.size());
        Function1 b10 = b(str2);
        int n10 = r.n(d02);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : d02) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                r.u();
            }
            String str4 = (String) next2;
            if ((i11 == 0 || i11 == n10) && j.s(str4)) {
                str4 = null;
            } else {
                String R0 = j.R0(str4, i10);
                if (!(R0 == null || (str3 = (String) b10.invoke(R0)) == null)) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i11 = i12;
        }
        String sb2 = ((StringBuilder) r.d0(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        m.e(sb2, "toString(...)");
        return sb2;
    }

    public static final String e(String str, String str2, String str3) {
        int i10;
        String str4;
        m.f(str, "<this>");
        m.f(str2, "newIndent");
        m.f(str3, "marginPrefix");
        if (!j.s(str3)) {
            List d02 = t.d0(str);
            int length = str.length() + (str2.length() * d02.size());
            Function1 b10 = b(str2);
            int n10 = r.n(d02);
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (Object next : d02) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    r.u();
                }
                String str5 = (String) next;
                String str6 = null;
                if ((i11 == 0 || i11 == n10) && j.s(str5)) {
                    str5 = null;
                } else {
                    int length2 = str5.length();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length2) {
                            i10 = -1;
                            break;
                        } else if (!a.c(str5.charAt(i13))) {
                            i10 = i13;
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (i10 != -1) {
                        int i14 = i10;
                        if (j.E(str5, str3, i10, false, 4, (Object) null)) {
                            m.d(str5, "null cannot be cast to non-null type java.lang.String");
                            str6 = str5.substring(i14 + str3.length());
                            m.e(str6, "substring(...)");
                        }
                    }
                    if (!(str6 == null || (str4 = (String) b10.invoke(str6)) == null)) {
                        str5 = str4;
                    }
                }
                if (str5 != null) {
                    arrayList.add(str5);
                }
                i11 = i12;
            }
            String sb2 = ((StringBuilder) r.d0(arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            m.e(sb2, "toString(...)");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        m.f(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String str2) {
        m.f(str, "<this>");
        m.f(str2, "marginPrefix");
        return e(str, "", str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
