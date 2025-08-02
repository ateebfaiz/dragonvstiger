package org.cocos2dx.okio;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static d f1796a;

    /* renamed from: b  reason: collision with root package name */
    static long f1797b;

    static void a(d dVar) {
        if (dVar.f1794f != null || dVar.f1795g != null) {
            throw new IllegalArgumentException();
        } else if (!dVar.f1792d) {
            synchronized (e.class) {
                try {
                    long j10 = f1797b;
                    if (j10 + 8192 <= 65536) {
                        f1797b = j10 + 8192;
                        dVar.f1794f = f1796a;
                        dVar.f1791c = 0;
                        dVar.f1790b = 0;
                        f1796a = dVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static d b() {
        synchronized (e.class) {
            try {
                d dVar = f1796a;
                if (dVar == null) {
                    return new d();
                }
                f1796a = dVar.f1794f;
                dVar.f1794f = null;
                f1797b -= 8192;
                return dVar;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
