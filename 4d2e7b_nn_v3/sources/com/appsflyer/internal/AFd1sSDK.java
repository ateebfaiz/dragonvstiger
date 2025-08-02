package com.appsflyer.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class AFd1sSDK implements Runnable {
    final ExecutorService AFInAppEventParameterName;
    public Executor AFInAppEventType = Executors.newSingleThreadExecutor();
    final Set<AFd1rSDK> AFKeystoreWrapper = new CopyOnWriteArraySet();
    final List<AFd1pSDK<?>> AFLogger = new ArrayList();
    final NavigableSet<AFd1pSDK<?>> afDebugLog = new ConcurrentSkipListSet();
    private Timer afErrorLog = new Timer(true);
    final Set<AFd1pSDK<?>> afInfoLog = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFd1pSDK<?>> afRDLog = new ConcurrentSkipListSet();
    final Set<AFd1rSDK> valueOf = Collections.newSetFromMap(new ConcurrentHashMap());
    public final List<AFd1uSDK> values = new CopyOnWriteArrayList();

    public AFd1sSDK(ExecutorService executorService) {
        this.AFInAppEventParameterName = executorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        r2 = r1.valueOf();
        r0 = new com.appsflyer.internal.AFd1oSDK(java.lang.Thread.currentThread());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r2 <= 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r6.afErrorLog.schedule(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r6.AFInAppEventType.execute(new com.appsflyer.internal.AFd1sSDK.AnonymousClass4(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r6.afRDLog.isEmpty() != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r6.AFInAppEventParameterName.submit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: starting task execution: ".concat(java.lang.String.valueOf(r1)));
        r2 = r1.afDebugLog();
        r0.cancel();
        r6.AFInAppEventType.execute(new com.appsflyer.internal.AFd1sSDK.AnonymousClass1(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r0.cancel();
        r0 = com.appsflyer.internal.AFd1tSDK.AFInAppEventParameterName;
        r6.AFInAppEventType.execute(new com.appsflyer.internal.AFd1sSDK.AnonymousClass1(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        com.appsflyer.AFLogger.afDebugLog("QUEUE: task was interrupted: ".concat(java.lang.String.valueOf(r1)));
        r0 = com.appsflyer.internal.AFd1tSDK.AFKeystoreWrapper;
        r1.valueOf = r0;
        r6.AFInAppEventType.execute(new com.appsflyer.internal.AFd1sSDK.AnonymousClass1(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r0 = r6.afRDLog
            monitor-enter(r0)
            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r6.afRDLog     // Catch:{ all -> 0x000f }
            java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x000f }
            com.appsflyer.internal.AFd1pSDK r1 = (com.appsflyer.internal.AFd1pSDK) r1     // Catch:{ all -> 0x000f }
            if (r1 != 0) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r1 = move-exception
            goto L_0x0092
        L_0x0012:
            java.util.Set<com.appsflyer.internal.AFd1pSDK<?>> r2 = r6.afInfoLog     // Catch:{ all -> 0x000f }
            r2.add(r1)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            long r2 = r1.valueOf()
            com.appsflyer.internal.AFd1oSDK r0 = new com.appsflyer.internal.AFd1oSDK
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r0.<init>(r4)
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0030
            java.util.Timer r4 = r6.afErrorLog
            r4.schedule(r0, r2)
        L_0x0030:
            java.util.concurrent.Executor r2 = r6.AFInAppEventType
            com.appsflyer.internal.AFd1sSDK$4 r3 = new com.appsflyer.internal.AFd1sSDK$4
            r3.<init>(r1)
            r2.execute(r3)
            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r2 = r6.afRDLog
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            java.util.concurrent.ExecutorService r2 = r6.AFInAppEventParameterName
            r2.submit(r6)
        L_0x0047:
            java.lang.String r2 = "QUEUE: starting task execution: "
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            com.appsflyer.internal.AFd1tSDK r2 = r1.call()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            r0.cancel()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            java.util.concurrent.Executor r3 = r6.AFInAppEventType     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            com.appsflyer.internal.AFd1sSDK$1 r4 = new com.appsflyer.internal.AFd1sSDK$1     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            r4.<init>(r1, r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            r3.execute(r4)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0076, all -> 0x0066 }
            return
        L_0x0066:
            r0.cancel()
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.FAILURE
            java.util.concurrent.Executor r2 = r6.AFInAppEventType
            com.appsflyer.internal.AFd1sSDK$1 r3 = new com.appsflyer.internal.AFd1sSDK$1
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x0076:
            java.lang.String r0 = "QUEUE: task was interrupted: "
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r2)
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.TIMEOUT
            r1.valueOf = r0
            java.util.concurrent.Executor r2 = r6.AFInAppEventType
            com.appsflyer.internal.AFd1sSDK$1 r3 = new com.appsflyer.internal.AFd1sSDK$1
            r3.<init>(r1, r0)
            r2.execute(r3)
            return
        L_0x0092:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1sSDK.run():void");
    }

    /* access modifiers changed from: package-private */
    public final void AFKeystoreWrapper(NavigableSet<AFd1pSDK<?>> navigableSet) {
        AFd1pSDK pollFirst = navigableSet.pollFirst();
        this.AFKeystoreWrapper.add(pollFirst.AFInAppEventType);
        for (AFd1uSDK AFInAppEventParameterName2 : this.values) {
            AFInAppEventParameterName2.AFInAppEventParameterName(pollFirst);
        }
    }

    /* access modifiers changed from: private */
    public boolean AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
        return this.AFKeystoreWrapper.containsAll(aFd1pSDK.values);
    }

    static /* synthetic */ void AFKeystoreWrapper(AFd1sSDK aFd1sSDK) {
        synchronized (aFd1sSDK.afRDLog) {
            try {
                Iterator<AFd1pSDK<?>> it = aFd1sSDK.afDebugLog.iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    AFd1pSDK next = it.next();
                    if (aFd1sSDK.AFKeystoreWrapper((AFd1pSDK<?>) next)) {
                        it.remove();
                        aFd1sSDK.afRDLog.add(next);
                        z10 = true;
                    }
                }
                if (z10) {
                    aFd1sSDK.AFInAppEventParameterName.submit(aFd1sSDK);
                }
            } finally {
            }
        }
    }
}
