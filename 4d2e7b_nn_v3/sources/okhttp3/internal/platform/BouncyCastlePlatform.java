package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

public final class BouncyCastlePlatform extends Platform {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        public final BouncyCastlePlatform buildIfSupported() {
            if (isSupported()) {
                return new BouncyCastlePlatform((DefaultConstructorMarker) null);
            }
            return null;
        }

        public final boolean isSupported() {
            return BouncyCastlePlatform.isSupported;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, companion.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z10;
    }

    private BouncyCastlePlatform() {
        this.provider = new BouncyCastleJsseProvider();
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        m.f(sSLSocket, "sslSocket");
        m.f(list, "protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
            m.e(parameters, "sslParameters");
            Object[] array = alpnProtocolNames.toArray(new String[0]);
            if (array != null) {
                parameters.setApplicationProtocols((String[]) array);
                bCSSLSocket.setParameters(parameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            return super.getSelectedProtocol(sSLSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS", this.provider);
        m.e(instance, "SSLContext.getInstance(\"TLS\", provider)");
        return instance;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        instance.init((KeyStore) null);
        m.e(instance, "factory");
        TrustManager[] trustManagers = instance.getTrustManagers();
        m.c(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        m.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        m.f(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }

    public /* synthetic */ BouncyCastlePlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
