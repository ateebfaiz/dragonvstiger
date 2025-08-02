package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;

public final class TaskRunner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final TaskRunner INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
    /* access modifiers changed from: private */
    public static final Logger logger;
    private final Backend backend;
    private final List<TaskQueue> busyQueues = new ArrayList();
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName = 10000;
    private final List<TaskQueue> readyQueues = new ArrayList();
    private final Runnable runnable = new TaskRunner$runnable$1(this);

    public interface Backend {
        void beforeTask(TaskRunner taskRunner);

        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j10);

        void execute(Runnable runnable);

        long nanoTime();
    }

    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.logger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public RealBackend(ThreadFactory threadFactory) {
            m.f(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public void beforeTask(TaskRunner taskRunner) {
            m.f(taskRunner, "taskRunner");
        }

        public void coordinatorNotify(TaskRunner taskRunner) {
            m.f(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        public void coordinatorWait(TaskRunner taskRunner, long j10) throws InterruptedException {
            m.f(taskRunner, "taskRunner");
            long j11 = j10 / 1000000;
            long j12 = j10 - (1000000 * j11);
            if (j11 > 0 || j10 > 0) {
                taskRunner.wait(j11, (int) j12);
            }
        }

        public void execute(Runnable runnable) {
            m.f(runnable, "runnable");
            this.executor.execute(runnable);
        }

        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        m.e(logger2, "Logger.getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }

    public TaskRunner(Backend backend2) {
        m.f(backend2, "backend");
        this.backend = backend2;
    }

    private final void afterRun(Task task, long j10) {
        boolean z10;
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            TaskQueue queue$okhttp = task.getQueue$okhttp();
            m.c(queue$okhttp);
            if (queue$okhttp.getActiveTask$okhttp() == task) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                boolean cancelActiveTask$okhttp = queue$okhttp.getCancelActiveTask$okhttp();
                queue$okhttp.setCancelActiveTask$okhttp(false);
                queue$okhttp.setActiveTask$okhttp((Task) null);
                this.busyQueues.remove(queue$okhttp);
                if (j10 != -1 && !cancelActiveTask$okhttp && !queue$okhttp.getShutdown$okhttp()) {
                    queue$okhttp.scheduleAndDecide$okhttp(task, j10, true);
                }
                if (!queue$okhttp.getFutureTasks$okhttp().isEmpty()) {
                    this.readyQueues.add(queue$okhttp);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    private final void beforeRun(Task task) {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            task.setNextExecuteNanoTime$okhttp(-1);
            TaskQueue queue$okhttp = task.getQueue$okhttp();
            m.c(queue$okhttp);
            queue$okhttp.getFutureTasks$okhttp().remove(task);
            this.readyQueues.remove(queue$okhttp);
            queue$okhttp.setActiveTask$okhttp(task);
            this.busyQueues.add(queue$okhttp);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    /* access modifiers changed from: private */
    public final void runTask(Task task) {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            Thread currentThread = Thread.currentThread();
            m.e(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(task.getName());
            try {
                long runOnce = task.runOnce();
                synchronized (this) {
                    afterRun(task, runOnce);
                    Unit unit = Unit.f12577a;
                }
                currentThread.setName(name);
            } catch (Throwable th) {
                synchronized (this) {
                    afterRun(task, -1);
                    Unit unit2 = Unit.f12577a;
                    currentThread.setName(name);
                    throw th;
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread2 = Thread.currentThread();
            m.e(currentThread2, "Thread.currentThread()");
            sb2.append(currentThread2.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
    }

    public final List<TaskQueue> activeQueues() {
        List<TaskQueue> j02;
        synchronized (this) {
            j02 = r.j0(this.busyQueues, this.readyQueues);
        }
        return j02;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.internal.concurrent.Task awaitTaskToRun() {
        /*
            r14 = this;
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x0037
            boolean r0 = java.lang.Thread.holdsLock(r14)
            if (r0 == 0) goto L_0x000b
            goto L_0x0037
        L_0x000b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Thread "
            r1.append(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r3 = "Thread.currentThread()"
            kotlin.jvm.internal.m.e(r2, r3)
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " MUST hold lock on "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0037:
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0041
            return r1
        L_0x0041:
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            long r2 = r0.nanoTime()
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            java.util.Iterator r0 = r0.iterator()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r1
        L_0x0053:
            boolean r7 = r0.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0085
            java.lang.Object r7 = r0.next()
            okhttp3.internal.concurrent.TaskQueue r7 = (okhttp3.internal.concurrent.TaskQueue) r7
            java.util.List r7 = r7.getFutureTasks$okhttp()
            java.lang.Object r7 = r7.get(r9)
            okhttp3.internal.concurrent.Task r7 = (okhttp3.internal.concurrent.Task) r7
            long r10 = r7.getNextExecuteNanoTime$okhttp()
            long r10 = r10 - r2
            r12 = 0
            long r10 = java.lang.Math.max(r12, r10)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x007f
            long r4 = java.lang.Math.min(r10, r4)
            goto L_0x0053
        L_0x007f:
            if (r6 == 0) goto L_0x0083
            r0 = r8
            goto L_0x0086
        L_0x0083:
            r6 = r7
            goto L_0x0053
        L_0x0085:
            r0 = r9
        L_0x0086:
            if (r6 == 0) goto L_0x00a4
            r14.beforeRun(r6)
            if (r0 != 0) goto L_0x009c
            boolean r0 = r14.coordinatorWaiting
            if (r0 != 0) goto L_0x00a3
            java.util.List<okhttp3.internal.concurrent.TaskQueue> r0 = r14.readyQueues
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r8
            if (r0 == 0) goto L_0x00a3
        L_0x009c:
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            java.lang.Runnable r1 = r14.runnable
            r0.execute(r1)
        L_0x00a3:
            return r6
        L_0x00a4:
            boolean r0 = r14.coordinatorWaiting
            if (r0 == 0) goto L_0x00b5
            long r6 = r14.coordinatorWakeUpAt
            long r6 = r6 - r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b4
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend
            r0.coordinatorNotify(r14)
        L_0x00b4:
            return r1
        L_0x00b5:
            r14.coordinatorWaiting = r8
            long r2 = r2 + r4
            r14.coordinatorWakeUpAt = r2
            okhttp3.internal.concurrent.TaskRunner$Backend r0 = r14.backend     // Catch:{ InterruptedException -> 0x00c5 }
            r0.coordinatorWait(r14, r4)     // Catch:{ InterruptedException -> 0x00c5 }
        L_0x00bf:
            r14.coordinatorWaiting = r9
            goto L_0x0037
        L_0x00c3:
            r0 = move-exception
            goto L_0x00c9
        L_0x00c5:
            r14.cancelAll()     // Catch:{ all -> 0x00c3 }
            goto L_0x00bf
        L_0x00c9:
            r14.coordinatorWaiting = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskRunner.awaitTaskToRun():okhttp3.internal.concurrent.Task");
    }

    public final void cancelAll() {
        for (int size = this.busyQueues.size() - 1; size >= 0; size--) {
            this.busyQueues.get(size).cancelAllAndDecide$okhttp();
        }
        for (int size2 = this.readyQueues.size() - 1; size2 >= 0; size2--) {
            TaskQueue taskQueue = this.readyQueues.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        m.f(taskQueue, "taskQueue");
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            if (taskQueue.getActiveTask$okhttp() == null) {
                if (!taskQueue.getFutureTasks$okhttp().isEmpty()) {
                    Util.addIfAbsent(this.readyQueues, taskQueue);
                } else {
                    this.readyQueues.remove(taskQueue);
                }
            }
            if (this.coordinatorWaiting) {
                this.backend.coordinatorNotify(this);
            } else {
                this.backend.execute(this.runnable);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
    }

    public final TaskQueue newQueue() {
        int i10;
        synchronized (this) {
            i10 = this.nextQueueName;
            this.nextQueueName = i10 + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('Q');
        sb2.append(i10);
        return new TaskQueue(this, sb2.toString());
    }
}
