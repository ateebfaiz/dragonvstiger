package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class g {

    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f15093a;

        /* renamed from: b  reason: collision with root package name */
        private int f15094b;

        /* renamed from: androidx.core.provider.g$a$a  reason: collision with other inner class name */
        private static class C0190a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f15095a;

            C0190a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f15095a = i10;
            }

            public void run() {
                Process.setThreadPriority(this.f15095a);
                super.run();
            }
        }

        a(String str, int i10) {
            this.f15093a = str;
            this.f15094b = i10;
        }

        public Thread newThread(Runnable runnable) {
            return new C0190a(runnable, this.f15093a, this.f15094b);
        }
    }

    private static class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f15096a;

        b(Handler handler) {
            this.f15096a = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f15096a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.f15096a + " is shutting down");
            }
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Callable f15097a;

        /* renamed from: b  reason: collision with root package name */
        private Consumer f15098b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f15099c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Consumer f15100a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f15101b;

            a(Consumer consumer, Object obj) {
                this.f15100a = consumer;
                this.f15101b = obj;
            }

            public void run() {
                this.f15100a.accept(this.f15101b);
            }
        }

        c(Handler handler, Callable callable, Consumer consumer) {
            this.f15097a = callable;
            this.f15098b = consumer;
            this.f15099c = handler;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f15097a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f15099c.post(new a(this.f15098b, obj));
        }
    }

    static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(Handler handler) {
        return new b(handler);
    }

    static void c(Executor executor, Callable callable, Consumer consumer) {
        executor.execute(new c(b.a(), callable, consumer));
    }

    static Object d(ExecutorService executorService, Callable callable, int i10) {
        try {
            return executorService.submit(callable).get((long) i10, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e10) {
            throw new RuntimeException(e10);
        } catch (InterruptedException e11) {
            throw e11;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
