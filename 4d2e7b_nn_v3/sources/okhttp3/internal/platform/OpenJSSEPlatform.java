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
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

public final class OpenJSSEPlatform extends Platform {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        public final OpenJSSEPlatform buildIfSupported() {
            if (isSupported()) {
                return new OpenJSSEPlatform((DefaultConstructorMarker) null);
            }
            return null;
        }

        public final boolean isSupported() {
            return OpenJSSEPlatform.isSupported;
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
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, companion.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z10;
    }

    private OpenJSSEPlatform() {
        this.provider = new OpenJSSE();
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        m.f(sSLSocket, "sslSocket");
        m.f(list, "protocols");
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
            SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
            if (sSLParameters instanceof SSLParameters) {
                SSLParameters sSLParameters2 = sSLParameters;
                Object[] array = Platform.Companion.alpnProtocolNames(list).toArray(new String[0]);
                if (array != null) {
                    sSLParameters2.setApplicationProtocols((String[]) array);
                    sSLSocket2.setSSLParameters(sSLParameters);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.getSelectedProtocol(sSLSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLSv1.3", this.provider);
        m.e(instance, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return instance;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
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
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }

    public /* synthetic */ OpenJSSEPlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
