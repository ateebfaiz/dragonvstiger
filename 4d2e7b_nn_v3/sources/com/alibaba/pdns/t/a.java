package com.alibaba.pdns.t;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18268a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private static final String f18269b = "pdns-work-";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f18270c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public static final b f18271d = new c((C0235a) null);

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f18272e = new d((C0235a) null);

    /* renamed from: f  reason: collision with root package name */
    public static b f18273f = null;

    /* renamed from: com.alibaba.pdns.t.a$a  reason: collision with other inner class name */
    static class C0235a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f18274a;

        C0235a(Runnable runnable) {
            this.f18274a = runnable;
        }

        public void run() {
            String a10 = a.d(a.f18269b + a.f18270c.getAndIncrement());
            int b10 = a.c();
            try {
                Runnable runnable = this.f18274a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Exception unused) {
                com.alibaba.pdns.u.a.a("Run task in executor failed");
            }
            a.b(b10);
            a.c(a10);
        }
    }

    public interface b {
        Executor a();
    }

    private static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final HandlerThread f18275a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f18276b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<Runnable, Runnable> f18277c;

        /* synthetic */ c(C0235a aVar) {
            this();
        }

        public void a(Runnable runnable, long j10) {
            if (runnable != null) {
                Runnable a10 = a.b(runnable);
                if (0 < j10) {
                    this.f18277c.put(runnable, a10);
                    this.f18276b.postDelayed(a10, j10);
                    return;
                }
                execute(a10);
            }
        }

        public void execute(Runnable runnable) {
            if (runnable != null) {
                this.f18276b.post(a.b(runnable));
            }
        }

        private c() {
            this.f18277c = new ConcurrentHashMap();
            HandlerThread handlerThread = new HandlerThread("pdns-main");
            this.f18275a = handlerThread;
            handlerThread.start();
            this.f18276b = new Handler(handlerThread.getLooper());
        }

        public void a(Runnable runnable) {
            Runnable runnable2;
            if (runnable != null && (runnable2 = this.f18277c.get(runnable)) != null) {
                this.f18276b.removeCallbacks(runnable2);
            }
        }
    }

    private static class d implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f18278a;

        /* synthetic */ d(C0235a aVar) {
            this();
        }

        public void execute(Runnable runnable) {
            if (runnable != null) {
                this.f18278a.execute(a.b(runnable));
            }
        }

        private d() {
            b bVar = a.f18273f;
            Executor a10 = bVar != null ? bVar.a() : null;
            this.f18278a = a10 == null ? AsyncTask.THREAD_POOL_EXECUTOR : a10;
        }
    }

    /* access modifiers changed from: private */
    public static int c() {
        int i10 = Integer.MIN_VALUE;
        try {
            i10 = Process.getThreadPriority(Process.myTid());
            if (10 != i10) {
                Process.setThreadPriority(10);
            }
        } catch (Exception e10) {
            com.alibaba.pdns.u.a.b("exception: %s", e10.getMessage());
        }
        return i10;
    }

    /* access modifiers changed from: private */
    public static String d(String str) {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(str);
        return name;
    }

    /* access modifiers changed from: private */
    public static Runnable b(Runnable runnable) {
        return new C0235a(runnable);
    }

    /* access modifiers changed from: private */
    public static void b(int i10) {
        if (Integer.MIN_VALUE != i10) {
            try {
                if (i10 != Process.getThreadPriority(Process.myTid())) {
                    Process.setThreadPriority(i10);
                }
            } catch (Exception e10) {
                com.alibaba.pdns.u.a.b("exception: %s", e10.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(String str) {
        Thread.currentThread().setName(str);
    }
}
