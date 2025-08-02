package org.cocos2dx.okhttp3;

import com.alibaba.pdns.s.e.c;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.tls.CertificateChainCleaner;
import org.cocos2dx.okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<a> pins;

    public static final class Builder {
        private final List<a> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String aVar : strArr) {
                    this.pins.add(new a(str, aVar));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), (CertificateChainCleaner) null);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f1530a;

        /* renamed from: b  reason: collision with root package name */
        final String f1531b;

        /* renamed from: c  reason: collision with root package name */
        final String f1532c;

        /* renamed from: d  reason: collision with root package name */
        final ByteString f1533d;

        a(String str, String str2) {
            String str3;
            this.f1530a = str;
            if (str.startsWith("*.")) {
                str3 = HttpUrl.get(c.f18246k + str.substring(2)).host();
            } else {
                str3 = HttpUrl.get(c.f18246k + str).host();
            }
            this.f1531b = str3;
            if (str2.startsWith("sha1/")) {
                this.f1532c = "sha1/";
                this.f1533d = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.f1532c = "sha256/";
                this.f1533d = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.f1533d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f1530a.startsWith("*.")) {
                return str.equals(this.f1531b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f1531b.length()) {
                String str2 = this.f1531b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!this.f1530a.equals(aVar.f1530a) || !this.f1532c.equals(aVar.f1532c) || !this.f1533d.equals(aVar.f1533d)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f1530a.hashCode()) * 31) + this.f1532c.hashCode()) * 31) + this.f1533d.hashCode();
        }

        public String toString() {
            return this.f1532c + this.f1533d.base64();
        }
    }

    CertificatePinner(Set<a> set, CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + sha256((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<a> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i10);
                int size2 = findMatchingPins.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i11 = 0; i11 < size2; i11++) {
                    a aVar = findMatchingPins.get(i11);
                    if (aVar.f1532c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = sha256(x509Certificate);
                        }
                        if (aVar.f1533d.equals(byteString)) {
                            return;
                        }
                    } else if (aVar.f1532c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = sha1(x509Certificate);
                        }
                        if (aVar.f1533d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + aVar.f1532c);
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i12 = 0; i12 < size3; i12++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i12);
                sb2.append("\n    ");
                sb2.append(pin(x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = findMatchingPins.size();
            for (int i13 = 0; i13 < size4; i13++) {
                sb2.append("\n    ");
                sb2.append(findMatchingPins.get(i13));
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) || !this.pins.equals(certificatePinner.pins)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public List<a> findMatchingPins(String str) {
        List<a> emptyList = Collections.emptyList();
        for (a next : this.pins) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public int hashCode() {
        int i10;
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        if (certificateChainCleaner2 != null) {
            i10 = certificateChainCleaner2.hashCode();
        } else {
            i10 = 0;
        }
        return (i10 * 31) + this.pins.hashCode();
    }

    /* access modifiers changed from: package-private */
    public CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner2) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }
}
