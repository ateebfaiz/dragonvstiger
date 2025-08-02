package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.TimeZone;

@Retention(RetentionPolicy.RUNTIME)
public @interface i {

    public enum a {
        ACCEPT_SINGLE_VALUE_AS_ARRAY,
        ACCEPT_CASE_INSENSITIVE_PROPERTIES,
        ACCEPT_CASE_INSENSITIVE_VALUES,
        WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
        WRITE_DATES_WITH_ZONE_ID,
        WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,
        WRITE_SORTED_MAP_ENTRIES,
        ADJUST_DATES_TO_CONTEXT_TIME_ZONE
    }

    public static class b {

        /* renamed from: c  reason: collision with root package name */
        private static final b f4994c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        private final int f4995a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4996b;

        private b(int i10, int i11) {
            this.f4995a = i10;
            this.f4996b = i11;
        }

        public static b a(i iVar) {
            return b(iVar.with(), iVar.without());
        }

        public static b b(a[] aVarArr, a[] aVarArr2) {
            int i10 = 0;
            for (a ordinal : aVarArr) {
                i10 |= 1 << ordinal.ordinal();
            }
            int i11 = 0;
            for (a ordinal2 : aVarArr2) {
                i11 |= 1 << ordinal2.ordinal();
            }
            return new b(i10, i11);
        }

        public static b c() {
            return f4994c;
        }

