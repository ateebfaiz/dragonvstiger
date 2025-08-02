package org.cocos2dx.okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.tls.CertificateChainCleaner;
import org.cocos2dx.okhttp3.internal.tls.TrustRootIndex;

class b extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Class f1701a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1702b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1703c;

    /* renamed from: d  reason: collision with root package name */
    private final e f1704d;

    /* renamed from: e  reason: collision with root package name */
    private final e f1705e;

    /* renamed from: f  reason: collision with root package name */
    private final c f1706f = c.b();

    static final class a extends CertificateChainCleaner {

        /* renamed from: a  reason: collision with root package name */
        private final Object f1707a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f1708b;

        a(Object obj, Method method) {
            this.f1707a = obj;
            this.f1708b = method;
        }

        public List clean(List list, String str) {
            try {
                return (List) this.f1708b.invoke(this.f1707a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e10) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
                sSLPeerUnverifiedException.initCause(e10);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: org.cocos2dx.okhttp3.internal.platform.b$b  reason: collision with other inner class name */
    static final class C0028b implements TrustRootIndex {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f1709a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f1710b;

        C0028b(X509TrustManager x509TrustManager, Method method) {
            this.f1710b = method;
            this.f1709a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0028b)) {
                return false;
            }
            C0028b bVar = (C0028b) obj;
            if (!this.f1709a.equals(bVar.f1709a) || !this.f1710b.equals(bVar.f1710b)) {
                return false;
            }
            return true;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f1710b.invoke(this.f1709a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e10) {
                throw Util.assertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.f1709a.hashCode() + (this.f1710b.hashCode() * 31);
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f1711a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f1712b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f1713c;

        c(Method method, Method method2, Method method3) {
            this.f1711a = method;
            this.f1712b = method2;
            this.f1713c = method3;
        }

        static c b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", (Class[]) null);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", (Class[]) null);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f1711a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, (Object[]) null);
                    this.f1712b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj != null) {
                try {
                    this.f1713c.invoke(obj, (Object[]) null);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    b(Class cls, e eVar, e eVar2, e eVar3, e eVar4) {
        this.f1701a = cls;
        this.f1702b = eVar;
        this.f1703c = eVar2;
        this.f1704d = eVar3;
        this.f1705e = eVar4;
    }

    private boolean a(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private boolean b(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    public static Platform c() {
        Class<?> cls;
        e eVar;
        e eVar2;
        Class<byte[]> cls2 = byte[].class;
        if (!Platform.isAndroid()) {
            return null;
        }
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        e eVar3 = new e((Class) null, "setUseSessionTickets", Boolean.TYPE);
        e eVar4 = new e((Class) null, "setHostname", String.class);
        if (e()) {
            eVar2 = new e(cls2, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new e((Class) null, "setAlpnProtocols", cls2);
        } else {
            eVar2 = null;
            eVar = null;
        }
        return new b(cls3, eVar3, eVar4, eVar2, eVar);
    }

    static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    private static boolean e() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            Class<String> cls2 = String.class;
            return new a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls2, cls2}));
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C0028b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f1702b.e(sSLSocket, Boolean.TRUE);
            this.f1703c.e(sSLSocket, str);
        }
        e eVar = this.f1705e;
        if (eVar != null && eVar.g(sSLSocket)) {
            this.f1705e.f(sSLSocket, Platform.concatLengthPrefixed(list));
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (Util.isAndroidGetsocknameError(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        } catch (SecurityException e11) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e11);
            throw iOException;
        } catch (ClassCastException e12) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e12);
                throw iOException2;
            }
            throw e12;
        }
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        byte[] bArr;
        e eVar = this.f1704d;
        if (eVar == null || !eVar.g(sSLSocket) || (bArr = (byte[]) this.f1704d.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.UTF_8);
    }

    public Object getStackTraceForCloseable(String str) {
        return this.f1706f.a(str);
    }

    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw Util.assertionError("unable to determine cleartext support", e10);
        }
    }

    public void log(int i10, String str, Throwable th) {
        int min;
        int i11 = 5;
        if (i10 != 5) {
            i11 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int indexOf = str.indexOf(10, i12);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i12 + 4000);
                Log.println(i11, "OkHttp", str.substring(i12, min));
                if (min >= indexOf) {
                    break;
                }
                i12 = min;
            }
            i12 = min + 1;
        }
    }

    public void logCloseableLeak(String str, Object obj) {
        if (!this.f1706f.c(obj)) {
            log(5, str, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.f1701a, "sslParameters");
        if (readFieldOrNull == null) {
            try {
                readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        Class cls = X509TrustManager.class;
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, cls, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, cls, "trustManager");
    }
}
