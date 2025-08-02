package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1tSDK {
    static final List<String> AFInAppEventParameterName = new ArrayList();
    public static String[] AFKeystoreWrapper;
    private static Intent afDebugLog;
    public Map<String, String> AFInAppEventType;
    @Nullable
    public List<List<String>> afInfoLog = new ArrayList();
    public DeepLinkListener valueOf;
    public String values;

    public static void AFInAppEventParameterName(Intent intent) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null && intent != afDebugLog) {
            afDebugLog = intent;
        }
    }

    static void values(Context context, Map<String, Object> map, Uri uri) {
        AFd1eSDK aFd1eSDK = new AFd1eSDK(context, map, uri, AFInAppEventParameterName);
        AFb1xSDK.AFInAppEventType().values(context);
        AFd1sSDK afDebugLog2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afDebugLog();
        afDebugLog2.AFInAppEventType.execute(new Runnable(aFd1eSDK) {
            private /* synthetic */ AFd1pSDK AFInAppEventType;

            {
                this.AFInAppEventType = r2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
                if (r1 == false) goto L_0x0167;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
                r6.valueOf.valueOf.add(r6.AFInAppEventType.AFInAppEventType);
                r0 = new java.lang.StringBuilder("QUEUE: new task added: ");
                r0.append(r6.AFInAppEventType);
                com.appsflyer.AFLogger.afDebugLog(r0.toString());
                r0 = r6.valueOf.values.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f3, code lost:
                if (r0.hasNext() == false) goto L_0x00fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f5, code lost:
                r1 = r0.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fc, code lost:
                r0 = r6.valueOf;
                r0.AFInAppEventParameterName.submit(r0);
                r0 = r6.valueOf;
                r1 = r0.afRDLog;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0107, code lost:
                monitor-enter(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                r2 = (r0.afRDLog.size() + r0.afDebugLog.size()) - 40;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x0117, code lost:
                if (r2 <= 0) goto L_0x0163;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x0119, code lost:
                r3 = !r0.afDebugLog.isEmpty();
                r4 = !r0.afRDLog.isEmpty();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0129, code lost:
                if (r4 == false) goto L_0x0151;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x012b, code lost:
                if (r3 == false) goto L_0x0151;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
                if (r0.afRDLog.first().AFKeystoreWrapper(r0.afDebugLog.first()) <= 0) goto L_0x014b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0143, code lost:
                r0.AFKeystoreWrapper(r0.afRDLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0149, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x014b, code lost:
                r0.AFKeystoreWrapper(r0.afDebugLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0151, code lost:
                if (r4 == false) goto L_0x0159;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0153, code lost:
                r0.AFKeystoreWrapper(r0.afRDLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x0159, code lost:
                if (r3 == false) goto L_0x0160;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x015b, code lost:
                r0.AFKeystoreWrapper(r0.afDebugLog);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x0160, code lost:
                r2 = r2 - 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0163, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x0164, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0166, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0167, code lost:
                r0 = new java.lang.StringBuilder("QUEUE: tried to add already pending task: ");
                r0.append(r6.AFInAppEventType);
                com.appsflyer.AFLogger.afWarnLog(r0.toString());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x017a, code lost:
                return;
             */
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
                    int r3 = r3.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0149 }
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
        afDebugLog = null;
    }

    /* access modifiers changed from: package-private */
    public final void valueOf(Map<String, Object> map, Intent intent, Context context) {
        AFb1xSDK.AFInAppEventType().values(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFc1ySDK afInfoLog2 = AFKeystoreWrapper2.afInfoLog();
        if (!valueOf(intent, context, map) && this.valueOf != null && AFKeystoreWrapper2.values().valueOf.AFInAppEventType("appsFlyerCount", 0) == 0 && !afInfoLog2.AFKeystoreWrapper("ddl_sent")) {
            AFb1oSDK aFb1oSDK = new AFb1oSDK(context, AFKeystoreWrapper2);
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new Runnable(new AFd1fSDK(aFb1oSDK)) {
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
                        int r3 = r3.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0149 }
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
        afInfoLog2.AFInAppEventType("ddl_sent", true);
    }

    @Nullable
    private Uri values(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException e10) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e10);
                return null;
            }
        }
        return null;
    }

    @VisibleForTesting
    @Nullable
    static Uri valueOf(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean valueOf(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            if (r9 == 0) goto L_0x0014
            java.lang.String r2 = r9.getAction()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            android.net.Uri r2 = r9.getData()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            android.content.Intent r3 = afDebugLog
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = r3.getAction()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0028
            android.net.Uri r0 = r3.getData()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r9 != 0) goto L_0x0031
            java.lang.String r3 = "Could not extract deeplink from null intent"
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x0097
        L_0x0031:
            android.os.Bundle r3 = r9.getExtras()
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afInfoLog
            if (r4 == 0) goto L_0x0097
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0097
            if (r3 != 0) goto L_0x0042
            goto L_0x0097
        L_0x0042:
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afInfoLog
            java.util.Iterator r4 = r4.iterator()
        L_0x0048:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r4.next()
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0058
        L_0x0056:
            r6 = r1
            goto L_0x0074
        L_0x0058:
            java.util.Iterator r6 = r5.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x0063
            goto L_0x0056
        L_0x0063:
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r3.getString(r7)
            if (r7 != 0) goto L_0x0070
            goto L_0x0056
        L_0x0070:
            android.net.Uri r6 = r8.values(r7, r6)
        L_0x0074:
            if (r6 == 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Found deeplink in push payload at "
            r1.<init>(r3)
            java.lang.String r3 = r5.toString()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            java.util.Map r1 = com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r11)
            java.lang.String r3 = "payloadKey"
            java.util.List<java.util.List<java.lang.String>> r4 = r8.afInfoLog
            r1.put(r3, r4)
            r1 = r6
        L_0x0097:
            java.lang.String r3 = " w/af_consumed"
            r4 = 1
            r5 = 0
            java.lang.String r6 = "af_consumed"
            if (r2 == 0) goto L_0x00c9
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x00b0
            long r0 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r0)
            values(r10, r11, r2)
            return r4
        L_0x00b0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r2.toString()
            r9.append(r10)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00c9:
            if (r0 == 0) goto L_0x00f9
            android.content.Intent r9 = afDebugLog
            boolean r9 = r9.hasExtra(r6)
            if (r9 != 0) goto L_0x00e0
            android.content.Intent r9 = afDebugLog
            long r1 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r1)
            values(r10, r11, r0)
            return r4
        L_0x00e0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed trampoline deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r0.toString()
            r9.append(r10)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x00f9:
            if (r1 == 0) goto L_0x0125
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x010c
            long r2 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r2)
            values(r10, r11, r1)
            return r4
        L_0x010c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link from push: "
            r9.<init>(r10)
            java.lang.String r10 = r1.toString()
            r9.append(r10)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.afInfoLog(r9)
            return r5
        L_0x0125:
            java.lang.String r9 = "No deep link detected"
            com.appsflyer.AFLogger.afDebugLog(r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.valueOf(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }
}
