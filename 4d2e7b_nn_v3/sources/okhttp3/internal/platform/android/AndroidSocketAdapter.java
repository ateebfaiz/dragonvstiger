package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final AndroidSocketAdapter build(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && (!m.b(cls2.getSimpleName(), "OpenSSLSocketImpl"))) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            m.c(cls2);
            return new AndroidSocketAdapter(cls2);
        }

        public final DeferredSocketAdapter.Factory factory(String str) {
            m.f(str, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(str);
        }

        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> cls) {
        m.f(cls, "sslSocketClass");
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        m.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = cls.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", (Class[]) null);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        m.f(sSLSocket, "sslSocket");
        m.f(list, "protocols");
        if (matchesSocket(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, new Object[]{Boolean.TRUE});
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, new Object[]{str});
                }
                this.setAlpnProtocols.invoke(sSLSocket, new Object[]{Platform.Companion.concatLengthPrefixed(list)});
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        if (!matchesSocket(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, (Object[]) null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            m.e(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (NullPointerException e10) {
            if (m.b(e10.getMessage(), "ssl == null")) {
                return null;
            }
            throw e10;
        } catch (IllegalAccessException e11) {
            throw new AssertionError(e11);
        } catch (InvocationTargetException e12) {
            throw new AssertionError(e12);
        }
    }

    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket);
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
