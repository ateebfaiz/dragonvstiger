package org.cocos2dx.okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.cocos2dx.okhttp3.internal.Util;

class d extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Method f1716a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f1717b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f1718c;

    /* renamed from: d  reason: collision with root package name */
    private final Class f1719d;

    /* renamed from: e  reason: collision with root package name */
    private final Class f1720e;

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List f1721a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1722b;

        /* renamed from: c  reason: collision with root package name */
        String f1723c;

        a(List list) {
            this.f1721a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f1722b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f1721a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        List list = (List) obj2;
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            if (this.f1721a.contains(list.get(i10))) {
                                String str = (String) list.get(i10);
                                this.f1723c = str;
                                return str;
                            }
                        }
                        String str2 = (String) this.f1721a.get(0);
                        this.f1723c = str2;
                        return str2;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f1723c = (String) objArr[0];
                return null;
            }
        }
    }

    d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f1716a = method;
        this.f1717b = method2;
        this.f1718c = method3;
        this.f1719d = cls;
        this.f1720e = cls2;
    }

    public static Platform a() {
        Class<SSLSocket> cls = SSLSocket.class;
        try {
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            return new d(cls2.getMethod("put", new Class[]{cls, cls3}), cls2.getMethod("get", new Class[]{cls}), cls2.getMethod("remove", new Class[]{cls}), cls4, cls5);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.f1718c.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw Util.assertionError("unable to remove alpn", e10);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        List<String> alpnProtocolNames = Platform.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f1719d, this.f1720e}, new a(alpnProtocolNames));
            this.f1716a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw Util.assertionError("unable to set alpn", e10);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f1717b.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z10 = aVar.f1722b;
            if (!z10 && aVar.f1723c == null) {
                Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z10) {
                return null;
            } else {
                return aVar.f1723c;
            }
        } catch (InvocationTargetException e10) {
            e = e10;
            throw Util.assertionError("unable to get selected protocol", e);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw Util.assertionError("unable to get selected protocol", e);
        }
    }
}
