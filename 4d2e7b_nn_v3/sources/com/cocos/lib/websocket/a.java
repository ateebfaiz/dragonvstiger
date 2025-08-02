package com.cocos.lib.websocket;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

abstract class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    protected final SSLSocketFactory f19405a;

    a(SSLSocketFactory sSLSocketFactory) {
        this.f19405a = sSLSocketFactory;
    }

    /* access modifiers changed from: protected */
    public abstract SSLSocket a(SSLSocket sSLSocket);

    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        return a((SSLSocket) this.f19405a.createSocket(socket, str, i10, z10));
    }

    public String[] getDefaultCipherSuites() {
        return this.f19405a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f19405a.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i10) {
        return a((SSLSocket) this.f19405a.createSocket(str, i10));
    }

    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return a((SSLSocket) this.f19405a.createSocket(str, i10, inetAddress, i11));
    }

    public Socket createSocket(InetAddress inetAddress, int i10) {
        return a((SSLSocket) this.f19405a.createSocket(inetAddress, i10));
    }

    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return a((SSLSocket) this.f19405a.createSocket(inetAddress, i10, inetAddress2, i11));
    }
}
