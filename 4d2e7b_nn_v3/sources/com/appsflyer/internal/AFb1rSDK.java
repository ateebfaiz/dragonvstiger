package com.appsflyer.internal;

import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class AFb1rSDK implements AFd1uSDK {
    public final AFe1qSDK AFInAppEventParameterName;
    private final AFe1ySDK AFInAppEventType;
    private final AFc1zSDK AFKeystoreWrapper;
    private final AFc1kSDK AFLogger;
    @Nullable
    private AFe1vSDK afDebugLog;
    @Nullable
    private AFb1cSDK afErrorLog;
    private final AFe1sSDK afInfoLog;
    private final AFd1sSDK afRDLog;
    private final Object valueOf;
    private final AFe1nSDK values;

    public AFb1rSDK() {
    }

    public static Map<String, String> AFInAppEventParameterName(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            try {
                hashMap.put(URLEncoder.encode((String) next.getKey(), "utf-8"), URLEncoder.encode((String) next.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e10) {
                AFLogger.afErrorLogForExcManagerOnly("failed to encode map", e10);
            }
        }
        return hashMap;
    }

    @Nullable
    public final AFb1cSDK AFInAppEventType() {
        AFb1cSDK aFb1cSDK;
        synchronized (this.valueOf) {
            aFb1cSDK = this.afErrorLog;
            this.afErrorLog = null;
        }
        return aFb1cSDK;
    }

    public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
    }

    public final void values(AFe1xSDK aFe1xSDK) {
        AFe1wSDK aFe1wSDK = new AFe1wSDK(this.AFInAppEventType, this.AFKeystoreWrapper, this.values, this.AFInAppEventParameterName, this.AFLogger, this.afInfoLog, "v1", aFe1xSDK);
        AFd1sSDK aFd1sSDK = this.afRDLog;
        aFd1sSDK.AFInAppEventType.execute(new Runnable(aFe1wSDK) {
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
    }

    public AFb1rSDK(AFe1ySDK aFe1ySDK, AFc1zSDK aFc1zSDK, AFe1nSDK aFe1nSDK, AFe1qSDK aFe1qSDK, AFc1kSDK aFc1kSDK, AFe1sSDK aFe1sSDK, AFd1sSDK aFd1sSDK) {
        this.valueOf = new Object();
        this.AFInAppEventType = aFe1ySDK;
        this.AFKeystoreWrapper = aFc1zSDK;
        this.values = aFe1nSDK;
        this.AFInAppEventParameterName = aFe1qSDK;
        this.AFLogger = aFc1kSDK;
        this.afInfoLog = aFe1sSDK;
        this.afRDLog = aFd1sSDK;
        aFd1sSDK.values.add(this);
    }

    private void AFKeystoreWrapper(AFe1vSDK aFe1vSDK, AFe1xSDK aFe1xSDK) {
        synchronized (this.valueOf) {
            this.afDebugLog = aFe1vSDK;
        }
        if (aFe1xSDK != null) {
            aFe1xSDK.onRemoteConfigUpdateFinished(aFe1vSDK);
        }
    }

    public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK, AFd1tSDK aFd1tSDK) {
        if (aFd1pSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1pSDK;
            AFe1vSDK aFe1vSDK = aFe1wSDK.afRDLog;
            if (aFe1vSDK == null) {
                AFLogger.afWarnLog("CFG: update RC returned null result, something went wrong!");
                aFe1vSDK = AFe1vSDK.FAILURE;
            }
            if (aFe1vSDK != AFe1vSDK.USE_CACHED) {
                AFb1cSDK aFb1cSDK = aFe1wSDK.AFLogger;
                synchronized (this.valueOf) {
                    this.afErrorLog = aFb1cSDK;
                }
            }
            AFKeystoreWrapper(aFe1vSDK, aFe1wSDK.afErrorLog);
        }
    }

    public final void AFInAppEventParameterName(AFd1pSDK<?> aFd1pSDK) {
        if (aFd1pSDK instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) aFd1pSDK;
            synchronized (this.valueOf) {
                this.afErrorLog = null;
            }
            AFKeystoreWrapper(AFe1vSDK.FAILURE, aFe1wSDK.afErrorLog);
        }
    }
}
