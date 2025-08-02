package org.cocos2dx.okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.internal.Util;

final class c extends Platform {

    /* renamed from: a  reason: collision with root package name */
    final Method f1714a;

    /* renamed from: b  reason: collision with root package name */
    final Method f1715b;

    c(Method method, Method method2) {
        this.f1714a = method;
        this.f1715b = method2;
    }

    public static c a() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = Platform.alpnProtocolNames(list);
            this.f1714a.invoke(sSLParameters, new Object[]{alpnProtocolNames.toArray(new String[alpnProtocolNames.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw Util.assertionError("unable to set ssl parameters", e10);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f1715b.invoke(sSLSocket, (Object[]) null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw Util.assertionError("failed to get ALPN selected protocol", e10);
        } catch (IllegalAccessException e11) {
            throw Util.assertionError("failed to get ALPN selected protocol", e11);
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
