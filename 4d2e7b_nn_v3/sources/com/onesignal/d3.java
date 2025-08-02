package com.onesignal;

import com.onesignal.o3;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class d3 {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f10598a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f10599b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f10600c;

    /* renamed from: d  reason: collision with root package name */
    protected final c2 f10601d;

    class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("OS_PENDING_EXECUTOR_" + thread.getId());
            return thread;
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private d3 f10603a;

        /* renamed from: b  reason: collision with root package name */
        private Runnable f10604b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f10605c;

        b(d3 d3Var, Runnable runnable) {
            this.f10603a = d3Var;
            this.f10604b = runnable;
        }

        public void run() {
            this.f10604b.run();
            this.f10603a.d(this.f10605c);
        }

        public String toString() {
            return "PendingTaskRunnable{innerTask=" + this.f10604b + ", taskId=" + this.f10605c + '}';
        }
    }

    d3(c2 c2Var) {
        this.f10601d = c2Var;
    }

    private void b(b bVar) {
        synchronized (this.f10598a) {
            try {
                long unused = bVar.f10605c = this.f10599b.incrementAndGet();
                ExecutorService executorService = this.f10600c;
                if (executorService == null) {
                    c2 c2Var = this.f10601d;
                    c2Var.b("Adding a task to the pending queue with ID: " + bVar.f10605c);
                    this.f10598a.add(bVar);
                } else if (!executorService.isShutdown()) {
                    c2 c2Var2 = this.f10601d;
                    c2Var2.b("Executor is still running, add to the executor with ID: " + bVar.f10605c);
                    this.f10600c.submit(bVar);
                }
            } catch (RejectedExecutionException e10) {
                c2 c2Var3 = this.f10601d;
                c2Var3.f("Executor is shutdown, running task manually with ID: " + bVar.f10605c);
                bVar.run();
                e10.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(long j10) {
        if (this.f10599b.get() == j10) {
            o3.a(o3.v.INFO, "Last Pending Task has ran, shutting down");
            this.f10600c.shutdown();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Runnable runnable) {
        b(new b(this, runnable));
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        if (Thread.currentThread().getName().contains("OS_PENDING_EXECUTOR_")) {
            return false;
        }
        if (o3.P0() && this.f10600c == null) {
            return false;
        }
        if (o3.P0() || this.f10600c != null) {
            return !this.f10600c.isShutdown();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        synchronized (this.f10598a) {
            try {
                o3.v vVar = o3.v.DEBUG;
                o3.a(vVar, "startPendingTasks with task queue quantity: " + this.f10598a.size());
                if (!this.f10598a.isEmpty()) {
                    this.f10600c = Executors.newSingleThreadExecutor(new a());
                    while (!this.f10598a.isEmpty()) {
                        this.f10600c.submit((Runnable) this.f10598a.poll());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
