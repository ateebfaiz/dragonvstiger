package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;

public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        String str2;
        m.f(str, "scheme");
        m.f(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            String str4 = (String) next.getValue();
            if (str3 != null) {
                Locale locale = Locale.US;
                m.e(locale, "US");
                str2 = str3.toLowerCase(locale);
                m.e(str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, str4);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        m.e(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m22deprecated_authParams() {
        return this.authParams;
    }

    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m23deprecated_charset() {
        return charset();
    }

    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m24deprecated_realm() {
        return realm();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m25deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                m.e(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        m.e(charset, "ISO_8859_1");
        return charset;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (!m.b(challenge.scheme, this.scheme) || !m.b(challenge.authParams, this.authParams)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        m.f(charset, "charset");
        Map r10 = i0.r(this.authParams);
        String name = charset.name();
        m.e(name, "charset.name()");
        r10.put("charset", name);
        return new Challenge(this.scheme, (Map<String, String>) r10);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Challenge(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.m.f(r2, r0)
            java.lang.String r0 = "realm"
            kotlin.jvm.internal.m.f(r3, r0)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r0 = "singletonMap(\"realm\", realm)"
            kotlin.jvm.internal.m.e(r3, r0)
            r1.<init>((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }
}
