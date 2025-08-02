package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.m;
import okhttp3.ConnectionSpec;

public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        m.f(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i10 = this.nextModeIndex; i10 < size; i10++) {
            if (this.connectionSpecs.get(i10).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        m.f(sSLSocket, "sslSocket");
        int i10 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i10 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i10);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i10 + 1;
                break;
            }
            i10++;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            connectionSpec.apply$okhttp(sSLSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.isFallback);
        sb2.append(',');
        sb2.append(" modes=");
        sb2.append(this.connectionSpecs);
        sb2.append(',');
        sb2.append(" supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        m.c(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        m.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean connectionFailed(IOException iOException) {
        m.f(iOException, "e");
        this.isFallback = true;
        if (this.isFallbackPossible && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException))) {
            return true;
        }
        return false;
    }
}
