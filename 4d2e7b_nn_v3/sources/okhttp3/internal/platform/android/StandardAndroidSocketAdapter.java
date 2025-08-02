package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        public final SocketAdapter buildIfSupported(String str) {
            m.f(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                m.e(cls3, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, cls3);
            } catch (Exception e10) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e10);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        m.f(cls, "sslSocketClass");
        m.f(cls2, "sslSocketFactoryClass");
        m.f(cls3, "paramClass");
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        m.f(sSLSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        m.f(sSLSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        m.c(readFieldOrNull);
        Class cls = X509TrustManager.class;
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, cls, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, cls, "trustManager");
    }
}
