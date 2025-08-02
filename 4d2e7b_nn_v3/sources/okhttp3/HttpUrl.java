package okhttp3;

import androidx.autofill.HintConstants;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.f;
import com.google.android.gms.common.internal.ImagesContract;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.g;
import kotlin.ranges.l;
import kotlin.text.h;
import kotlin.text.j;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    /* access modifiers changed from: private */
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword = "";
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername = "";
        private String host;
        private int port = -1;
        private String scheme;

        public static final class Companion {
            private Companion() {
            }

            /* access modifiers changed from: private */
            public final int parsePort(String str, int i10, int i11) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i10, i11, "", false, false, false, false, (Charset) null, 248, (Object) null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* access modifiers changed from: private */
            public final int portColonOffset(String str, int i10, int i11) {
                while (i10 < i11) {
                    char charAt = str.charAt(i10);
                    if (charAt == ':') {
                        return i10;
                    }
                    if (charAt == '[') {
                        do {
                            i10++;
                            if (i10 >= i11) {
                                break;
                            }
                        } while (str.charAt(i10) == ']');
                    }
                    i10++;
                }
                return i11;
            }

            /* access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i10, int i11) {
                if (i11 - i10 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i10);
                if ((m.g(charAt, 97) < 0 || m.g(charAt, 122) > 0) && (m.g(charAt, 65) < 0 || m.g(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i10);
                    if (('a' > charAt2 || 'z' < charAt2) && (('A' > charAt2 || 'Z' < charAt2) && (('0' > charAt2 || '9' < charAt2) && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                        if (charAt2 == ':') {
                            return i10;
                        }
                        return -1;
                    }
                }
            }

            /* access modifiers changed from: private */
            public final int slashCount(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    char charAt = str.charAt(i10);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i12++;
                    i10++;
                }
                return i12;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i10 = this.port;
            if (i10 != -1) {
                return i10;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            m.c(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            if (m.b(str, f.G) || j.q(str, "%2e", true)) {
                return true;
            }
            return false;
        }

        private final boolean isDotDot(String str) {
            if (m.b(str, "..") || j.q(str, "%2e.", true) || j.q(str, ".%2e", true) || j.q(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private final void push(String str, int i10, int i11, boolean z10, boolean z11) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i10, i11, HttpUrl.PATH_SEGMENT_ENCODE_SET, z11, false, false, false, (Charset) null, 240, (Object) null);
            if (!isDot(canonicalize$okhttp$default)) {
                if (isDotDot(canonicalize$okhttp$default)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).length() == 0) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize$okhttp$default);
                } else {
                    this.encodedPathSegments.add(canonicalize$okhttp$default);
                }
                if (z10) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            m.c(list);
            g k10 = l.k(l.i(list.size() - 2, 0), 2);
            int a10 = k10.a();
            int c10 = k10.c();
            int d10 = k10.d();
            if (d10 >= 0) {
                if (a10 > c10) {
                    return;
                }
            } else if (a10 < c10) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                m.c(list2);
                if (m.b(str, list2.get(a10))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    m.c(list3);
                    list3.remove(a10 + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    m.c(list4);
                    list4.remove(a10);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    m.c(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (a10 != c10) {
                    a10 += d10;
                } else {
                    return;
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private final void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r11, (java.lang.String) r12, (int) r6, (int) r13)
                if (r12 >= r13) goto L_0x0036
                r0 = r3
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public final Builder addEncodedPathSegment(String str) {
            m.f(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            m.f(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            String str3;
            m.f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            m.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            m.c(list2);
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null);
            } else {
                str3 = null;
            }
            list2.add(str3);
            return this;
        }

        public final Builder addPathSegment(String str) {
            m.f(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            m.f(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            String str3;
            m.f(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            m.c(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            m.c(list2);
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null);
            } else {
                str3 = null;
            }
            list2.add(str3);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.scheme;
            if (str3 != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, (Object) null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, (Object) null);
                String str4 = this.host;
                if (str4 != null) {
                    int effectivePort = effectivePort();
                    Iterable<String> iterable = this.encodedPathSegments;
                    ArrayList arrayList2 = new ArrayList(r.v(iterable, 10));
                    for (String percentDecode$okhttp$default3 : iterable) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, percentDecode$okhttp$default3, 0, 0, false, 7, (Object) null));
                    }
                    List<String> list = this.encodedQueryNamesAndValues;
                    if (list != null) {
                        Iterable<String> iterable2 = list;
                        arrayList = new ArrayList(r.v(iterable2, 10));
                        for (String str5 : iterable2) {
                            if (str5 != null) {
                                str2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str5, 0, 0, true, 3, (Object) null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str6 = this.encodedFragment;
                    if (str6 != null) {
                        str = Companion.percentDecode$okhttp$default(HttpUrl.Companion, str6, 0, 0, false, 7, (Object) null);
                    } else {
                        str = null;
                    }
                    return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, effectivePort, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            String str2;
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, (Charset) null, 179, (Object) null);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        public final Builder encodedPassword(String str) {
            m.f(str, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder encodedPath(String str) {
            m.f(str, "encodedPath");
            if (j.F(str, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + str).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder encodedUsername(String str) {
            m.f(str, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 243, (Object) null);
            return this;
        }

        public final Builder fragment(String str) {
            String str2;
            if (str != null) {
                str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, (Charset) null, 187, (Object) null);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            m.f(str, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, (Object) null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int i10;
            int delimiterOffset;
            char c10;
            int i11;
            boolean z10;
            boolean z11;
            boolean z12;
            int i12;
            String str2;
            int i13;
            boolean z13;
            boolean z14;
            String str3 = str;
            m.f(str3, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str3, 0, 0, 3, (Object) null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str3, indexOfFirstNonAsciiWhitespace$default, 0, 2, (Object) null);
            Companion companion = Companion;
            int access$schemeDelimiterOffset = companion.schemeDelimiterOffset(str3, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            boolean z15 = true;
            char c11 = 65535;
            if (access$schemeDelimiterOffset != -1) {
                if (j.C(str3, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (j.C(str3, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str3.substring(0, access$schemeDelimiterOffset);
                    m.e(substring, str4);
                    sb2.append(substring);
                    sb2.append("'");
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int access$slashCount = companion.slashCount(str3, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c12 = '?';
            char c13 = '#';
            if (access$slashCount >= 2 || httpUrl == null || (!m.b(httpUrl.scheme(), this.scheme))) {
                int i14 = indexOfFirstNonAsciiWhitespace$default + access$slashCount;
                boolean z16 = false;
                boolean z17 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str3, "@/\\?#", i14, indexOfLastNonAsciiWhitespace$default);
                    if (delimiterOffset != indexOfLastNonAsciiWhitespace$default) {
                        c10 = str3.charAt(delimiterOffset);
                    } else {
                        c10 = c11;
                    }
                    if (c10 == c11 || c10 == c13 || c10 == '/' || c10 == '\\' || c10 == c12) {
                        int i15 = delimiterOffset;
                        boolean z18 = z15;
                        i10 = indexOfLastNonAsciiWhitespace$default;
                        String str5 = str4;
                        Companion companion2 = Companion;
                        int access$portColonOffset = companion2.portColonOffset(str3, i14, i15);
                        int i16 = access$portColonOffset + 1;
                    } else {
                        if (c10 != '@') {
                            z12 = z15;
                            i12 = indexOfLastNonAsciiWhitespace$default;
                            str2 = str4;
                        } else {
                            if (!z16) {
                                int delimiterOffset2 = Util.delimiterOffset(str3, ':', i14, delimiterOffset);
                                Companion companion3 = HttpUrl.Companion;
                                String str6 = "%40";
                                int i17 = delimiterOffset;
                                int i18 = delimiterOffset2;
                                z12 = z15;
                                i12 = indexOfLastNonAsciiWhitespace$default;
                                str2 = str4;
                                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion3, str, i14, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                if (z17) {
                                    canonicalize$okhttp$default = this.encodedUsername + str6 + canonicalize$okhttp$default;
                                }
                                this.encodedUsername = canonicalize$okhttp$default;
                                i13 = i17;
                                int i19 = i18;
                                if (i19 != i13) {
                                    this.encodedPassword = Companion.canonicalize$okhttp$default(companion3, str, i19 + 1, i13, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null);
                                    z14 = z12;
                                } else {
                                    z14 = z16;
                                }
                                z16 = z14;
                                z13 = z12;
                            } else {
                                z12 = z15;
                                i12 = indexOfLastNonAsciiWhitespace$default;
                                str2 = str4;
                                int i20 = delimiterOffset;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(this.encodedPassword);
                                sb3.append("%40");
                                i13 = i20;
                                StringBuilder sb4 = sb3;
                                sb4.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i14, i20, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, (Charset) null, 240, (Object) null));
                                this.encodedPassword = sb4.toString();
                                z13 = z17;
                            }
                            i14 = i13 + 1;
                            z17 = z13;
                        }
                        str4 = str2;
                        indexOfLastNonAsciiWhitespace$default = i12;
                        z15 = z12;
                        c13 = '#';
                        c12 = '?';
                        c11 = 65535;
                    }
                }
                int i152 = delimiterOffset;
                boolean z182 = z15;
                i10 = indexOfLastNonAsciiWhitespace$default;
                String str52 = str4;
                Companion companion22 = Companion;
                int access$portColonOffset2 = companion22.portColonOffset(str3, i14, i152);
                int i162 = access$portColonOffset2 + 1;
                if (i162 < i152) {
                    i11 = i14;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i14, access$portColonOffset2, false, 4, (Object) null));
                    int access$parsePort = companion22.parsePort(str3, i162, i152);
                    this.port = access$parsePort;
                    if (access$parsePort != -1) {
                        z11 = z182;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Invalid URL port: \"");
                        String substring2 = str3.substring(i162, i152);
                        m.e(substring2, str52);
                        sb5.append(substring2);
                        sb5.append('\"');
                        throw new IllegalArgumentException(sb5.toString().toString());
                    }
                } else {
                    i11 = i14;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i11, access$portColonOffset2, false, 4, (Object) null));
                    String str7 = this.scheme;
                    m.c(str7);
                    this.port = companion4.defaultPort(str7);
                }
                if (this.host != null) {
                    z10 = z182;
                } else {
                    z10 = false;
                }
                if (z10) {
                    indexOfFirstNonAsciiWhitespace$default = i152;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Invalid URL host: \"");
                    String substring3 = str3.substring(i11, access$portColonOffset2);
                    m.e(substring3, str52);
                    sb6.append(substring3);
                    sb6.append('\"');
                    throw new IllegalArgumentException(sb6.toString().toString());
                }
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str3.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i10 = indexOfLastNonAsciiWhitespace$default;
            }
            int i21 = i10;
            int delimiterOffset3 = Util.delimiterOffset(str3, "?#", indexOfFirstNonAsciiWhitespace$default, i21);
            resolvePath(str3, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i21 && str3.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str3, '#', delimiterOffset3, i21);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, (Charset) null, 208, (Object) null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i21 && str3.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i21, "", true, false, false, true, (Charset) null, 176, (Object) null);
            }
            return this;
        }

        public final Builder password(String str) {
            m.f(str, HintConstants.AUTOFILL_HINT_PASSWORD);
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        public final Builder port(int i10) {
            boolean z10 = true;
            if (1 > i10 || 65535 < i10) {
                z10 = false;
            }
            if (z10) {
                this.port = i10;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i10).toString());
        }

        public final Builder query(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2;
            String str3 = this.host;
            String str4 = null;
            if (str3 != null) {
                str = new h("[\"<>^`{|}]").d(str3, "");
            } else {
                str = null;
            }
            this.host = str;
            int size = this.encodedPathSegments.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<String> list = this.encodedPathSegments;
                list.set(i10, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i10), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, (Charset) null, 227, (Object) null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str5 = list2.get(i11);
                    if (str5 != null) {
                        str2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str5, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, (Charset) null, 195, (Object) null);
                    } else {
                        str2 = null;
                    }
                    list2.set(i11, str2);
                }
            }
            String str6 = this.encodedFragment;
            if (str6 != null) {
                str4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str6, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, (Charset) null, 163, (Object) null);
            }
            this.encodedFragment = str4;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            m.f(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, (Charset) null, 211, (Object) null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            m.f(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, (Charset) null, 219, (Object) null));
            return this;
        }

        public final Builder removePathSegment(int i10) {
            this.encodedPathSegments.remove(i10);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            m.f(str, "scheme");
            if (j.q(str, "http", true)) {
                this.scheme = "http";
            } else if (j.q(str, "https", true)) {
                this.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            m.f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i10, String str) {
            boolean z10;
            m.f(str, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, (Charset) null, 243, (Object) null);
            this.encodedPathSegments.set(i10, canonicalize$okhttp$default);
            if (isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            m.f(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            m.f(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i10, String str) {
            boolean z10;
            m.f(str, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, (Charset) null, 251, (Object) null);
            if (isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                this.encodedPathSegments.set(i10, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + str).toString());
        }

        public final void setPort$okhttp(int i10) {
            this.port = i10;
        }

        public final Builder setQueryParameter(String str, String str2) {
            m.f(str, "name");
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
            if (r1 != r4.defaultPort(r3)) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x0012
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L_0x0017
            L_0x0012:
                java.lang.String r1 = "//"
                r0.append(r1)
            L_0x0017:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L_0x0022
                goto L_0x002a
            L_0x0022:
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0044
            L_0x002a:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x003f
                r0.append(r2)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L_0x003f:
                r1 = 64
                r0.append(r1)
            L_0x0044:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L_0x0069
                kotlin.jvm.internal.m.c(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = kotlin.text.j.J(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L_0x0064
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L_0x0069
            L_0x0064:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L_0x0069:
                int r1 = r6.port
                r3 = -1
                if (r1 != r3) goto L_0x0072
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L_0x008b
            L_0x0072:
                int r1 = r6.effectivePort()
                java.lang.String r3 = r6.scheme
                if (r3 == 0) goto L_0x0085
                okhttp3.HttpUrl$Companion r4 = okhttp3.HttpUrl.Companion
                kotlin.jvm.internal.m.c(r3)
                int r3 = r4.defaultPort(r3)
                if (r1 == r3) goto L_0x008b
            L_0x0085:
                r0.append(r2)
                r0.append(r1)
            L_0x008b:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto L_0x00a3
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.m.c(r2)
                r1.toQueryString$okhttp(r2, r0)
            L_0x00a3:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto L_0x00b1
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            L_0x00b1:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.m.e(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String str) {
            m.f(str, HintConstants.AUTOFILL_HINT_USERNAME);
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, (Charset) null, 251, (Object) null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z10) {
            int i10 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i10, str.length());
                push(str, i10, delimiterOffset, delimiterOffset < str.length(), z10);
                i10 = delimiterOffset + 1;
            } while (i10 <= str.length());
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            int i13 = i12;
            return companion.canonicalize$okhttp(str, (i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? str.length() : i11, str2, (i13 & 8) != 0 ? false : z10, (i13 & 16) != 0 ? false : z11, (i13 & 32) != 0 ? false : z12, (i13 & 64) != 0 ? false : z13, (i13 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i10, int i11) {
            int i12 = i10 + 2;
            if (i12 >= i11 || str.charAt(i10) != '%' || Util.parseHexDigit(str.charAt(i10 + 1)) == -1 || Util.parseHexDigit(str.charAt(i12)) == -1) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return companion.percentDecode$okhttp(str, i10, i11, z10);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
            if (isPercentEncoded(r1, r5, r2) == false) goto L_0x0072;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void writeCanonicalized(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            L_0x000b:
                if (r5 >= r2) goto L_0x00c8
                if (r1 == 0) goto L_0x00bf
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L_0x002b
                r8 = 9
                if (r7 == r8) goto L_0x0026
                r8 = 10
                if (r7 == r8) goto L_0x0026
                r8 = 12
                if (r7 == r8) goto L_0x0026
                r8 = 13
                if (r7 == r8) goto L_0x0026
                goto L_0x002b
            L_0x0026:
                r8 = r14
                r12 = r19
                goto L_0x00b8
            L_0x002b:
                r8 = 43
                if (r7 != r8) goto L_0x003c
                if (r22 == 0) goto L_0x003c
                if (r20 == 0) goto L_0x0036
                java.lang.String r8 = "+"
                goto L_0x0038
            L_0x0036:
                java.lang.String r8 = "%2B"
            L_0x0038:
                r15.writeUtf8((java.lang.String) r8)
                goto L_0x0026
            L_0x003c:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L_0x004d
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L_0x004d
                r8 = 128(0x80, float:1.794E-43)
                if (r7 < r8) goto L_0x0051
                if (r23 == 0) goto L_0x004d
                goto L_0x0051
            L_0x004d:
                r8 = r14
                r12 = r19
                goto L_0x0072
            L_0x0051:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.j.J(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L_0x006c
                if (r7 != r9) goto L_0x006a
                if (r20 == 0) goto L_0x006c
                if (r21 == 0) goto L_0x006a
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L_0x006e
                goto L_0x0072
            L_0x006a:
                r8 = r14
                goto L_0x006e
            L_0x006c:
                r8 = r14
                goto L_0x0072
            L_0x006e:
                r15.writeUtf8CodePoint((int) r7)
                goto L_0x00b8
            L_0x0072:
                if (r6 != 0) goto L_0x0079
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L_0x0079:
                if (r3 == 0) goto L_0x008d
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.m.b(r3, r10)
                if (r10 == 0) goto L_0x0084
                goto L_0x008d
            L_0x0084:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.writeString((java.lang.String) r1, (int) r5, (int) r10, (java.nio.charset.Charset) r3)
                goto L_0x0090
            L_0x008d:
                r6.writeUtf8CodePoint((int) r7)
            L_0x0090:
                boolean r10 = r6.exhausted()
                if (r10 != 0) goto L_0x00b8
                byte r10 = r6.readByte()
                r11 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte((int) r9)
                char[] r13 = okhttp3.HttpUrl.HEX_DIGITS
                int r11 = r11 >> 4
                r11 = r11 & 15
                char r11 = r13[r11]
                r15.writeByte((int) r11)
                char[] r11 = okhttp3.HttpUrl.HEX_DIGITS
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte((int) r10)
                goto L_0x0090
            L_0x00b8:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto L_0x000b
            L_0x00bf:
                r8 = r14
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                throw r0
            L_0x00c8:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                if (str != null) {
                    int codePointAt = str.codePointAt(i10);
                    if (codePointAt == 37 && (i12 = i10 + 2) < i11) {
                        int parseHexDigit = Util.parseHexDigit(str.charAt(i10 + 1));
                        int parseHexDigit2 = Util.parseHexDigit(str.charAt(i12));
                        if (!(parseHexDigit == -1 || parseHexDigit2 == -1)) {
                            buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                            i10 = Character.charCount(codePointAt) + i12;
                        }
                    } else if (codePointAt == 43 && z10) {
                        buffer.writeByte(32);
                        i10++;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i10 += Character.charCount(codePointAt);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m70deprecated_get(String str) {
            m.f(str, ImagesContract.URL);
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m73deprecated_parse(String str) {
            m.f(str, ImagesContract.URL);
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            String str3 = str;
            int i12 = i11;
            String str4 = str2;
            m.f(str, "$this$canonicalize");
            m.f(str4, "encodeSet");
            int i13 = i10;
            while (i13 < i12) {
                int codePointAt = str.codePointAt(i13);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z13) && !j.J(str4, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z10) {
                            if (z11) {
                                if (!isPercentEncoded(str, i13, i12)) {
                                    Buffer buffer = new Buffer();
                                    int i14 = i10;
                                    buffer.writeUtf8(str, i10, i13);
                                    writeCanonicalized(buffer, str, i13, i11, str2, z10, z11, z12, z13, charset);
                                    return buffer.readUtf8();
                                }
                                if (codePointAt == 43 || !z12) {
                                    i13 += Character.charCount(codePointAt);
                                } else {
                                    Buffer buffer2 = new Buffer();
                                    int i142 = i10;
                                    buffer2.writeUtf8(str, i10, i13);
                                    writeCanonicalized(buffer2, str, i13, i11, str2, z10, z11, z12, z13, charset);
                                    return buffer2.readUtf8();
                                }
                            }
                        }
                    }
                    if (codePointAt == 43) {
                    }
                    i13 += Character.charCount(codePointAt);
                }
                Buffer buffer22 = new Buffer();
                int i1422 = i10;
                buffer22.writeUtf8(str, i10, i13);
                writeCanonicalized(buffer22, str, i13, i11, str2, z10, z11, z12, z13, charset);
                return buffer22.readUtf8();
            }
            int i15 = i10;
            String substring = str.substring(i10, i11);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String str) {
            m.f(str, "scheme");
            int hashCode = str.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && str.equals("https")) {
                    return DNSResolver.PORT_443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final HttpUrl get(String str) {
            m.f(str, "$this$toHttpUrl");
            return new Builder().parse$okhttp((HttpUrl) null, str).build();
        }

        public final HttpUrl parse(String str) {
            m.f(str, "$this$toHttpUrlOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i10, int i11, boolean z10) {
            m.f(str, "$this$percentDecode");
            for (int i12 = i10; i12 < i11; i12++) {
                char charAt = str.charAt(i12);
                if (charAt == '%' || (charAt == '+' && z10)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i10, i12);
                    writePercentDecoded(buffer, str, i12, i11, z10);
                    return buffer.readUtf8();
                }
            }
            String substring = str.substring(i10, i11);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb2) {
            m.f(list, "$this$toPathString");
            m.f(sb2, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append('/');
                sb2.append(list.get(i10));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            m.f(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int U = j.U(str, '&', i10, false, 4, (Object) null);
                if (U == -1) {
                    U = str.length();
                }
                int i11 = U;
                int U2 = j.U(str, '=', i10, false, 4, (Object) null);
                if (U2 == -1 || U2 > i11) {
                    String substring = str.substring(i10, i11);
                    m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add((Object) null);
                } else {
                    String substring2 = str.substring(i10, U2);
                    m.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(U2 + 1, i11);
                    m.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb2) {
            m.f(list, "$this$toQueryString");
            m.f(sb2, "out");
            g k10 = l.k(l.l(0, list.size()), 2);
            int a10 = k10.a();
            int c10 = k10.c();
            int d10 = k10.d();
            if (d10 >= 0) {
                if (a10 > c10) {
                    return;
                }
            } else if (a10 < c10) {
                return;
            }
            while (true) {
                String str = list.get(a10);
                String str2 = list.get(a10 + 1);
                if (a10 > 0) {
                    sb2.append('&');
                }
                sb2.append(str);
                if (str2 != null) {
                    sb2.append('=');
                    sb2.append(str2);
                }
                if (a10 != c10) {
                    a10 += d10;
                } else {
                    return;
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m72deprecated_get(URL url) {
            m.f(url, ImagesContract.URL);
            return get(url);
        }

        public final HttpUrl get(URL url) {
            m.f(url, "$this$toHttpUrlOrNull");
            String url2 = url.toString();
            m.e(url2, "toString()");
            return parse(url2);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m71deprecated_get(URI uri) {
            m.f(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            m.f(uri, "$this$toHttpUrlOrNull");
            String uri2 = uri.toString();
            m.e(uri2, "toString()");
            return parse(uri2);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i10, List<String> list, List<String> list2, String str5, String str6) {
        m.f(str, "scheme");
        m.f(str2, HintConstants.AUTOFILL_HINT_USERNAME);
        m.f(str3, HintConstants.AUTOFILL_HINT_PASSWORD);
        m.f(str4, "host");
        m.f(list, "pathSegments");
        m.f(str6, ImagesContract.URL);
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i10;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = m.b(str, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m51deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m52deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m53deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m54deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m55deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m56deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m57deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m58deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m59deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m60deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m61deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m62deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m63deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m64deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m65deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m66deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m67deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m68deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m69deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int U = j.U(this.url, '#', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        if (str != null) {
            String substring = str.substring(U);
            m.e(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int U = j.U(this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1;
        int U2 = j.U(this.url, '@', 0, false, 6, (Object) null);
        String str = this.url;
        if (str != null) {
            String substring = str.substring(U, U2);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPath() {
        int U = j.U(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", U, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(U, delimiterOffset);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> encodedPathSegments() {
        int U = j.U(this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", U, str.length());
        ArrayList arrayList = new ArrayList();
        while (U < delimiterOffset) {
            int i10 = U + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i10, delimiterOffset);
            String str2 = this.url;
            if (str2 != null) {
                String substring = str2.substring(i10, delimiterOffset2);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(substring);
                U = delimiterOffset2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int U = j.U(this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', U, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(U, delimiterOffset);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(length, delimiterOffset);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpUrl) || !m.b(((HttpUrl) obj).url, this.url)) {
            return false;
        }
        return true;
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String str) {
        m.f(str, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        g k10 = l.k(l.l(0, list.size()), 2);
        int a10 = k10.a();
        int c10 = k10.c();
        int d10 = k10.d();
        if (d10 < 0 ? a10 >= c10 : a10 <= c10) {
            while (!m.b(str, this.queryNamesAndValues.get(a10))) {
                if (a10 != c10) {
                    a10 += d10;
                }
            }
            return this.queryNamesAndValues.get(a10 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i10 * 2);
            m.c(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return r0.d();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g k10 = l.k(l.l(0, this.queryNamesAndValues.size()), 2);
        int a10 = k10.a();
        int c10 = k10.c();
        int d10 = k10.d();
        if (d10 < 0 ? a10 >= c10 : a10 <= c10) {
            while (true) {
                String str = this.queryNamesAndValues.get(a10);
                m.c(str);
                linkedHashSet.add(str);
                if (a10 == c10) {
                    break;
                }
                a10 += d10;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        m.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        m.f(str, "name");
        if (this.queryNamesAndValues == null) {
            return r.l();
        }
        ArrayList arrayList = new ArrayList();
        g k10 = l.k(l.l(0, this.queryNamesAndValues.size()), 2);
        int a10 = k10.a();
        int c10 = k10.c();
        int d10 = k10.d();
        if (d10 < 0 ? a10 >= c10 : a10 <= c10) {
            while (true) {
                if (m.b(str, this.queryNamesAndValues.get(a10))) {
                    arrayList.add(this.queryNamesAndValues.get(a10 + 1));
                }
                if (a10 == c10) {
                    break;
                }
                a10 += d10;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        m.e(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        m.c(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        m.f(str, "link");
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e10) {
            try {
                URI create = URI.create(new h("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").d(builder, ""));
                m.e(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url2) {
        return Companion.get(url2);
    }

    public final Builder newBuilder(String str) {
        m.f(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
