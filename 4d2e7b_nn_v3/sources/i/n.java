package i;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Comparator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import w.d;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22012a = d.f("");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f22013b = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f22014c = {"TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_CCM_8_SHA256"};

    /* renamed from: d  reason: collision with root package name */
    public static final Comparator f22015d = new m();

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f22016e = {-69, 73, -17, -102, 21, -87, 110, 99, -16, 75, 56, -96, 15, 57, -58, 126, 64, 59, -122, -70, -15, 66, -78, -36, 96, -104, -89, 10, 18, -125, -91, -117};

    /* renamed from: f  reason: collision with root package name */
    public static SSLContext f22017f = null;

    /* renamed from: g  reason: collision with root package name */
    public static SSLSocketFactory f22018g = null;

    /* renamed from: h  reason: collision with root package name */
    public static X509TrustManager f22019h = null;

    public static class a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public final Certificate f22020a;

        public a(Certificate certificate) {
            this.f22020a = certificate;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            String str2 = n.f22012a;
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            String str2 = n.f22012a;
            try {
                x509CertificateArr[0].verify(this.f22020a.getPublicKey());
            } catch (Exception e10) {
                String str3 = n.f22012a;
                throw new CertificateException(e10);
            } catch (Throwable th) {
                String str4 = n.f22012a;
                throw th;
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static /* synthetic */ int a(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        int i10 = 4;
        while (i10 < min) {
            char charAt = str.charAt(i10);
            char charAt2 = str2.charAt(i10);
            if (charAt == charAt2) {
                i10++;
            } else if (charAt < charAt2) {
                return -1;
            } else {
                return 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return -1;
        }
        return 1;
    }

    public static HostnameVerifier b(HostnameVerifier hostnameVerifier) {
        return new l(hostnameVerifier);
    }

    public static SSLContext c(Context context) {
        BufferedInputStream bufferedInputStream;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            bufferedInputStream = new BufferedInputStream(context.openFileInput("localhost.crt"));
            Certificate generateCertificate = instance.generateCertificate(bufferedInputStream);
            ((X509Certificate) generateCertificate).getSubjectDN();
            bufferedInputStream.close();
            SSLContext instance2 = SSLContext.getInstance("TLS");
            a aVar = new a(generateCertificate);
            f22019h = aVar;
            instance2.init((KeyManager[]) null, new TrustManager[]{aVar}, (SecureRandom) null);
            return instance2;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }

    public static boolean d(Comparator comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean e(HostnameVerifier hostnameVerifier, String str, SSLSession sSLSession) {
        if (f(sSLSession)) {
            return true;
        }
        if (hostnameVerifier != null) {
            return hostnameVerifier.verify(str, sSLSession);
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }

    public static boolean f(SSLSession sSLSession) {
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates == null || peerCertificates.length <= 0 || peerCertificates[0] == null || !Arrays.equals(MessageDigest.getInstance("SHA-256").digest(peerCertificates[0].getEncoded()), f22016e)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static boolean g(String[] strArr, boolean z10) {
        boolean z11;
        if (z10) {
            z11 = d(f22015d, f22014c, strArr);
        } else {
            z11 = false;
        }
        if (!z11) {
            return d(f22015d, f22013b, strArr);
        }
        return z11;
    }

    public static SSLSocketFactory h() {
        return f22018g;
    }

    public static boolean i(Context context) {
        if (f22017f == null) {
            SSLContext c10 = c(context);
            f22017f = c10;
            if (c10 != null) {
                f22018g = c10.getSocketFactory();
            }
        }
        if (f22018g != null) {
            return true;
        }
        return false;
    }

    public static X509TrustManager j() {
        return f22019h;
    }

    public static boolean k(Context context) {
        try {
            return c.h(context.getAssets().open("mah.png"), context.getFilesDir());
        } catch (IOException unused) {
            return false;
        }
    }

    public static String[] l() {
        SSLSocketFactory sSLSocketFactory = f22018g;
        if (sSLSocketFactory == null) {
            return null;
        }
        try {
            return sSLSocketFactory.getSupportedCipherSuites();
        } catch (Throwable unused) {
            return null;
        }
    }
}
