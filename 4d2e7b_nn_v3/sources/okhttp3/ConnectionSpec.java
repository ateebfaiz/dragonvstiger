package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import nb.a;
import okhttp3.internal.Util;

public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ConnectionSpec MODERN_TLS;
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
    public static final ConnectionSpec RESTRICTED_TLS;
    /* access modifiers changed from: private */
    public final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    /* access modifiers changed from: private */
    public final String[] tlsVersionsAsString;

    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public Builder(boolean z10) {
            this.tls = z10;
        }

        public final Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            m.f(cipherSuiteArr, "cipherSuites");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
                for (CipherSuite javaName : cipherSuiteArr) {
                    arrayList.add(javaName.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(String[] strArr) {
            this.cipherSuites = strArr;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z10) {
            this.supportsTlsExtensions = z10;
        }

        public final void setTls$okhttp(boolean z10) {
            this.tls = z10;
        }

        public final void setTlsVersions$okhttp(String[] strArr) {
            this.tlsVersions = strArr;
        }

        public final Builder supportsTlsExtensions(boolean z10) {
            if (this.tls) {
                this.supportsTlsExtensions = z10;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final Builder tlsVersions(TlsVersion... tlsVersionArr) {
            m.f(tlsVersionArr, "tlsVersions");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(tlsVersionArr.length);
                for (TlsVersion javaName : tlsVersionArr) {
                    arrayList.add(javaName.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public Builder(ConnectionSpec connectionSpec) {
            m.f(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        public final Builder cipherSuites(String... strArr) {
            m.f(strArr, "cipherSuites");
            if (this.tls) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.cipherSuites = (String[]) clone;
                        return this;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final Builder tlsVersions(String... strArr) {
            m.f(strArr, "tlsVersions");
            if (this.tls) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.tlsVersions = (String[]) clone;
                        return this;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        RESTRICTED_CIPHER_SUITES = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = cipherSuiteArr2;
        Builder cipherSuites = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = cipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        MODERN_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new Builder(true).cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    }

    public ConnectionSpec(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.isTls = z10;
        this.supportsTlsExtensions = z11;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    private final ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z10) {
        String[] strArr;
        String[] strArr2;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            m.e(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            strArr = Util.intersect(enabledCipherSuites, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            m.e(enabledProtocols, "sslSocket.enabledProtocols");
            strArr2 = Util.intersect(enabledProtocols, this.tlsVersionsAsString, a.b());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        m.e(supportedCipherSuites, "supportedCipherSuites");
        int indexOf = Util.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (z10 && indexOf != -1) {
            m.e(strArr, "cipherSuitesIntersection");
            String str = supportedCipherSuites[indexOf];
            m.e(str, "supportedCipherSuites[indexOfFallbackScsv]");
            strArr = Util.concat(strArr, str);
        }
        Builder builder = new Builder(this);
        m.e(strArr, "cipherSuitesIntersection");
        Builder cipherSuites = builder.cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
        m.e(strArr2, "tlsVersionsIntersection");
        return cipherSuites.tlsVersions((String[]) Arrays.copyOf(strArr2, strArr2.length)).build();
    }

    /* renamed from: -deprecated_cipherSuites  reason: not valid java name */
    public final List<CipherSuite> m27deprecated_cipherSuites() {
        return cipherSuites();
    }

    /* renamed from: -deprecated_supportsTlsExtensions  reason: not valid java name */
    public final boolean m28deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    /* renamed from: -deprecated_tlsVersions  reason: not valid java name */
    public final List<TlsVersion> m29deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean z10) {
        m.f(sSLSocket, "sslSocket");
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z10);
        if (supportedSpec.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(supportedSpec.tlsVersionsAsString);
        }
        if (supportedSpec.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(supportedSpec.cipherSuitesAsString);
        }
    }

    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String forJavaName : strArr) {
            arrayList.add(CipherSuite.Companion.forJavaName(forJavaName));
        }
        return r.w0(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.isTls;
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (z10 != connectionSpec.isTls) {
            return false;
        }
        if (!z10 || (Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int i11 = 0;
        if (strArr != null) {
            i10 = Arrays.hashCode(strArr);
        } else {
            i10 = 0;
        }
        int i12 = (527 + i10) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        if (strArr2 != null) {
            i11 = Arrays.hashCode(strArr2);
        }
        return ((i12 + i11) * 31) + (this.supportsTlsExtensions ^ true ? 1 : 0);
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        m.f(sSLSocket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !Util.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), a.b())) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        if (strArr2 == null || Util.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp())) {
            return true;
        }
        return false;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String forJavaName : strArr) {
            arrayList.add(TlsVersion.Companion.forJavaName(forJavaName));
        }
        return r.w0(arrayList);
    }

    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(" + "cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", " + "tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", " + "supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }
}
