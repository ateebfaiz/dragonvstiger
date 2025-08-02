package org.cocos2dx.okhttp3.internal.platform;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

class a extends b {
    a(Class cls) {
        super(cls, (e) null, (e) null, (e) null, (e) null);
    }

    public static Platform c() {
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            if (b.d() >= 29) {
                return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }

    private void f(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        try {
            f(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Object obj = (String[]) Platform.alpnProtocolNames(list).toArray(new String[0]);
            try {
                sSLParameters.getClass().getMethod("setApplicationProtocols", new Class[]{obj.getClass()}).invoke(sSLParameters, new Object[]{obj});
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e11) {
            throw new IOException("Android internal error", e11);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String str;
        try {
            str = (String) sSLSocket.getClass().getMethod("getApplicationProtocol", (Class[]) null).invoke(sSLSocket, (Object[]) null);
        } catch (Exception e10) {
            e10.printStackTrace();
            str = null;
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }
}
