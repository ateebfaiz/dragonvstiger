package org.cocos2dx.okhttp3.internal.platform;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.Protocol;
import org.conscrypt.Conscrypt;

public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    public static ConscryptPlatform buildIfSupported() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new ConscryptPlatform();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider getProvider() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLSv1.3", getProvider());
        } catch (NoSuchAlgorithmException e10) {
            try {
                return SSLContext.getInstance("TLS", getProvider());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e10);
            }
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.getSelectedProtocol(sSLSocket);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
            if (readFieldOrNull != null) {
                return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e10) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e10);
        }
    }
}
