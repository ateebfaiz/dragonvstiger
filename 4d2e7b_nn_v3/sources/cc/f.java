package cc;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.h;
import kotlinx.coroutines.z;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Collection f65a;

    static {
        Class<z> cls = z.class;
        f65a = h.u(h.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final Collection a() {
        return f65a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
