package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.platform.Platform;

public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final CertificateChainCleaner get(X509TrustManager x509TrustManager) {
            m.f(x509TrustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(x509TrustManager);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CertificateChainCleaner get(X509Certificate... x509CertificateArr) {
            m.f(x509CertificateArr, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length)));
        }
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
