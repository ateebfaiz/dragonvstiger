package com.appsflyer.internal;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.appsflyer.AFLogger;

public final class AFd1gSDK extends AFd1pSDK<Boolean> {
    private static volatile boolean afRDLog;
    private final AFd1sSDK AFLogger;
    private final AFc1vSDK afDebugLog;
    private Boolean afErrorLog;
    private final AFb1zSDK afInfoLog;

    public AFd1gSDK(@NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.LOAD_CACHE, new AFd1rSDK[0], "LoadCachedRequests");
        this.afInfoLog = aFc1vSDK.afWarnLog();
        this.AFLogger = aFc1vSDK.afDebugLog();
        this.afDebugLog = aFc1vSDK;
    }

    public static boolean AFLogger() {
        return afRDLog;
    }

    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        for (AFa1oSDK next : this.afInfoLog.AFKeystoreWrapper()) {
            StringBuilder sb2 = new StringBuilder("CACHE: resending request: ");
            sb2.append(next.values);
            AFLogger.afInfoLog(sb2.toString());
            try {
                AFe1aSDK aFe1aSDK = new AFe1aSDK(AFInAppEventType(next), next.valueOf(), next.AFInAppEventType, next.valueOf);
                AFd1sSDK aFd1sSDK = this.AFLogger;
                aFd1sSDK.AFInAppEventType.execute(new Runnable(new AFd1bSDK(aFe1aSDK, this.afDebugLog)) {
                    private /* synthetic */ AFd1pSDK AFInAppEventType;

                    {
                        this.AFInAppEventType = r2;
                    }

                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r6 = this;
                            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r0 = r0.afRDLog
                            monitor-enter(r0)
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.Set<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                            if (r1 == 0) goto L_0x0029
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                            java.lang.String r2 = "QUEUE: tried to add already running task: "
                            r1.<init>(r2)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            r1.append(r2)     // Catch:{ all -> 0x0026 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0026 }
                            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0026 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                            return
                        L_0x0026:
                            r1 = move-exception
                            goto L_0x0190
                        L_0x0029:
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                            if (r1 != 0) goto L_0x017b
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                            if (r1 == 0) goto L_0x0043
                            goto L_0x017b
                        L_0x0043:
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            java.util.Set<com.appsflyer.internal.AFd1rSDK> r3 = r2.AFKeystoreWrapper     // Catch:{ all -> 0x0026 }
                            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0026 }
                        L_0x004d:
                            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0026 }
                            if (r4 == 0) goto L_0x0067
                            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1rSDK r4 = (com.appsflyer.internal.AFd1rSDK) r4     // Catch:{ all -> 0x0026 }
                            java.util.Set<com.appsflyer.internal.AFd1rSDK> r5 = r1.valueOf     // Catch:{ all -> 0x0026 }
                            boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0026 }
                            if (r5 == 0) goto L_0x004d
                            java.util.Set<com.appsflyer.internal.AFd1rSDK> r5 = r2.values     // Catch:{ all -> 0x0026 }
                            r5.add(r4)     // Catch:{ all -> 0x0026 }
                            goto L_0x004d
                        L_0x0067:
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.AFKeystoreWrapper((com.appsflyer.internal.AFd1pSDK<?>) r2)     // Catch:{ all -> 0x0026 }
                            if (r1 == 0) goto L_0x007c
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0026 }
                            goto L_0x00a0
                        L_0x007c:
                            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0026 }
                            if (r1 == 0) goto L_0x00a0
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                            java.lang.String r3 = "QUEUE: new task was blocked: "
                            r2.<init>(r3)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r3 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            r2.append(r3)     // Catch:{ all -> 0x0026 }
                            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0026 }
                            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            r2.AFInAppEventParameterName()     // Catch:{ all -> 0x0026 }
                        L_0x00a0:
                            if (r1 == 0) goto L_0x00b3
                            com.appsflyer.internal.AFd1sSDK r2 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r2.afRDLog     // Catch:{ all -> 0x0026 }
                            java.util.List<com.appsflyer.internal.AFd1pSDK<?>> r2 = r2.AFLogger     // Catch:{ all -> 0x0026 }
                            r3.addAll(r2)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1sSDK r2 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                            java.util.List<com.appsflyer.internal.AFd1pSDK<?>> r2 = r2.AFLogger     // Catch:{ all -> 0x0026 }
                            r2.clear()     // Catch:{ all -> 0x0026 }
                            goto L_0x00c6
                        L_0x00b3:
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                            java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                            r2.<init>(r3)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r3 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            r2.append(r3)     // Catch:{ all -> 0x0026 }
                            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0026 }
                            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0026 }
                        L_0x00c6:
                            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                            if (r1 == 0) goto L_0x0167
                            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                            java.util.Set<com.appsflyer.internal.AFd1rSDK> r0 = r0.valueOf
                            com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                            com.appsflyer.internal.AFd1rSDK r1 = r1.AFInAppEventType
                            r0.add(r1)
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r1 = "QUEUE: new task added: "
                            r0.<init>(r1)
                            com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.appsflyer.AFLogger.afDebugLog(r0)
                            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                            java.util.List<com.appsflyer.internal.AFd1uSDK> r0 = r0.values
                            java.util.Iterator r0 = r0.iterator()
                        L_0x00ef:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x00fc
                            java.lang.Object r1 = r0.next()
                            com.appsflyer.internal.AFd1uSDK r1 = (com.appsflyer.internal.AFd1uSDK) r1
                            goto L_0x00ef
                        L_0x00fc:
                            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                            java.util.concurrent.ExecutorService r1 = r0.AFInAppEventParameterName
                            r1.submit(r0)
                            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r0.afRDLog
                            monitor-enter(r1)
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r2 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                            int r2 = r2.size()     // Catch:{ all -> 0x0149 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                            int r3 = r3.size()     // Catch:{ all -> 0x0149 }
                            int r2 = r2 + r3
                            int r2 = r2 + -40
                        L_0x0117:
                            if (r2 <= 0) goto L_0x0163
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0149 }
                            r3 = r3 ^ 1
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r4 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0149 }
                            r4 = r4 ^ 1
                            if (r4 == 0) goto L_0x0151
                            if (r3 == 0) goto L_0x0151
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                            java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0149 }
                            com.appsflyer.internal.AFd1pSDK r3 = (com.appsflyer.internal.AFd1pSDK) r3     // Catch:{ all -> 0x0149 }
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r4 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                            java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0149 }
                            com.appsflyer.internal.AFd1pSDK r4 = (com.appsflyer.internal.AFd1pSDK) r4     // Catch:{ all -> 0x0149 }
                            int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0149 }
                            if (r3 <= 0) goto L_0x014b
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                            r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                            goto L_0x0160
                        L_0x0149:
                            r0 = move-exception
                            goto L_0x0165
                        L_0x014b:
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                            r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                            goto L_0x0160
                        L_0x0151:
                            if (r4 == 0) goto L_0x0159
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                            r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                            goto L_0x0160
                        L_0x0159:
                            if (r3 == 0) goto L_0x0160
                            java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                            r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                        L_0x0160:
                            int r2 = r2 + -1
                            goto L_0x0117
                        L_0x0163:
                            monitor-exit(r1)     // Catch:{ all -> 0x0149 }
                            return
                        L_0x0165:
                            monitor-exit(r1)
                            throw r0
                        L_0x0167:
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r1 = "QUEUE: tried to add already pending task: "
                            r0.<init>(r1)
                            com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.appsflyer.AFLogger.afWarnLog(r0)
                            return
                        L_0x017b:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                            java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                            r1.<init>(r2)     // Catch:{ all -> 0x0026 }
                            com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                            r1.append(r2)     // Catch:{ all -> 0x0026 }
                            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0026 }
                            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0026 }
                            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                            return
                        L_0x0190:
                            monitor-exit(r0)
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1sSDK.AnonymousClass3.run():void");
                    }
                });
            } catch (Exception e10) {
                AFLogger.afErrorLog("QUEUE: Failed to resend cached request", e10);
            }
        }
        this.afErrorLog = Boolean.TRUE;
        afRDLog = true;
        return AFd1tSDK.SUCCESS;
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    public final long valueOf() {
        return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    }

    private static String AFInAppEventType(AFa1oSDK aFa1oSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(aFa1oSDK.AFInAppEventType, 10);
        String str = aFa1oSDK.values;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", "true").appendQueryParameter("timeincache", String.valueOf((currentTimeMillis - parseLong) / 1000)).toString();
        } catch (Exception e10) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e10);
            return str;
        }
    }
}
