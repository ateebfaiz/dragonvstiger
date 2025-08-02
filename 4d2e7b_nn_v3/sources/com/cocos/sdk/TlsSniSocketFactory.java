package com.cocos.sdk;

import android.net.SSLCertificateSocketFactory;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TlsSniSocketFactory extends SSLSocketFactory {
    private final String TAG = TlsSniSocketFactory.class.getSimpleName();
    private HttpsURLConnection conn;
    HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public TlsSniSocketFactory(HttpsURLConnection httpsURLConnection) {
        this.conn = httpsURLConnection;
    }

    public Socket createSocket() throws IOException {
        return null;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(String str, int i10) throws IOException, UnknownHostException {
        return null;
    }

    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        String requestProperty = this.conn.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        String str2 = this.TAG;
        Log.i(str2, "customized createSocket. host: " + str);
        InetAddress inetAddress = socket.getInetAddress();
        if (z10) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i10);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        Log.i(this.TAG, "Setting SNI hostname");
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (this.hostnameVerifier.verify(str, session)) {
            String str3 = this.TAG;
            Log.i(str3, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
