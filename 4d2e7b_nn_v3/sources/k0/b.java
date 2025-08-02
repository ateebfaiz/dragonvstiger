package k0;

import com.alibaba.pdns.f;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class b {

    /* renamed from: d  reason: collision with root package name */
    private static final b f22238d = new b();

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f22239a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f22240b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f22241c;

    /* renamed from: k0.b$b  reason: collision with other inner class name */
    private static class C0297b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private ThreadLocal f22242a;

        private C0297b() {
            this.f22242a = new ThreadLocal();
        }

        private int a() {
            Integer num = (Integer) this.f22242a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f22242a.remove();
            } else {
                this.f22242a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private int b() {
            Integer num = (Integer) this.f22242a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f22242a.set(Integer.valueOf(intValue));
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (b() <= 15) {
                try {
                    runnable.run();
                } finally {
                    a();
                }
            } else {
                b.a().execute(runnable);
            }
        }
    }

    private b() {
        ExecutorService executorService;
        if (!c()) {
            executorService = Executors.newCachedThreadPool();
        } else {
            executorService = a.b();
        }
        this.f22239a = executorService;
        this.f22240b = Executors.newSingleThreadScheduledExecutor();
        this.f22241c = new C0297b();
    }

    public static ExecutorService a() {
        return f22238d.f22239a;
    }

    static Executor b() {
        return f22238d.f22241c;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(f.f17924q);
    }
}
