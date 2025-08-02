package i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f22032a = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new h("CommonTask-Thread"));

    public static ScheduledThreadPoolExecutor a(String str, int i10) {
        return new ScheduledThreadPoolExecutor(i10, new h(str));
    }

    public static void b(Runnable runnable) {
        f22032a.execute(runnable);
    }
}
