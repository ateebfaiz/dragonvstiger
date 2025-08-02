package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7883a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Queue f7884b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7885c;

    x() {
    }

    public final void a(w wVar) {
        synchronized (this.f7883a) {
            try {
                if (this.f7884b == null) {
                    this.f7884b = new ArrayDeque();
                }
                this.f7884b.add(wVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.f7883a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = (com.google.android.gms.tasks.w) r2.f7884b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.f7885c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        r0.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002a, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.gms.tasks.Task r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f7883a
            monitor-enter(r0)
            java.util.Queue r1 = r2.f7884b     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x002d
            boolean r1 = r2.f7885c     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x000c
            goto L_0x002d
        L_0x000c:
            r1 = 1
            r2.f7885c = r1     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
        L_0x0010:
            java.lang.Object r1 = r2.f7883a
            monitor-enter(r1)
            java.util.Queue r0 = r2.f7884b     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0022 }
            com.google.android.gms.tasks.w r0 = (com.google.android.gms.tasks.w) r0     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            r3 = 0
            r2.f7885c = r3     // Catch:{ all -> 0x0022 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r3 = move-exception
            goto L_0x0029
        L_0x0024:
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            r0.a(r3)
            goto L_0x0010
        L_0x0029:
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            throw r3
        L_0x002b:
            r3 = move-exception
            goto L_0x002f
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.x.b(com.google.android.gms.tasks.Task):void");
    }
}
