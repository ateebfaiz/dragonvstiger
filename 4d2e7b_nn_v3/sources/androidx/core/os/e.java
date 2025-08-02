package androidx.core.os;

import androidx.annotation.DoNotInline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

final class e implements f {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f15044c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f15045d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f15046e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f15047f = LocaleListCompat.forLanguageTagCompat("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f15048a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15049b;

    static class a {
        @DoNotInline
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    e(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f15048a = f15044c;
            this.f15049b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 < localeArr.length) {
            Locale locale = localeArr[i10];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    k(sb2, locale2);
                    if (i10 < localeArr.length - 1) {
                        sb2.append(',');
                    }
                    hashSet.add(locale2);
                }
                i10++;
            } else {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
        }
        this.f15048a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f15049b = sb2.toString();
    }

    private Locale e(Collection collection, boolean z10) {
        int f10 = f(collection, z10);
        if (f10 == -1) {
            return null;
        }
        return this.f15048a[f10];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r6 < Integer.MAX_VALUE) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int f(java.util.Collection r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.f15048a
            int r1 = r0.length
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x0008
            return r3
        L_0x0008:
            int r0 = r0.length
            if (r0 != 0) goto L_0x000d
            r5 = -1
            return r5
        L_0x000d:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L_0x001e
            java.util.Locale r6 = f15047f
            int r6 = r4.g(r6)
            if (r6 != 0) goto L_0x001b
            return r3
        L_0x001b:
            if (r6 >= r0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r6 = r0
        L_0x001f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0023:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.os.LocaleListCompat.forLanguageTagCompat(r1)
            int r1 = r4.g(r1)
            if (r1 != 0) goto L_0x003a
            return r3
        L_0x003a:
            if (r1 >= r6) goto L_0x0023
            r6 = r1
            goto L_0x0023
        L_0x003e:
            if (r6 != r0) goto L_0x0041
            return r3
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.e.f(java.util.Collection, boolean):int");
    }

    private int g(Locale locale) {
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f15048a;
            if (i10 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (j(locale, localeArr[i10]) > 0) {
                return i10;
            }
            i10++;
        }
    }

    private static String h(Locale locale) {
        String a10 = a.a(locale);
        if (!a10.isEmpty()) {
            return a10;
        }
        return "";
    }

    private static boolean i(Locale locale) {
        if (f15045d.equals(locale) || f15046e.equals(locale)) {
            return true;
        }
        return false;
    }

    private static int j(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || i(locale) || i(locale2)) {
            return 0;
        }
        String h10 = h(locale);
        if (!h10.isEmpty()) {
            return h10.equals(h(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        if (country.isEmpty() || country.equals(locale2.getCountry())) {
            return 1;
        }
        return 0;
    }

    static void k(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb2.append('-');
            sb2.append(locale.getCountry());
        }
    }

    public int a(Locale locale) {
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f15048a;
            if (i10 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i10].equals(locale)) {
                return i10;
            }
            i10++;
        }
    }

    public String b() {
        return this.f15049b;
    }

    public Object c() {
        return null;
    }

    public Locale d(String[] strArr) {
        return e(Arrays.asList(strArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        Locale[] localeArr = ((e) obj).f15048a;
        if (this.f15048a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f15048a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f15048a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 1;
        for (Locale hashCode : this.f15048a) {
            i10 = (i10 * 31) + hashCode.hashCode();
        }
        return i10;
    }

    public boolean isEmpty() {
        if (this.f15048a.length == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.f15048a.length;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f15048a;
            if (i10 < localeArr.length) {
                sb2.append(localeArr[i10]);
                if (i10 < this.f15048a.length - 1) {
                    sb2.append(',');
                }
                i10++;
            } else {
                sb2.append("]");
                return sb2.toString();
            }
        }
    }
}
