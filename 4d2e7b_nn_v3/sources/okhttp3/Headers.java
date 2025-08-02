package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.ranges.g;
import kotlin.ranges.l;
import kotlin.t;
import kotlin.text.j;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import wb.a;

public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String[] namesAndValues;

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            m.f(str, "line");
            int U = j.U(str, ':', 0, false, 6, (Object) null);
            if (U != -1) {
                String substring = str.substring(0, U);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    String obj = j.P0(substring).toString();
                    String substring2 = str.substring(U + 1);
                    m.e(substring2, "(this as java.lang.String).substring(startIndex)");
                    add(obj, substring2);
                    return this;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }

        public final Builder addAll(Headers headers) {
            m.f(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                addLenient$okhttp(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            m.f(str, "line");
            int U = j.U(str, ':', 1, false, 4, (Object) null);
            if (U != -1) {
                String substring = str.substring(0, U);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(U + 1);
                m.e(substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (str.charAt(0) == ':') {
                String substring3 = str.substring(1);
                m.e(substring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String get(String str) {
            m.f(str, "name");
            g k10 = l.k(l.i(this.namesAndValues.size() - 2, 0), 2);
            int a10 = k10.a();
            int c10 = k10.c();
            int d10 = k10.d();
            if (d10 >= 0) {
                if (a10 > c10) {
                    return null;
                }
            } else if (a10 < c10) {
                return null;
            }
            while (!j.q(str, this.namesAndValues.get(a10), true)) {
                if (a10 == c10) {
                    return null;
                }
                a10 += d10;
            }
            return this.namesAndValues.get(a10 + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            m.f(str, "name");
            int i10 = 0;
            while (i10 < this.namesAndValues.size()) {
                if (j.q(str, this.namesAndValues.get(i10), true)) {
                    this.namesAndValues.remove(i10);
                    this.namesAndValues.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            m.f(str, "name");
            m.f(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            m.f(str, "name");
            m.f(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, Date date) {
            m.f(str, "name");
            m.f(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "value");
            this.namesAndValues.add(str);
            this.namesAndValues.add(j.P0(str2).toString());
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            m.f(str, "name");
            m.f(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void checkName(String str) {
            boolean z10;
            boolean z11;
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int length = str.length();
                int i10 = 0;
                while (i10 < length) {
                    char charAt = str.charAt(i10);
                    if ('!' <= charAt && '~' >= charAt) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i10++;
                    } else {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            boolean z10;
            String str3;
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (charAt == 9 || (' ' <= charAt && '~' >= charAt)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i10), str2));
                    if (Util.isSensitiveHeader(str2)) {
                        str3 = "";
                    } else {
                        str3 = ": " + str;
                    }
                    sb2.append(str3);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
            }
        }

        /* access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            g k10 = l.k(l.i(strArr.length - 2, 0), 2);
            int a10 = k10.a();
            int c10 = k10.c();
            int d10 = k10.d();
            if (d10 >= 0) {
                if (a10 > c10) {
                    return null;
                }
            } else if (a10 < c10) {
                return null;
            }
            while (!j.q(str, strArr[a10], true)) {
                if (a10 == c10) {
                    return null;
                }
                a10 += d10;
            }
            return strArr[a10 + 1];
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m50deprecated_of(String... strArr) {
            m.f(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            m.f(strArr, "namesAndValues");
            if (strArr.length % 2 == 0) {
                Object clone = strArr.clone();
                if (clone != null) {
                    String[] strArr2 = (String[]) clone;
                    int length = strArr2.length;
                    int i10 = 0;
                    while (i10 < length) {
                        String str = strArr2[i10];
                        if (!(str != null)) {
                            throw new IllegalArgumentException("Headers cannot be null".toString());
                        } else if (str != null) {
                            strArr2[i10] = j.P0(str).toString();
                            i10++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    g k10 = l.k(kotlin.collections.j.x(strArr2), 2);
                    int a10 = k10.a();
                    int c10 = k10.c();
                    int d10 = k10.d();
                    if (d10 < 0 ? a10 >= c10 : a10 <= c10) {
                        while (true) {
                            String str2 = strArr2[a10];
                            String str3 = strArr2[a10 + 1];
                            checkName(str2);
                            checkValue(str3, str2);
                            if (a10 == c10) {
                                break;
                            }
                            a10 += d10;
                        }
                    }
                    return new Headers(strArr2, (DefaultConstructorMarker) null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m49deprecated_of(Map<String, String> map) {
            m.f(map, "headers");
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            m.f(map, "$this$toHeaders");
            String[] strArr = new String[(map.size() * 2)];
            int i10 = 0;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (str != null) {
                    String obj = j.P0(str).toString();
                    if (str2 != null) {
                        String obj2 = j.P0(str2).toString();
                        checkName(obj);
                        checkValue(obj2, obj);
                        strArr[i10] = obj;
                        strArr[i10 + 1] = obj2;
                        i10 += 2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, (DefaultConstructorMarker) null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m48deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            length += (long) this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Headers) || !Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues)) {
            return false;
        }
        return true;
    }

    public final String get(String str) {
        m.f(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        m.f(str, "name");
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        m.f(str, "name");
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = t.a(name(i10), value(i10));
        }
        return b.a(pairArr);
    }

    public final String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(j.r(b0.f709a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        m.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        r.A(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(j.r(b0.f709a));
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            String name = name(i10);
            Locale locale = Locale.US;
            m.e(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(value(i10));
                i10++;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = name(i10);
            String value = value(i10);
            sb2.append(name);
            sb2.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb2.append(value);
            sb2.append("\n");
        }
        String sb3 = sb2.toString();
        m.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    public final List<String> values(String str) {
        m.f(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (j.q(str, name(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        if (arrayList == null) {
            return r.l();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        m.e(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
