package okhttp3.internal.tls;

import androidx.webkit.ProxyConfig;
import com.alibaba.pdns.f;
import io.jsonwebtoken.JwtParser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        m.e(locale, "Locale.US");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i10) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return r.l();
            }
            ArrayList arrayList = new ArrayList();
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        if (!(!m.b(next.get(0), Integer.valueOf(i10)))) {
                            Object obj = next.get(1);
                            if (obj != null) {
                                arrayList.add((String) obj);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return r.l();
        }
    }

    private final boolean isAscii(String str) {
        if (str.length() == ((int) Utf8.size$default(str, 0, 0, 3, (Object) null))) {
            return true;
        }
        return false;
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        Iterable<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && ((Collection) subjectAltNames).isEmpty()) {
            return false;
        }
        for (String verifyHostname : subjectAltNames) {
            if (INSTANCE.verifyHostname(asciiToLowercase, verifyHostname)) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        Iterable<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && ((Collection) subjectAltNames).isEmpty()) {
            return false;
        }
        for (String canonicalHost2 : subjectAltNames) {
            if (m.b(canonicalHost, HostnamesKt.toCanonicalHost(canonicalHost2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        m.f(x509Certificate, "certificate");
        return r.j0(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    public boolean verify(String str, SSLSession sSLSession) {
        m.f(str, "host");
        m.f(sSLSession, "session");
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(str, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        m.f(str, "host");
        m.f(x509Certificate, "certificate");
        if (Util.canParseAsIpAddress(str)) {
            return verifyIpAddress(str, x509Certificate);
        }
        return verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !j.F(str, f.G, false, 2, (Object) null) && !j.p(str, "..", false, 2, (Object) null) && str2 != null && str2.length() != 0 && !j.F(str2, f.G, false, 2, (Object) null) && !j.p(str2, "..", false, 2, (Object) null)) {
            if (!j.p(str, f.G, false, 2, (Object) null)) {
                str = str + f.G;
            }
            String str3 = str;
            if (!j.p(str2, f.G, false, 2, (Object) null)) {
                str2 = str2 + f.G;
            }
            String asciiToLowercase = asciiToLowercase(str2);
            if (!j.K(asciiToLowercase, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, (Object) null)) {
                return m.b(str3, asciiToLowercase);
            }
            if (!j.F(asciiToLowercase, "*.", false, 2, (Object) null) || j.U(asciiToLowercase, '*', 1, false, 4, (Object) null) != -1 || str3.length() < asciiToLowercase.length() || m.b("*.", asciiToLowercase)) {
                return false;
            }
            String substring = asciiToLowercase.substring(1);
            m.e(substring, "(this as java.lang.String).substring(startIndex)");
            if (!j.p(str3, substring, false, 2, (Object) null)) {
                return false;
            }
            int length = str3.length() - substring.length();
            if (length <= 0 || j.Z(str3, JwtParser.SEPARATOR_CHAR, length - 1, false, 4, (Object) null) == -1) {
                return true;
            }
            return false;
        }
        return false;
    }
}
