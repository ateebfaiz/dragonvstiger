package l2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.alibaba.pdns.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import tb.c;

public final class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f22428a;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f22429b = {"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"};

    /* renamed from: c  reason: collision with root package name */
    public static final g f22430c = new g();

    public static final class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f22431a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f22432b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReentrantLock f22433c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Condition f22434d;

        a(Object obj, y yVar, ReentrantLock reentrantLock, Condition condition) {
            this.f22431a = obj;
            this.f22432b = yVar;
            this.f22433c = reentrantLock;
            this.f22434d = condition;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            m.f(method, FirebaseAnalytics.Param.METHOD);
            m.f(objArr, "objects");
            try {
                if (m.b(method.getName(), "onChecksumsReady") && objArr.length == 1) {
                    List list = objArr[0];
                    if (list instanceof List) {
                        if (list != null) {
                            for (Object next : list) {
                                if (next != null) {
                                    Method method2 = next.getClass().getMethod("getSplitName", (Class[]) null);
                                    m.e(method2, "c.javaClass.getMethod(\"getSplitName\")");
                                    Method method3 = next.getClass().getMethod("getType", (Class[]) null);
                                    m.e(method3, "c.javaClass.getMethod(\"getType\")");
                                    if (method2.invoke(next, (Object[]) null) == null && m.b(method3.invoke(next, (Object[]) null), this.f22431a)) {
                                        Method method4 = next.getClass().getMethod("getValue", (Class[]) null);
                                        m.e(method4, "c.javaClass.getMethod(\"getValue\")");
                                        Object invoke = method4.invoke(next, (Object[]) null);
                                        if (invoke != null) {
                                            this.f22432b.f725a = new BigInteger(1, (byte[]) invoke).toString(16);
                                            this.f22433c.lock();
                                            this.f22434d.signalAll();
                                            this.f22433c.unlock();
                                            return null;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                                    }
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d(g.f22428a, "Can't fetch checksum.", th);
            }
            return null;
        }
    }

    static {
        String simpleName = g.class.getSimpleName();
        m.e(simpleName, "HashUtils::class.java.simpleName");
        f22428a = simpleName;
    }

    private g() {
    }

    public static final String b(String str) {
        return f22430c.d(new File(str));
    }

    public static final String c(Context context, Long l10) {
        m.f(context, "context");
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        String[] strArr = f22429b;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String decode : strArr) {
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(Base64.decode(decode, 0))));
        }
        List y02 = r.y0(arrayList);
        y yVar = new y();
        yVar.f725a = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        reentrantLock.lock();
        try {
            Class<?> cls = Class.forName("android.content.pm.Checksum");
            m.e(cls, "Class.forName(\"android.content.pm.Checksum\")");
            Field field = cls.getField("TYPE_WHOLE_MD5");
            m.e(field, "checksumClass.getField(\"TYPE_WHOLE_MD5\")");
            Object obj = field.get((Object) null);
            Class<?> cls2 = Class.forName("android.content.pm.PackageManager$OnChecksumsReadyListener");
            m.e(cls2, "Class.forName(\"android.c…nChecksumsReadyListener\")");
            Object newProxyInstance = Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{cls2}, new a(obj, yVar, reentrantLock, newCondition));
            m.e(newProxyInstance, "Proxy.newProxyInstance(\n…       }\n              })");
            Method method = PackageManager.class.getMethod("requestChecksums", new Class[]{String.class, Boolean.TYPE, Integer.TYPE, List.class, cls2});
            m.e(method, "PackageManager::class.ja…ecksumReadyListenerClass)");
            method.invoke(context.getPackageManager(), new Object[]{context.getPackageName(), Boolean.FALSE, obj, r.y0(y02), newProxyInstance});
            if (l10 == null) {
                newCondition.await();
            } else {
                newCondition.awaitNanos(l10.longValue());
            }
            String str = (String) yVar.f725a;
            reentrantLock.unlock();
            return str;
        } catch (Throwable unused) {
            reentrantLock.unlock();
            return null;
        }
    }

    private final String d(File file) {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            } while (read != -1);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            m.e(bigInteger, "BigInteger(1, md.digest()).toString(16)");
            c.a(bufferedInputStream, (Throwable) null);
            return bigInteger;
        } catch (Throwable th) {
            c.a(bufferedInputStream, th);
            throw th;
        }
    }
}
