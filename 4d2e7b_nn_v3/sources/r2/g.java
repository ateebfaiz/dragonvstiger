package r2;

import r2.a;

public class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private static g f23652a;

    private g() {
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f23652a == null) {
                    f23652a = new g();
                }
                gVar = f23652a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public void a(a.C0326a aVar, Class cls, String str, Throwable th) {
    }
}
