package h5;

import com.facebook.imagepipeline.memory.a;

public class z implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private static z f21991a;

    private z() {
    }

    public static synchronized z h() {
        z zVar;
        synchronized (z.class) {
            try {
                if (f21991a == null) {
                    f21991a = new z();
                }
                zVar = f21991a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    public void a(int i10) {
    }

    public void b(int i10) {
    }

    public void c(a aVar) {
    }

    public void d() {
    }

    public void e(int i10) {
    }

    public void f() {
    }

    public void g(int i10) {
    }
}
