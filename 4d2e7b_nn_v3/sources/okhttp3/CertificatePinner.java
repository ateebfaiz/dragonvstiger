package okhttp3;

import androidx.webkit.ProxyConfig;
import io.jsonwebtoken.JwtParser;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            m.f(str, "pattern");
            m.f(strArr, "pins");
            for (String pin : strArr) {
                this.pins.add(new Pin(str, pin));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(r.A0(this.pins), (CertificateChainCleaner) null, 2, (DefaultConstructorMarker) null);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final String pin(Certificate certificate) {
            m.f(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            m.f(x509Certificate, "$this$sha1Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            m.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.e(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha1();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            m.f(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            m.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.e(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha256();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            boolean z10;
            m.f(str, "pattern");
            m.f(str2, "pin");
            if ((!j.F(str, "*.", false, 2, (Object) null) || j.V(str, ProxyConfig.MATCH_ALL_SCHEMES, 1, false, 4, (Object) null) != -1) && ((!j.F(str, "**.", false, 2, (Object) null) || j.V(str, ProxyConfig.MATCH_ALL_SCHEMES, 2, false, 4, (Object) null) != -1) && j.V(str, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6, (Object) null) != -1)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (j.F(str2, "sha1/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.Companion;
                        String substring = str2.substring(5);
                        m.e(substring, "(this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase64 = companion.decodeBase64(substring);
                        if (decodeBase64 != null) {
                            this.hash = decodeBase64;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else if (j.F(str2, "sha256/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha256";
                        ByteString.Companion companion2 = ByteString.Companion;
                        String substring2 = str2.substring(7);
                        m.e(substring2, "(this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase642 = companion2.decodeBase64(substring2);
                        if (decodeBase642 != null) {
                            this.hash = decodeBase642;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else {
                        throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid pattern: " + str);
                }
            } else {
                throw new IllegalArgumentException(("Unexpected pattern: " + str).toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            if (!(!m.b(this.pattern, pin.pattern)) && !(!m.b(this.hashAlgorithm, pin.hashAlgorithm)) && !(!m.b(this.hash, pin.hash))) {
                return true;
            }
            return false;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            m.f(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            int hashCode = str.hashCode();
            if (hashCode != -903629273) {
                if (hashCode == 3528965 && str.equals("sha1")) {
                    return m.b(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
                }
            } else if (str.equals("sha256")) {
                return m.b(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(String str) {
            m.f(str, "hostname");
            if (j.F(this.pattern, "**.", false, 2, (Object) null)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                if (!j.u(str, str.length() - length, this.pattern, 3, length, false, 16, (Object) null)) {
                    return false;
                }
                if (!(length2 == 0 || str.charAt(length2 - 1) == '.')) {
                    return false;
                }
            } else if (!j.F(this.pattern, "*.", false, 2, (Object) null)) {
                return m.b(str, this.pattern);
            } else {
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                if (!j.u(str, str.length() - length3, this.pattern, 1, length3, false, 16, (Object) null)) {
                    return false;
                }
                if (j.Z(str, JwtParser.SEPARATOR_CHAR, length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner2) {
        m.f(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        m.f(str, "hostname");
        m.f(list, "peerCertificates");
        check$okhttp(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void check$okhttp(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        Pin next;
        m.f(str, "hostname");
        m.f(function0, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            List<X509Certificate> list = (List) function0.invoke();
            loop0:
            for (X509Certificate x509Certificate : list) {
                Iterator<Pin> it = findMatchingPins.iterator();
                ByteString byteString = null;
                ByteString byteString2 = null;
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        String hashAlgorithm = next.getHashAlgorithm();
                        int hashCode = hashAlgorithm.hashCode();
                        if (hashCode == -903629273) {
                            if (!hashAlgorithm.equals("sha256")) {
                                break loop0;
                            }
                            if (byteString == null) {
                                byteString = Companion.sha256Hash(x509Certificate);
                            }
                            if (m.b(next.getHash(), byteString)) {
                                return;
                            }
                        } else if (hashCode != 3528965 || !hashAlgorithm.equals("sha1")) {
                            break loop0;
                        } else {
                            if (byteString2 == null) {
                                byteString2 = Companion.sha1Hash(x509Certificate);
                            }
                            if (m.b(next.getHash(), byteString2)) {
                                return;
                            }
                        }
                    }
                }
                throw new AssertionError("unsupported hashAlgorithm: " + next.getHashAlgorithm());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list) {
                sb2.append("\n    ");
                sb2.append(Companion.pin(x509Certificate2));
                sb2.append(": ");
                Principal subjectDN = x509Certificate2.getSubjectDN();
                m.e(subjectDN, "element.subjectDN");
                sb2.append(subjectDN.getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            for (Pin append : findMatchingPins) {
                sb2.append("\n    ");
                sb2.append(append);
            }
            String sb3 = sb2.toString();
            m.e(sb3, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb3);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!m.b(certificatePinner.pins, this.pins) || !m.b(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        m.f(str, "hostname");
        List<Pin> l10 = r.l();
        for (Object next : this.pins) {
            if (((Pin) next).matchesHostname(str)) {
                if (l10.isEmpty()) {
                    l10 = new ArrayList<>();
                }
                c0.c(l10).add(next);
            }
        }
        return l10;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i10;
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        if (certificateChainCleaner2 != null) {
            i10 = certificateChainCleaner2.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner2) {
        m.f(certificateChainCleaner2, "certificateChainCleaner");
        if (m.b(this.certificateChainCleaner, certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i10 & 2) != 0 ? null : certificateChainCleaner2);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        m.f(str, "hostname");
        m.f(certificateArr, "peerCertificates");
        check(str, (List<? extends Certificate>) kotlin.collections.j.W(certificateArr));
    }
}
