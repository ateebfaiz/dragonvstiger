package org.cocos2dx.okhttp3;

import androidx.core.location.LocationRequestCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http.HttpDate;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
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
        String domain;
        long expiresAt = 253402300799999L;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = DomExceptionUtils.SEPARATOR;
        boolean persistent;
        boolean secure;
        String value;

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder expiresAt(long j10) {
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

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder path(String str) {
            if (str.startsWith(DomExceptionUtils.SEPARATOR)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        private Builder domain(String str, boolean z10) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.domain = canonicalizeHost;
                    this.hostOnly = z10;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
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
        this.hostOnly = z12;
        this.persistent = z13;
    }

    private static int dateCharacterOffset(String str, int i10, int i11, boolean z10) {
        boolean z11;
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if ((charAt >= ' ' || charAt == 9) && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) {
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

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.verifyAsIpAddress(str)) {
            return false;
        }
        return true;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
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
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String parseDomain(String str) {
        if (!str.endsWith(f.G)) {
            if (str.startsWith(f.G)) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i10, int i11) {
        int dateCharacterOffset = dateCharacterOffset(str, i10, i11, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (dateCharacterOffset < i11) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i11, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i13 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i13 = Integer.parseInt(matcher.group(1));
                i16 = Integer.parseInt(matcher.group(2));
                i17 = Integer.parseInt(matcher.group(3));
            } else if (i14 != -1 || !matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                if (i15 == -1) {
                    Pattern pattern = MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        i15 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i12 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i12 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i14 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i11, false);
        }
        if (i12 >= 70 && i12 <= 99) {
            i12 += 1900;
        }
        if (i12 >= 0 && i12 <= 69) {
            i12 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        }
        if (i12 < 1601) {
            throw new IllegalArgumentException();
        } else if (i15 == -1) {
            throw new IllegalArgumentException();
        } else if (i14 < 1 || i14 > 31) {
            throw new IllegalArgumentException();
        } else if (i13 < 0 || i13 > 23) {
            throw new IllegalArgumentException();
        } else if (i16 < 0 || i16 > 59) {
            throw new IllegalArgumentException();
        } else if (i17 < 0 || i17 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i12);
            gregorianCalendar.set(2, i15 - 1);
            gregorianCalendar.set(5, i14);
            gregorianCalendar.set(11, i13);
            gregorianCalendar.set(12, i16);
            gregorianCalendar.set(13, i17);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e10) {
            if (!str.matches("-?\\d+")) {
                throw e10;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str)) {
            return false;
        }
        if (!str.endsWith(DomExceptionUtils.SEPARATOR) && encodedPath.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        long j10 = this.expiresAt;
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.secure ^ true ? 1 : 0)) * 31) + (this.httpOnly ^ true ? 1 : 0)) * 31) + (this.persistent ^ true ? 1 : 0)) * 31) + (this.hostOnly ^ true ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean z10;
        if (this.hostOnly) {
            z10 = httpUrl.host().equals(this.domain);
        } else {
            z10 = domainMatch(httpUrl.host(), this.domain);
        }
        if (!z10 || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.cocos2dx.okhttp3.Cookie parse(long r23, org.cocos2dx.okhttp3.HttpUrl r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = org.cocos2dx.okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r1, (char) r3)
            r5 = 61
            int r6 = org.cocos2dx.okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = org.cocos2dx.okhttp3.internal.Util.trimSubstring(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0028
            int r8 = org.cocos2dx.okhttp3.internal.Util.indexOfControlOrNonAscii(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002b
        L_0x0028:
            r0 = r7
            goto L_0x0135
        L_0x002b:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = org.cocos2dx.okhttp3.internal.Util.trimSubstring(r0, r6, r4)
            int r11 = org.cocos2dx.okhttp3.internal.Util.indexOfControlOrNonAscii(r6)
            if (r11 == r10) goto L_0x0038
            return r7
        L_0x0038:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r15 = r2
            r16 = r15
            r18 = r16
            r14 = r7
            r17 = r8
            r19 = r10
            r21 = r12
            r8 = r14
        L_0x004d:
            if (r4 >= r1) goto L_0x00bb
            int r7 = org.cocos2dx.okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r1, (char) r3)
            int r3 = org.cocos2dx.okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = org.cocos2dx.okhttp3.internal.Util.trimSubstring(r0, r4, r3)
            if (r3 >= r7) goto L_0x0064
            int r3 = r3 + 1
            java.lang.String r3 = org.cocos2dx.okhttp3.internal.Util.trimSubstring(r0, r3, r7)
            goto L_0x0066
        L_0x0064:
            java.lang.String r3 = ""
        L_0x0066:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0079
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b3 }
            long r21 = parseExpires(r3, r2, r4)     // Catch:{ IllegalArgumentException -> 0x00b3 }
        L_0x0076:
            r18 = 1
            goto L_0x00b3
        L_0x0079:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0086
            long r19 = parseMaxAge(r3)     // Catch:{  }
            goto L_0x0076
        L_0x0086:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0095
            java.lang.String r14 = parseDomain(r3)     // Catch:{ IllegalArgumentException -> 0x00b3 }
            r17 = r2
            goto L_0x00b3
        L_0x0095:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009f
            r8 = r3
            goto L_0x00b3
        L_0x009f:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a9
            r15 = 1
            goto L_0x00b3
        L_0x00a9:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b3
            r16 = 1
        L_0x00b3:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004d
        L_0x00bb:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c3
        L_0x00c1:
            r11 = r0
            goto L_0x00e8
        L_0x00c3:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e6
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x00d5
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00da
        L_0x00d5:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00da:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e4
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c1
        L_0x00e4:
            r11 = r12
            goto L_0x00e8
        L_0x00e6:
            r11 = r21
        L_0x00e8:
            java.lang.String r0 = r25.host()
            if (r14 != 0) goto L_0x00f1
            r13 = r0
            r1 = 0
            goto L_0x00fb
        L_0x00f1:
            boolean r1 = domainMatch(r0, r14)
            if (r1 != 0) goto L_0x00f9
            r1 = 0
            return r1
        L_0x00f9:
            r1 = 0
            r13 = r14
        L_0x00fb:
            int r0 = r0.length()
            int r3 = r13.length()
            if (r0 == r3) goto L_0x0110
            org.cocos2dx.okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = org.cocos2dx.okhttp3.internal.publicsuffix.PublicSuffixDatabase.get()
            java.lang.String r0 = r0.getEffectiveTldPlusOne(r13)
            if (r0 != 0) goto L_0x0110
            return r1
        L_0x0110:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011d
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011b
            goto L_0x011d
        L_0x011b:
            r14 = r8
            goto L_0x012e
        L_0x011d:
            java.lang.String r1 = r25.encodedPath()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x012d
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x012d:
            r14 = r0
        L_0x012e:
            org.cocos2dx.okhttp3.Cookie r0 = new org.cocos2dx.okhttp3.Cookie
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
        L_0x0135:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.Cookie.parse(long, org.cocos2dx.okhttp3.HttpUrl, java.lang.String):org.cocos2dx.okhttp3.Cookie");
    }

    /* access modifiers changed from: package-private */
    public String toString(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(HttpDate.format(new Date(this.expiresAt)));
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
        return sb2.toString();
    }

    Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
