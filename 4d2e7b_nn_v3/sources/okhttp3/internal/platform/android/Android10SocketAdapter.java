package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.SocketAdapter;

@SuppressSignatureCheck
@SuppressLint({"NewApi"})
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @SuppressSignatureCheck
    public static final class Companion {
        private Companion() {
        }

        public final SocketAdapter buildIfSupported() {
            if (isSupported()) {
                return new Android10SocketAdapter();
            }
            return null;
        }

        public final boolean isSupported() {
            if (!Platform.Companion.isAndroid() || Build.VERSION.SDK_INT < 29) {
                return false;
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        m.f(sSLSocket, "sslSocket");
        m.f(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            m.e(sSLParameters, "sslParameters");
            Object[] array = Platform.Companion.alpnProtocolNames(list).toArray(new String[0]);
            if (array != null) {
                sSLParameters.setApplicationProtocols((String[]) array);
                sSLSocket.setSSLParameters(sSLParameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }

    @SuppressLint({"NewApi"})
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        String a10 = sSLSocket.getApplicationProtocol();
        if (a10 != null && (a10.hashCode() != 0 || !a10.equals(""))) {
            return a10;
        }
        return null;
    }

    public boolean isSupported() {
        return Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        m.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        m.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
