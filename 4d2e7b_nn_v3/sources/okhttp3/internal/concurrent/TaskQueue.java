package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;

public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks = new ArrayList();
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public TaskQueue(TaskRunner taskRunner2, String str) {
        m.f(taskRunner2, "taskRunner");
        m.f(str, "name");
        this.taskRunner = taskRunner2;
        this.name = str;
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j10, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        m.f(str, "name");
        m.f(function0, "block");
        taskQueue.schedule(new TaskQueue$execute$1(function0, str, z11, str, z11), j10);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        taskQueue.schedule(task, j10);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                try {
                    if (cancelAllAndDecide$okhttp()) {
                        this.taskRunner.kickCoordinator$okhttp(this);
                    }
                    Unit unit = Unit.f12577a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            m.c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z10 = false;
        for (int size = this.futureTasks.size() - 1; size >= 0; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final void execute(String str, long j10, boolean z10, Function0<Unit> function0) {
        m.f(str, "name");
        m.f(function0, "block");
        schedule(new TaskQueue$execute$1(function0, str, z10, str, z10), j10);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> w02;
        synchronized (this.taskRunner) {
            w02 = r.w0(this.futureTasks);
        }
        return w02;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask != null || !this.futureTasks.isEmpty()) {
                Task task = this.activeTask;
                if (task instanceof AwaitIdleTask) {
                    CountDownLatch latch = ((AwaitIdleTask) task).getLatch();
                    return latch;
                }
                for (Task next : this.futureTasks) {
                    if (next instanceof AwaitIdleTask) {
                        CountDownLatch latch2 = ((AwaitIdleTask) next).getLatch();
                        return latch2;
                    }
                }
                AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(awaitIdleTask, 0, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                CountDownLatch latch3 = awaitIdleTask.getLatch();
                return latch3;
            }
            CountDownLatch countDownLatch = new CountDownLatch(0);
            return countDownLatch;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(okhttp3.internal.concurrent.Task r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.m.f(r3, r0)
            okhttp3.internal.concurrent.TaskRunner r0 = r2.taskRunner
            monitor-enter(r0)
            boolean r1 = r2.shutdown     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0043
            boolean r4 = r3.getCancelable()     // Catch:{ all -> 0x0026 }
            if (r4 == 0) goto L_0x002a
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0026 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0026 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0026 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0026 }
            if (r4 == 0) goto L_0x0028
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r3 = move-exception
            goto L_0x0053
        L_0x0028:
            monitor-exit(r0)
            return
        L_0x002a:
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0026 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0026 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0026 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0026 }
            if (r4 == 0) goto L_0x003d
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0026 }
        L_0x003d:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0026 }
            r3.<init>()     // Catch:{ all -> 0x0026 }
            throw r3     // Catch:{ all -> 0x0026 }
        L_0x0043:
            r1 = 0
            boolean r3 = r2.scheduleAndDecide$okhttp(r3, r4, r1)     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x004f
            okhttp3.internal.concurrent.TaskRunner r3 = r2.taskRunner     // Catch:{ all -> 0x0026 }
            r3.kickCoordinator$okhttp(r2)     // Catch:{ all -> 0x0026 }
        L_0x004f:
            kotlin.Unit r3 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0026 }
            monitor-exit(r0)
            return
        L_0x0053:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.schedule(okhttp3.internal.concurrent.Task, long):void");
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j10, boolean z10) {
        String str;
        m.f(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j11 = nanoTime + j10;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j11) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j11);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z10) {
                str = "run again after " + TaskLoggerKt.formatDuration(j11 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j11 - nanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j10) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            i10 = this.futureTasks.size();
        }
        this.futureTasks.add(i10, task);
        if (i10 == 0) {
            return true;
        }
        return false;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z10) {
        this.cancelActiveTask = z10;
    }

    public final void setShutdown$okhttp(boolean z10) {
        this.shutdown = z10;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                try {
                    this.shutdown = true;
                    if (cancelAllAndDecide$okhttp()) {
                        this.taskRunner.kickCoordinator$okhttp(this);
                    }
                    Unit unit = Unit.f12577a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        m.f(str, "name");
        m.f(function0, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(function0, str, str), j10);
    }

    public final void schedule(String str, long j10, Function0<Long> function0) {
        m.f(str, "name");
        m.f(function0, "block");
        schedule(new TaskQueue$schedule$2(function0, str, str), j10);
    }
}