        public Boolean d(a aVar) {
            int ordinal = 1 << aVar.ordinal();
            if ((this.f4996b & ordinal) != 0) {
                return Boolean.FALSE;
            }
            if ((ordinal & this.f4995a) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public b e(b bVar) {
            if (bVar == null) {
                return this;
            }
            int i10 = bVar.f4996b;
            int i11 = bVar.f4995a;
            if (i10 == 0 && i11 == 0) {
                return this;
            }
            int i12 = this.f4995a;
            if (i12 == 0 && this.f4996b == 0) {
                return bVar;
            }
            int i13 = ((~i10) & i12) | i11;
            int i14 = this.f4996b;
            int i15 = i10 | ((~i11) & i14);
            if (i13 == i12 && i15 == i14) {
                return this;
            }
            return new b(i13, i15);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.f4995a == this.f4995a && bVar.f4996b == this.f4996b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f4996b + this.f4995a;
        }

        public String toString() {
            if (this == f4994c) {
                return "EMPTY";
            }
            return String.format("(enabled=0x%x,disabled=0x%x)", new Object[]{Integer.valueOf(this.f4995a), Integer.valueOf(this.f4996b)});
        }
    }

    public enum c {
        ANY,
        NATURAL,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN,
        BINARY;

        public boolean a() {
            if (this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT) {
                return true;
            }
            return false;
        }
    }

    public static class d implements Serializable {

        /* renamed from: h  reason: collision with root package name */
        private static final d f5008h = new d();

        /* renamed from: a  reason: collision with root package name */
        private final String f5009a;

        /* renamed from: b  reason: collision with root package name */
        private final c f5010b;

        /* renamed from: c  reason: collision with root package name */
        private final Locale f5011c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5012d;

        /* renamed from: e  reason: collision with root package name */
        private final Boolean f5013e;

        /* renamed from: f  reason: collision with root package name */
        private final b f5014f;

        /* renamed from: g  reason: collision with root package name */
        private transient TimeZone f5015g;

        public d() {
            this("", c.ANY, "", "", b.c(), (Boolean) null);
        }

        private static boolean a(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            } else if (obj2 == null) {
                return false;
            } else {
                return obj.equals(obj2);
            }
        }

        public static final d b() {
            return f5008h;
        }

        public static d c(boolean z10) {
            return new d("", (c) null, (Locale) null, (String) null, (TimeZone) null, b.c(), Boolean.valueOf(z10));
        }

        public static final d d(i iVar) {
            if (iVar == null) {
                return f5008h;
            }
            return new d(iVar);
        }

        public static d p(d dVar, d dVar2) {
            if (dVar == null) {
                return dVar2;
            }
            return dVar.s(dVar2);
        }

        public Boolean e(a aVar) {
            return this.f5014f.d(aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f5010b != dVar.f5010b || !this.f5014f.equals(dVar.f5014f)) {
                return false;
            }
            if (!a(this.f5013e, dVar.f5013e) || !a(this.f5012d, dVar.f5012d) || !a(this.f5009a, dVar.f5009a) || !a(this.f5015g, dVar.f5015g) || !a(this.f5011c, dVar.f5011c)) {
                return false;
            }
            return true;
        }

        public Locale f() {
            return this.f5011c;
        }

        public String h() {
            return this.f5009a;
        }

        public int hashCode() {
            int i10;
            String str = this.f5012d;
            if (str == null) {
                i10 = 1;
            } else {
                i10 = str.hashCode();
            }
            String str2 = this.f5009a;
            if (str2 != null) {
                i10 ^= str2.hashCode();
            }
            int hashCode = i10 + this.f5010b.hashCode();
            Boolean bool = this.f5013e;
            if (bool != null) {
                hashCode ^= bool.hashCode();
            }
            Locale locale = this.f5011c;
            if (locale != null) {
                hashCode += locale.hashCode();
            }
            return hashCode ^ this.f5014f.hashCode();
        }

        public c i() {
            return this.f5010b;
        }

        public TimeZone j() {
            TimeZone timeZone = this.f5015g;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this.f5012d;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.f5015g = timeZone2;
            return timeZone2;
        }

        public boolean k() {
            if (this.f5013e != null) {
                return true;
            }
            return false;
        }

        public boolean l() {
            if (this.f5011c != null) {
                return true;
            }
            return false;
        }

        public boolean m() {
            String str = this.f5009a;
            if (str == null || str.length() <= 0) {
                return false;
            }
            return true;
        }

        public boolean n() {
            if (this.f5010b != c.ANY) {
                return true;
            }
            return false;
        }

        public boolean o() {
            String str;
            if (this.f5015g != null || ((str = this.f5012d) != null && !str.isEmpty())) {
                return true;
            }
            return false;
        }

        public d q(Boolean bool) {
            if (bool == this.f5013e) {
                return this;
            }
            return new d(this.f5009a, this.f5010b, this.f5011c, this.f5012d, this.f5015g, this.f5014f, bool);
        }

        public final d s(d dVar) {
            d dVar2;
            b e10;
            TimeZone timeZone;
            String str;
            if (dVar == null || dVar == (dVar2 = f5008h) || dVar == this) {
                return this;
            }
            if (this == dVar2) {
                return dVar;
            }
            String str2 = dVar.f5009a;
            if (str2 == null || str2.isEmpty()) {
                str2 = this.f5009a;
            }
            String str3 = str2;
            c cVar = dVar.f5010b;
            if (cVar == c.ANY) {
                cVar = this.f5010b;
            }
            c cVar2 = cVar;
            Locale locale = dVar.f5011c;
            if (locale == null) {
                locale = this.f5011c;
            }
            Locale locale2 = locale;
            b bVar = this.f5014f;
            if (bVar == null) {
                e10 = dVar.f5014f;
            } else {
                e10 = bVar.e(dVar.f5014f);
            }
            b bVar2 = e10;
            Boolean bool = dVar.f5013e;
            if (bool == null) {
                bool = this.f5013e;
            }
            Boolean bool2 = bool;
            String str4 = dVar.f5012d;
            if (str4 == null || str4.isEmpty()) {
                str = this.f5012d;
                timeZone = this.f5015g;
            } else {
                timeZone = dVar.f5015g;
                str = str4;
            }
            return new d(str3, cVar2, locale2, str, timeZone, bVar2, bool2);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", new Object[]{this.f5009a, this.f5010b, this.f5013e, this.f5011c, this.f5012d, this.f5014f});
        }

        public d(i iVar) {
            this(iVar.pattern(), iVar.shape(), iVar.locale(), iVar.timezone(), b.a(iVar), iVar.lenient().a());
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(java.lang.String r14, com.fasterxml.jackson.annotation.i.c r15, java.lang.String r16, java.lang.String r17, com.fasterxml.jackson.annotation.i.b r18, java.lang.Boolean r19) {
            /*
                r13 = this;
                r0 = r16
                r1 = r17
                r2 = 0
                java.lang.String r3 = "##default"
                if (r0 == 0) goto L_0x001d
                int r4 = r16.length()
                if (r4 == 0) goto L_0x001d
                boolean r4 = r3.equals(r0)
                if (r4 == 0) goto L_0x0016
                goto L_0x001d
            L_0x0016:
                java.util.Locale r4 = new java.util.Locale
                r4.<init>(r0)
                r8 = r4
                goto L_0x001e
            L_0x001d:
                r8 = r2
            L_0x001e:
                if (r1 == 0) goto L_0x002f
                int r0 = r17.length()
                if (r0 == 0) goto L_0x002f
                boolean r0 = r3.equals(r1)
                if (r0 == 0) goto L_0x002d
                goto L_0x002f
            L_0x002d:
                r9 = r1
                goto L_0x0030
            L_0x002f:
                r9 = r2
            L_0x0030:
                r10 = 0
                r5 = r13
                r6 = r14
                r7 = r15
                r11 = r18
                r12 = r19
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.annotation.i.d.<init>(java.lang.String, com.fasterxml.jackson.annotation.i$c, java.lang.String, java.lang.String, com.fasterxml.jackson.annotation.i$b, java.lang.Boolean):void");
        }

        public d(String str, c cVar, Locale locale, String str2, TimeZone timeZone, b bVar, Boolean bool) {
            this.f5009a = str == null ? "" : str;
            this.f5010b = cVar == null ? c.ANY : cVar;
            this.f5011c = locale;
            this.f5015g = timeZone;
            this.f5012d = str2;
            this.f5014f = bVar == null ? b.c() : bVar;
            this.f5013e = bool;
        }
    }

    m0 lenient() default m0.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    c shape() default c.ANY;

    String timezone() default "##default";

    a[] with() default {};

    a[] without() default {};
}
