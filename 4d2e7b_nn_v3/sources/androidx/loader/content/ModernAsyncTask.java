package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask {

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f15904f;

    /* renamed from: g  reason: collision with root package name */
    private static final BlockingQueue f15905g;

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f15906h;

    /* renamed from: i  reason: collision with root package name */
    private static f f15907i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile Executor f15908j;

    /* renamed from: a  reason: collision with root package name */
    private final g f15909a;

    /* renamed from: b  reason: collision with root package name */
    private final FutureTask f15910b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Status f15911c = Status.PENDING;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f15912d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f15913e = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f15914a = new AtomicInteger(1);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f15914a.getAndIncrement());
        }
    }

    class b extends g {
        b() {
        }

        public Object call() {
            ModernAsyncTask.this.f15913e.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = ModernAsyncTask.this.b(this.f15920a);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.k(obj);
                return obj;
            } catch (Throwable th) {
                ModernAsyncTask.this.k(obj);
                throw th;
            }
        }
    }

    class c extends FutureTask {
        c(Callable callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                ModernAsyncTask.this.l(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (CancellationException unused) {
                ModernAsyncTask.this.l((Object) null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15917a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15917a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15917a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.d.<clinit>():void");
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f15918a;

        /* renamed from: b  reason: collision with root package name */
        final Object[] f15919b;

        e(ModernAsyncTask modernAsyncTask, Object... objArr) {
            this.f15918a = modernAsyncTask;
            this.f15919b = objArr;
        }
    }

    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f15918a.d(eVar.f15919b[0]);
            } else if (i10 == 2) {
                eVar.f15918a.j(eVar.f15919b);
            }
        }
    }

    private static abstract class g implements Callable {

        /* renamed from: a  reason: collision with root package name */
        Object[] f15920a;

        g() {
        }
    }

    static {
        a aVar = new a();
        f15904f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f15905g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f15906h = threadPoolExecutor;
        f15908j = threadPoolExecutor;
    }

    ModernAsyncTask() {
        b bVar = new b();
        this.f15909a = bVar;
        this.f15910b = new c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (ModernAsyncTask.class) {
            try {
                if (f15907i == null) {
                    f15907i = new f();
                }
                fVar = f15907i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f15912d.set(true);
        return this.f15910b.cancel(z10);
    }

    /* access modifiers changed from: protected */
    public abstract Object b(Object... objArr);

    public final ModernAsyncTask c(Executor executor, Object... objArr) {
        if (this.f15911c != Status.PENDING) {
            int i10 = d.f15917a[this.f15911c.ordinal()];
            if (i10 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i10 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f15911c = Status.RUNNING;
            i();
            this.f15909a.f15920a = objArr;
            executor.execute(this.f15910b);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f15911c = Status.FINISHED;
    }

    public final boolean f() {
        return this.f15912d.get();
    }

    /* access modifiers changed from: protected */
    public abstract void g(Object obj);

    /* access modifiers changed from: protected */
    public abstract void h(Object obj);

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j(Object... objArr) {
    }

    /* access modifiers changed from: package-private */
    public Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    /* access modifiers changed from: package-private */
    public void l(Object obj) {
        if (!this.f15913e.get()) {
            k(obj);
        }
    }
}
