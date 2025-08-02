package okhttp3;

import androidx.core.location.LocationRequestCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.ImagesContract;
import g0.a;
import g0.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import kotlin.text.j;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Cookie {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        private String domain;
        private long expiresAt = 253402300799999L;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path = DomExceptionUtils.SEPARATOR;
        private boolean persistent;
        private boolean secure;
        private String value;

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j10 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j10, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        public final Builder domain(String str) {
            m.f(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > 253402300799999L) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            m.f(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            m.f(str, "name");
            if (m.b(j.P0(str).toString(), str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String str) {
            m.f(str, "path");
            if (j.F(str, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            m.f(str, "value");
            if (m.b(j.P0(str).toString(), str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z10) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z10;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i10, int i11, boolean z10) {
            boolean z11;
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if ((charAt >= ' ' || charAt == 9) && charAt < 127 && (('0' > charAt || '9' < charAt) && (('a' > charAt || 'z' < charAt) && (('A' > charAt || 'Z' < charAt) && charAt != ':')))) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11 == (!z10)) {
                    return i10;
                }
                i10++;
            }
            return i11;
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (m.b(str, str2)) {
                return true;
            }
            if (!j.p(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.canParseAsIpAddress(str)) {
                return false;
            }
            return true;
        }

        private final String parseDomain(String str) {
            if (!j.p(str, f.G, false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(j.l0(str, f.G));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i10, int i11) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            String str2 = str;
            int i12 = i11;
            int dateCharacterOffset = dateCharacterOffset(str2, i10, i12, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            while (dateCharacterOffset < i12) {
                int dateCharacterOffset2 = dateCharacterOffset(str2, dateCharacterOffset + 1, i12, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i14 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    m.e(group, "matcher.group(1)");
                    i14 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    m.e(group2, "matcher.group(2)");
                    i17 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    m.e(group3, "matcher.group(3)");
                    i18 = Integer.parseInt(group3);
                } else if (i15 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    m.e(group4, "matcher.group(1)");
                    i15 = Integer.parseInt(group4);
                } else if (i16 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    m.e(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    m.e(locale, "Locale.US");
                    if (group5 != null) {
                        String lowerCase = group5.toLowerCase(locale);
                        m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String pattern = Cookie.MONTH_PATTERN.pattern();
                        m.e(pattern, "MONTH_PATTERN.pattern()");
                        i16 = j.V(pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (i13 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    m.e(group6, "matcher.group(1)");
                    i13 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str2, dateCharacterOffset2 + 1, i12, false);
            }
            if (70 <= i13 && 99 >= i13) {
                i13 += 1900;
            }
            if (i13 >= 0 && 69 >= i13) {
                i13 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
            }
            if (i13 >= 1601) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (i16 != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (1 <= i15 && 31 >= i15) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if (i14 >= 0 && 23 >= i14) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            if (i17 >= 0 && 59 >= i17) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z14) {
                                if (i18 >= 0 && 59 >= i18) {
                                    z15 = true;
                                } else {
                                    z15 = false;
                                }
                                if (z15) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i13);
                                    gregorianCalendar.set(2, i16 - 1);
                                    gregorianCalendar.set(5, i15);
                                    gregorianCalendar.set(11, i14);
                                    gregorianCalendar.set(12, i17);
                                    gregorianCalendar.set(13, i18);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e10) {
                if (!new h("-?\\d+").c(str)) {
                    throw e10;
                } else if (j.F(str, "-", false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return LocationRequestCompat.PASSIVE_INTERVAL;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (m.b(encodedPath, str)) {
                return true;
            }
            if (!j.F(encodedPath, str, false, 2, (Object) null) || (!j.p(str, DomExceptionUtils.SEPARATOR, false, 2, (Object) null) && encodedPath.charAt(str.length()) != '/')) {
                return false;
            }
            return true;
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            m.f(httpUrl, ImagesContract.URL);
            m.f(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fd, code lost:
            if (r1 > 253402300799999L) goto L_0x0105;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0112  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0132 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0133  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r26, okhttp3.HttpUrl r28, java.lang.String r29) {
            /*
                r25 = this;
                r0 = r25
                r7 = r29
                java.lang.String r1 = "url"
                r8 = r28
                kotlin.jvm.internal.m.f(r8, r1)
                java.lang.String r1 = "setCookie"
                kotlin.jvm.internal.m.f(r7, r1)
                r5 = 6
                r6 = 0
                r2 = 59
                r3 = 0
                r4 = 0
                r1 = r29
                int r9 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r5 = 2
                r2 = 61
                r4 = r9
                int r1 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 0
                if (r1 != r9) goto L_0x0028
                return r2
            L_0x0028:
                r3 = 0
                r4 = 1
                java.lang.String r11 = okhttp3.internal.Util.trimSubstring$default(r7, r3, r1, r4, r2)
                int r5 = r11.length()
                if (r5 != 0) goto L_0x0035
                goto L_0x003c
            L_0x0035:
                int r5 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
                r6 = -1
                if (r5 == r6) goto L_0x003d
            L_0x003c:
                return r2
            L_0x003d:
                int r1 = r1 + r4
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r7, r1, r9)
                int r1 = okhttp3.internal.Util.indexOfControlOrNonAscii(r12)
                if (r1 == r6) goto L_0x0049
                return r2
            L_0x0049:
                int r9 = r9 + r4
                int r1 = r29.length()
                r5 = -1
                r10 = r2
                r22 = r10
                r17 = r3
                r18 = r17
                r19 = r18
                r20 = r4
                r15 = r5
                r23 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0061:
                if (r9 >= r1) goto L_0x00d1
                r2 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r2, (int) r9, (int) r1)
                r13 = 61
                int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r13, (int) r9, (int) r2)
                java.lang.String r9 = okhttp3.internal.Util.trimSubstring(r7, r9, r13)
                if (r13 >= r2) goto L_0x007c
                int r13 = r13 + 1
                java.lang.String r13 = okhttp3.internal.Util.trimSubstring(r7, r13, r2)
                goto L_0x007e
            L_0x007c:
                java.lang.String r13 = ""
            L_0x007e:
                java.lang.String r14 = "expires"
                boolean r14 = kotlin.text.j.q(r9, r14, r4)
                if (r14 == 0) goto L_0x0091
                int r9 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00cd }
                long r23 = r0.parseExpires(r13, r3, r9)     // Catch:{ IllegalArgumentException -> 0x00cd }
            L_0x008e:
                r19 = r4
                goto L_0x00cd
            L_0x0091:
                java.lang.String r14 = "max-age"
                boolean r14 = kotlin.text.j.q(r9, r14, r4)
                if (r14 == 0) goto L_0x009e
                long r15 = r0.parseMaxAge(r13)     // Catch:{  }
                goto L_0x008e
            L_0x009e:
                java.lang.String r14 = "domain"
                boolean r14 = kotlin.text.j.q(r9, r14, r4)
                if (r14 == 0) goto L_0x00ad
                java.lang.String r10 = r0.parseDomain(r13)     // Catch:{ IllegalArgumentException -> 0x00cd }
                r20 = r3
                goto L_0x00cd
            L_0x00ad:
                java.lang.String r14 = "path"
                boolean r14 = kotlin.text.j.q(r9, r14, r4)
                if (r14 == 0) goto L_0x00b8
                r22 = r13
                goto L_0x00cd
            L_0x00b8:
                java.lang.String r13 = "secure"
                boolean r13 = kotlin.text.j.q(r9, r13, r4)
                if (r13 == 0) goto L_0x00c3
                r17 = r4
                goto L_0x00cd
            L_0x00c3:
                java.lang.String r13 = "httponly"
                boolean r9 = kotlin.text.j.q(r9, r13, r4)
                if (r9 == 0) goto L_0x00cd
                r18 = r4
            L_0x00cd:
                int r9 = r2 + 1
                r2 = 0
                goto L_0x0061
            L_0x00d1:
                r1 = -9223372036854775808
                int r4 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x00d9
            L_0x00d7:
                r13 = r1
                goto L_0x0109
            L_0x00d9:
                int r1 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x0107
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00eb
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r15 = r15 * r1
                goto L_0x00f0
            L_0x00eb:
                r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00f0:
                long r1 = r26 + r15
                int r4 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
                if (r4 < 0) goto L_0x0100
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00d7
                goto L_0x0105
            L_0x0100:
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0105:
                r13 = r4
                goto L_0x0109
            L_0x0107:
                r13 = r23
            L_0x0109:
                java.lang.String r1 = r28.host()
                if (r10 != 0) goto L_0x0112
                r15 = r1
                r2 = 0
                goto L_0x011c
            L_0x0112:
                boolean r2 = r0.domainMatch(r1, r10)
                if (r2 != 0) goto L_0x011a
                r2 = 0
                return r2
            L_0x011a:
                r2 = 0
                r15 = r10
            L_0x011c:
                int r1 = r1.length()
                int r4 = r15.length()
                if (r1 == r4) goto L_0x0133
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.get()
                java.lang.String r1 = r1.getEffectiveTldPlusOne(r15)
                if (r1 != 0) goto L_0x0133
                return r2
            L_0x0133:
                java.lang.String r1 = "/"
                r4 = r22
                if (r4 == 0) goto L_0x0144
                r5 = 2
                boolean r2 = kotlin.text.j.F(r4, r1, r3, r5, r2)
                if (r2 != 0) goto L_0x0141
                goto L_0x0144
            L_0x0141:
                r16 = r4
                goto L_0x016b
            L_0x0144:
                java.lang.String r2 = r28.encodedPath()
                r9 = 6
                r10 = 0
                r6 = 47
                r7 = 0
                r8 = 0
                r5 = r2
                int r4 = kotlin.text.j.Z(r5, r6, r7, r8, r9, r10)
                if (r4 == 0) goto L_0x0169
                if (r2 == 0) goto L_0x0161
                java.lang.String r1 = r2.substring(r3, r4)
                java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.m.e(r1, r2)
                goto L_0x0169
            L_0x0161:
                java.lang.NullPointerException r1 = new java.lang.NullPointerException
                java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
                r1.<init>(r2)
                throw r1
            L_0x0169:
                r16 = r1
            L_0x016b:
                okhttp3.Cookie r1 = new okhttp3.Cookie
                r21 = 0
                r10 = r1
                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            m.f(httpUrl, ImagesContract.URL);
            m.f(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < size; i10++) {
                Cookie parse = parse(httpUrl, values.get(i10));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList == null) {
                return r.l();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            m.e(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.persistent = z12;
        this.hostOnly = z13;
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m30deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m31deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m32deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m33deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m34deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m35deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m36deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m37deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m38deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (m.b(cookie.name, this.name) && m.b(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && m.b(cookie.domain, this.domain) && m.b(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + c.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + a.a(this.secure)) * 31) + a.a(this.httpOnly)) * 31) + a.a(this.persistent)) * 31) + a.a(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        boolean z10;
        m.f(httpUrl, ImagesContract.URL);
        if (this.hostOnly) {
            z10 = m.b(httpUrl.host(), this.domain);
        } else {
            z10 = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z10 || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(f.G);
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        m.e(sb3, "toString()");
        return sb3;
    }

    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }
}
