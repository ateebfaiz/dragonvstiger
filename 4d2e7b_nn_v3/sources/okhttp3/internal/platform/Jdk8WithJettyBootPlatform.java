package okhttp3.internal.platform;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Protocol;

public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            m.f(list, "protocols");
            this.protocols = list;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            m.f(obj, "proxy");
            m.f(method, FirebaseAnalytics.Param.METHOD);
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (m.b(name, "supports") && m.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (m.b(name, "unsupported") && m.b(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            } else if (m.b(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            } else {
                if ((m.b(name, "selectProtocol") || m.b(name, "select")) && m.b(String.class, returnType) && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        if (obj2 != null) {
                            List list = (List) obj2;
                            int size = list.size();
                            if (size >= 0) {
                                int i10 = 0;
                                while (true) {
                                    Object obj3 = list.get(i10);
                                    if (obj3 != null) {
                                        String str = (String) obj3;
                                        if (!this.protocols.contains(str)) {
                                            if (i10 == size) {
                                                break;
                                            }
                                            i10++;
                                        } else {
                                            this.selected = str;
                                            return str;
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                }
                            }
                            String str2 = this.protocols.get(0);
                            this.selected = str2;
                            return str2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                }
                if ((!m.b(name, "protocolSelected") && !m.b(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj4 = objArr[0];
                if (obj4 != null) {
                    this.selected = (String) obj4;
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z10) {
            this.unsupported = z10;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|(1:5)|6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x00a1, code lost:
            return null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.internal.platform.Platform buildIfSupported() {
            /*
                r14 = this;
                java.lang.String r0 = "org.eclipse.jetty.alpn.ALPN"
                r1 = 0
                r2 = 1
                java.lang.Class<javax.net.ssl.SSLSocket> r3 = javax.net.ssl.SSLSocket.class
                java.lang.String r4 = "java.specification.version"
                java.lang.String r5 = "unknown"
                java.lang.String r4 = java.lang.System.getProperty(r4, r5)
                r5 = 0
                java.lang.String r6 = "jvmVersion"
                kotlin.jvm.internal.m.e(r4, r6)     // Catch:{ NumberFormatException -> 0x001d }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x001d }
                r6 = 9
                if (r4 < r6) goto L_0x001d
                return r5
            L_0x001d:
                java.lang.Class r4 = java.lang.Class.forName(r0, r2, r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r6.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r6.append(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r7 = "$Provider"
                r6.append(r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r6 = r6.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.Class r6 = java.lang.Class.forName(r6, r2, r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7.append(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r8 = "$ClientProvider"
                r7.append(r8)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.Class r12 = java.lang.Class.forName(r7, r2, r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7.append(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r0 = "$ServerProvider"
                r7.append(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r0 = r7.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.Class r13 = java.lang.Class.forName(r0, r2, r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r0 = "put"
                r7 = 2
                java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7[r1] = r3     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r7[r2] = r6     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.reflect.Method r9 = r4.getMethod(r0, r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r0 = "get"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r6[r1] = r3     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.reflect.Method r10 = r4.getMethod(r0, r6)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r0 = "remove"
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r2[r1] = r3     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.reflect.Method r11 = r4.getMethod(r0, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                okhttp3.internal.platform.Jdk8WithJettyBootPlatform r0 = new okhttp3.internal.platform.Jdk8WithJettyBootPlatform     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r1 = "putMethod"
                kotlin.jvm.internal.m.e(r9, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r1 = "getMethod"
                kotlin.jvm.internal.m.e(r10, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r1 = "removeMethod"
                kotlin.jvm.internal.m.e(r11, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r1 = "clientProviderClass"
                kotlin.jvm.internal.m.e(r12, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                java.lang.String r1 = "serverProviderClass"
                kotlin.jvm.internal.m.e(r13, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                r8 = r0
                r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x00a1 }
                return r0
            L_0x00a1:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Jdk8WithJettyBootPlatform.Companion.buildIfSupported():okhttp3.internal.platform.Platform");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        m.f(method, "putMethod");
        m.f(method2, "getMethod");
        m.f(method3, "removeMethod");
        m.f(cls, "clientProviderClass");
        m.f(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        m.f(sSLSocket, "sslSocket");
        m.f(list, "protocols");
        List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(alpnProtocolNames));
            this.putMethod.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        m.f(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
            if (invocationHandler != null) {
                AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
                if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                    Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, (Throwable) null, 6, (Object) null);
                    return null;
                } else if (alpnProvider.getUnsupported()) {
                    return null;
                } else {
                    return alpnProvider.getSelected();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
