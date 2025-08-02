package j8;

import java.lang.ref.SoftReference;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final k f12399a;

    /* renamed from: b  reason: collision with root package name */
    protected static final ThreadLocal f12400b = new ThreadLocal();

    static {
        boolean z10;
        k kVar;
        try {
            z10 = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        if (z10) {
            kVar = k.a();
        } else {
            kVar = null;
        }
        f12399a = kVar;
    }

    public static a a() {
        a aVar;
        SoftReference softReference;
        ThreadLocal threadLocal = f12400b;
        SoftReference softReference2 = (SoftReference) threadLocal.get();
        if (softReference2 == null) {
            aVar = null;
        } else {
            aVar = (a) softReference2.get();
        }
        if (aVar == null) {
            aVar = new a();
            k kVar = f12399a;
            if (kVar != null) {
                softReference = kVar.c(aVar);
            } else {
                softReference = new SoftReference(aVar);
            }
            threadLocal.set(softReference);
        }
        return aVar;
    }
}
