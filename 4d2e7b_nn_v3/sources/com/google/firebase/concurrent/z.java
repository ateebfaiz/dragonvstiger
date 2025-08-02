package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

final class z implements Executor {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f9067f = Logger.getLogger(z.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Executor f9068a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Deque f9069b = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f9070c = c.IDLE;

    /* renamed from: d  reason: collision with root package name */
    private long f9071d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final b f9072e = new b(this, (a) null);

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f9073a;

        a(Runnable runnable) {
            this.f9073a = runnable;
        }

        public void run() {
            this.f9073a.run();
        }

        public String toString() {
            return this.f9073a.toString();
        }
    }

    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Runnable f9075a;

        private b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r8.f9075a.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0062, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            com.google.firebase.concurrent.z.e().log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f9075a, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                com.google.firebase.concurrent.z r2 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x005e }
                java.util.Deque r2 = r2.f9069b     // Catch:{ all -> 0x005e }
                monitor-enter(r2)     // Catch:{ all -> 0x005e }
                if (r0 != 0) goto L_0x002d
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z$c r0 = r0.f9070c     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.RUNNING     // Catch:{ all -> 0x0020 }
                if (r0 != r3) goto L_0x0022
                monitor-exit(r2)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x001f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x001f:
                return
            L_0x0020:
                r0 = move-exception
                goto L_0x0083
            L_0x0022:
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z.d(r0)     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z.c unused = r0.f9070c = r3     // Catch:{ all -> 0x0020 }
                r0 = 1
            L_0x002d:
                com.google.firebase.concurrent.z r3 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x0020 }
                java.util.Deque r3 = r3.f9069b     // Catch:{ all -> 0x0020 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0020 }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x0020 }
                r8.f9075a = r3     // Catch:{ all -> 0x0020 }
                if (r3 != 0) goto L_0x004f
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.IDLE     // Catch:{ all -> 0x0020 }
                com.google.firebase.concurrent.z.c unused = r0.f9070c = r3     // Catch:{ all -> 0x0020 }
                monitor-exit(r2)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x004e
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x004e:
                return
            L_0x004f:
                monitor-exit(r2)     // Catch:{ all -> 0x0020 }
                boolean r2 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x005e }
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r8.f9075a     // Catch:{ RuntimeException -> 0x0062 }
                r3.run()     // Catch:{ RuntimeException -> 0x0062 }
            L_0x005b:
                r8.f9075a = r2     // Catch:{ all -> 0x005e }
                goto L_0x0002
            L_0x005e:
                r0 = move-exception
                goto L_0x0085
            L_0x0060:
                r0 = move-exception
                goto L_0x0080
            L_0x0062:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.z.f9067f     // Catch:{ all -> 0x0060 }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0060 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
                r6.<init>()     // Catch:{ all -> 0x0060 }
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch:{ all -> 0x0060 }
                java.lang.Runnable r7 = r8.f9075a     // Catch:{ all -> 0x0060 }
                r6.append(r7)     // Catch:{ all -> 0x0060 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0060 }
                r4.log(r5, r6, r3)     // Catch:{ all -> 0x0060 }
                goto L_0x005b
            L_0x0080:
                r8.f9075a = r2     // Catch:{ all -> 0x005e }
                throw r0     // Catch:{ all -> 0x005e }
            L_0x0083:
                monitor-exit(r2)     // Catch:{ all -> 0x0020 }
                throw r0     // Catch:{ all -> 0x005e }
            L_0x0085:
                if (r1 == 0) goto L_0x008e
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x008e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.z.b.a():void");
        }

        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (z.this.f9069b) {
                    c unused = z.this.f9070c = c.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f9075a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + z.this.f9070c + "}";
        }

        /* synthetic */ b(z zVar, a aVar) {
            this();
        }
    }

    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    z(Executor executor) {
        this.f9068a = (Executor) Preconditions.checkNotNull(executor);
    }

    static /* synthetic */ long d(z zVar) {
        long j10 = zVar.f9071d;
        zVar.f9071d = 1 + j10;
        return j10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r7.f9068a.execute(r7.f9072e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r7.f9070c == r8) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        r0 = r7.f9069b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r7.f9071d != r3) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (r7.f9070c != r8) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r7.f9070c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        monitor-enter(r7.f9069b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r0 = r7.f9070c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004e, code lost:
        if (r0 != com.google.firebase.concurrent.z.c.f9077a) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        if (r0 == com.google.firebase.concurrent.z.c.f9078b) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0055, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005d, code lost:
        if (r7.f9069b.removeLastOccurrence(r1) != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0061, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0064, code lost:
        if ((r8 instanceof java.util.concurrent.RejectedExecutionException) != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006a, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006c, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0066 A[ADDED_TO_REGION, Catch:{ Error | RuntimeException -> 0x0044, all -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(java.lang.Runnable r8) {
        /*
            r7 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.util.Deque r0 = r7.f9069b
            monitor-enter(r0)
            com.google.firebase.concurrent.z$c r1 = r7.f9070c     // Catch:{ all -> 0x006d }
            com.google.firebase.concurrent.z$c r2 = com.google.firebase.concurrent.z.c.RUNNING     // Catch:{ all -> 0x006d }
            if (r1 == r2) goto L_0x006f
            com.google.firebase.concurrent.z$c r2 = com.google.firebase.concurrent.z.c.QUEUED     // Catch:{ all -> 0x006d }
            if (r1 != r2) goto L_0x0011
            goto L_0x006f
        L_0x0011:
            long r3 = r7.f9071d     // Catch:{ all -> 0x006d }
            com.google.firebase.concurrent.z$a r1 = new com.google.firebase.concurrent.z$a     // Catch:{ all -> 0x006d }
            r1.<init>(r8)     // Catch:{ all -> 0x006d }
            java.util.Deque r8 = r7.f9069b     // Catch:{ all -> 0x006d }
            r8.add(r1)     // Catch:{ all -> 0x006d }
            com.google.firebase.concurrent.z$c r8 = com.google.firebase.concurrent.z.c.QUEUING     // Catch:{ all -> 0x006d }
            r7.f9070c = r8     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            java.util.concurrent.Executor r0 = r7.f9068a     // Catch:{ RuntimeException -> 0x0046, Error -> 0x0044 }
            com.google.firebase.concurrent.z$b r5 = r7.f9072e     // Catch:{ RuntimeException -> 0x0046, Error -> 0x0044 }
            r0.execute(r5)     // Catch:{ RuntimeException -> 0x0046, Error -> 0x0044 }
            com.google.firebase.concurrent.z$c r0 = r7.f9070c
            if (r0 == r8) goto L_0x002e
            return
        L_0x002e:
            java.util.Deque r0 = r7.f9069b
            monitor-enter(r0)
            long r5 = r7.f9071d     // Catch:{ all -> 0x003e }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0040
            com.google.firebase.concurrent.z$c r1 = r7.f9070c     // Catch:{ all -> 0x003e }
            if (r1 != r8) goto L_0x0040
            r7.f9070c = r2     // Catch:{ all -> 0x003e }
            goto L_0x0040
        L_0x003e:
            r8 = move-exception
            goto L_0x0042
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r8
        L_0x0044:
            r8 = move-exception
            goto L_0x0047
        L_0x0046:
            r8 = move-exception
        L_0x0047:
            java.util.Deque r2 = r7.f9069b
            monitor-enter(r2)
            com.google.firebase.concurrent.z$c r0 = r7.f9070c     // Catch:{ all -> 0x0055 }
            com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.IDLE     // Catch:{ all -> 0x0055 }
            if (r0 == r3) goto L_0x0057
            com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.QUEUING     // Catch:{ all -> 0x0055 }
            if (r0 != r3) goto L_0x0061
            goto L_0x0057
        L_0x0055:
            r8 = move-exception
            goto L_0x006b
        L_0x0057:
            java.util.Deque r0 = r7.f9069b     // Catch:{ all -> 0x0055 }
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x006a
            if (r0 != 0) goto L_0x006a
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            return
        L_0x006a:
            throw r8     // Catch:{ all -> 0x0055 }
        L_0x006b:
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            throw r8
        L_0x006d:
            r8 = move-exception
            goto L_0x0076
        L_0x006f:
            java.util.Deque r1 = r7.f9069b     // Catch:{ all -> 0x006d }
            r1.add(r8)     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.z.execute(java.lang.Runnable):void");
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f9068a + "}";
    }
}
