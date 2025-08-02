package f4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f21517a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadFactory f21518b;

    /* renamed from: c  reason: collision with root package name */
    private static final ExecutorService f21519c;

    static {
        a aVar = new a();
        f21518b = aVar;
        f21519c = Executors.newCachedThreadPool(aVar);
    }

    private b() {
    }

    /* access modifiers changed from: private */
    public static final Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        return thread;
    }

    public final void b(Runnable runnable) {
        m.f(runnable, "task");
        f21519c.execute(runnable);
    }
}
