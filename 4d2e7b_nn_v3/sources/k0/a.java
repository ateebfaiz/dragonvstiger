package k0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f22233b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final int f22234c;

    /* renamed from: d  reason: collision with root package name */
    static final int f22235d;

    /* renamed from: e  reason: collision with root package name */
    static final int f22236e;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f22237a = new b();

    private static class b implements Executor {
        private b() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f22234c = availableProcessors;
        f22235d = availableProcessors + 1;
        f22236e = (availableProcessors * 2) + 1;
    }

    private a() {
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z10) {
        threadPoolExecutor.allowCoreThreadTimeOut(z10);
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f22235d, f22236e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor c() {
        return f22233b.f22237a;
    }
}
