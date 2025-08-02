package s3;

import android.os.Looper;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f23847a;

    /* renamed from: s3.a$a  reason: collision with other inner class name */
    public interface C0331a {
        void release();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f23847a == null) {
                    f23847a = new b();
                }
                aVar = f23847a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    static boolean c() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public abstract void a(C0331a aVar);

    public abstract void d(C0331a aVar);
}
