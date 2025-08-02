package a8;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f2251a;

    public static void a(b bVar) {
        synchronized (a.class) {
            try {
                if (f2251a == null) {
                    f2251a = bVar;
                } else {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(b bVar) {
        if (!c()) {
            a(bVar);
        }
    }

    public static boolean c() {
        boolean z10;
        synchronized (a.class) {
            if (f2251a != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public static boolean d(String str) {
        return e(str, 0);
    }

    public static boolean e(String str, int i10) {
        b bVar;
        synchronized (a.class) {
            bVar = f2251a;
            if (bVar == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return bVar.a(str, i10);
    }
}
