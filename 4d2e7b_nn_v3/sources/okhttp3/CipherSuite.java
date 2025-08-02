package okhttp3;

import androidx.appcompat.app.AppCompatDelegate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class CipherSuite {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Comparator<String> ORDER_BY_NAME = new CipherSuite$Companion$ORDER_BY_NAME$1();
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256;
    public static final CipherSuite TLS_AES_128_CCM_SHA256;
    public static final CipherSuite TLS_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    public static final CipherSuite TLS_FALLBACK_SCSV;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    private final String javaName;

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final CipherSuite init(String str, int i10) {
            CipherSuite cipherSuite = new CipherSuite(str, (DefaultConstructorMarker) null);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        private final String secondaryName(String str) {
            if (j.F(str, "TLS_", false, 2, (Object) null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SSL_");
                if (str != null) {
                    String substring = str.substring(4);
                    m.e(substring, "(this as java.lang.String).substring(startIndex)");
                    sb2.append(substring);
                    return sb2.toString();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } else if (!j.F(str, "SSL_", false, 2, (Object) null)) {
                return str;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("TLS_");
                if (str != null) {
                    String substring2 = str.substring(4);
                    m.e(substring2, "(this as java.lang.String).substring(startIndex)");
                    sb3.append(substring2);
                    return sb3.toString();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }

        public final synchronized CipherSuite forJavaName(String str) {
            CipherSuite cipherSuite;
            try {
                m.f(str, "javaName");
                cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(str);
                if (cipherSuite == null) {
                    cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(str));
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(str, (DefaultConstructorMarker) null);
                    }
                    CipherSuite.INSTANCES.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }

        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        TLS_RSA_WITH_NULL_MD5 = companion.init("SSL_RSA_WITH_NULL_MD5", 1);
        TLS_RSA_WITH_NULL_SHA = companion.init("SSL_RSA_WITH_NULL_SHA", 2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        TLS_RSA_WITH_RC4_128_MD5 = companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
        TLS_RSA_WITH_RC4_128_SHA = companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        TLS_RSA_WITH_DES_CBC_SHA = companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        TLS_DH_anon_WITH_RC4_128_MD5 = companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        TLS_DH_anon_WITH_DES_CBC_SHA = companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        TLS_KRB5_WITH_DES_CBC_SHA = companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        TLS_KRB5_WITH_RC4_128_SHA = companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
        TLS_KRB5_WITH_DES_CBC_MD5 = companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        TLS_KRB5_WITH_RC4_128_MD5 = companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        TLS_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        TLS_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        TLS_RSA_WITH_NULL_SHA256 = companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        TLS_PSK_WITH_RC4_128_SHA = companion.init("TLS_PSK_WITH_RC4_128_SHA", 138);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        TLS_PSK_WITH_AES_128_CBC_SHA = companion.init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        TLS_PSK_WITH_AES_256_CBC_SHA = companion.init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        TLS_RSA_WITH_SEED_CBC_SHA = companion.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = companion.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = companion.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        TLS_FALLBACK_SCSV = companion.init("TLS_FALLBACK_SCSV", 22016);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        TLS_ECDH_RSA_WITH_NULL_SHA = companion.init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        TLS_ECDHE_RSA_WITH_NULL_SHA = companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        TLS_ECDH_anon_WITH_NULL_SHA = companion.init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        TLS_ECDH_anon_WITH_RC4_128_SHA = companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = companion.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = companion.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = companion.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        TLS_AES_128_GCM_SHA256 = companion.init("TLS_AES_128_GCM_SHA256", 4865);
        TLS_AES_256_GCM_SHA384 = companion.init("TLS_AES_256_GCM_SHA384", 4866);
        TLS_CHACHA20_POLY1305_SHA256 = companion.init("TLS_CHACHA20_POLY1305_SHA256", 4867);
        TLS_AES_128_CCM_SHA256 = companion.init("TLS_AES_128_CCM_SHA256", 4868);
        TLS_AES_128_CCM_8_SHA256 = companion.init("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private CipherSuite(String str) {
        this.javaName = str;
    }

    public static final synchronized CipherSuite forJavaName(String str) {
        CipherSuite forJavaName;
        synchronized (CipherSuite.class) {
            forJavaName = Companion.forJavaName(str);
        }
        return forJavaName;
    }

    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m26deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }

    public /* synthetic */ CipherSuite(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
