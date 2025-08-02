package j2;

import j2.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22150a = new b();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22151a = new a();

        a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    b.a(b.f22150a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    /* renamed from: j2.b$b  reason: collision with other inner class name */
    static final class C0293b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C0293b f22152a = new C0293b();

        C0293b() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    b.a(b.f22150a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private b() {
    }

    public static final /* synthetic */ void a(b bVar) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                bVar.b();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void b() {
        if (!v5.a.d(this)) {
            try {
                c.b bVar = c.f22158x;
                e.e(bVar.d(), bVar.e());
                bVar.d().clear();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r1 = j2.c.f22158x;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(android.content.Context r3) {
        /*
            java.lang.Class<j2.b> r0 = j2.b.class
            boolean r1 = v5.a.d(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "context"
            kotlin.jvm.internal.m.f(r3, r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "com.android.billingclient.api.Purchase"
            java.lang.Class r1 = j2.h.a(r1)     // Catch:{ all -> 0x0037 }
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            j2.c$b r1 = j2.c.f22158x     // Catch:{ all -> 0x0037 }
            j2.c r3 = r1.c(r3)     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x003e
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.f()     // Catch:{ all -> 0x0037 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x003e
            boolean r1 = j2.e.d()     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = "inapp"
            if (r1 == 0) goto L_0x0039
            j2.b$a r1 = j2.b.a.f22151a     // Catch:{ all -> 0x0037 }
            r3.p(r2, r1)     // Catch:{ all -> 0x0037 }
            goto L_0x003e
        L_0x0037:
            r3 = move-exception
            goto L_0x003f
        L_0x0039:
            j2.b$b r1 = j2.b.C0293b.f22152a     // Catch:{ all -> 0x0037 }
            r3.o(r2, r1)     // Catch:{ all -> 0x0037 }
        L_0x003e:
            return
        L_0x003f:
            v5.a.b(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.b.c(android.content.Context):void");
    }
}
