package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatDelegate;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.zing.zalo.zalosdk.common.Constant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class AFb1tSDK implements AFb1sSDK {
    private static int AFLogger = 125;
    private static short[] AFLogger$LogLevel = null;
    private static int AFVersionDeclaration = 0;
    private static byte[] afErrorLogForExcManagerOnly = {20, -83, 11, -70, 0};
    private static int afRDLog = -146565613;
    private static int afWarnLog = -1891164548;
    private static int getLevel = 1;
    @NonNull
    private final Map<String, Object> AFInAppEventParameterName = new HashMap();
    private int AFInAppEventType = 0;
    private boolean AFKeystoreWrapper = true;
    private boolean afDebugLog = false;
    private String afErrorLog = "-1";
    private boolean afInfoLog = (true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false));
    private final String valueOf = "yyyy-MM-dd HH:mm:ssZ";
    private List<String> values = new ArrayList();

    private synchronized void AFInAppEventType(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.AFInAppEventParameterName.put(Constant.PARAM_APP_ID, str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null) {
            int i10 = getLevel + 91;
            AFVersionDeclaration = i10 % 128;
            if (i10 % 2 != 0) {
                str2.length();
                throw null;
            } else if (str2.length() > 0) {
                this.AFInAppEventParameterName.put("app_version", str2);
                AFVersionDeclaration = (getLevel + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
            }
        }
        if (str3 != null && str3.length() > 0) {
            this.AFInAppEventParameterName.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            AFVersionDeclaration = (getLevel + 123) % 128;
            this.AFInAppEventParameterName.put("preInstall", str4);
        }
    }

    @NonNull
    private synchronized Map<String, Object> AFLogger() {
        Map<String, Object> map;
        getLevel = (AFVersionDeclaration + 23) % 128;
        this.AFInAppEventParameterName.put("data", this.values);
        afErrorLog();
        map = this.AFInAppEventParameterName;
        getLevel = (AFVersionDeclaration + 125) % 128;
        return map;
    }

    private synchronized void afErrorLog() {
        this.values = new ArrayList();
        this.AFInAppEventType = 0;
        int i10 = getLevel + 15;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 35 / 0;
        }
    }

    private boolean afRDLog() {
        if (this.afInfoLog) {
            getLevel = (AFVersionDeclaration + 41) % 128;
            if (this.AFKeystoreWrapper || this.afDebugLog) {
                return true;
            }
        }
        getLevel = (AFVersionDeclaration + 53) % 128;
        return false;
    }

    public final synchronized void AFInAppEventParameterName() {
        this.afDebugLog = true;
        AFInAppEventParameterName("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        getLevel = (AFVersionDeclaration + 95) % 128;
    }

    public final synchronized void AFKeystoreWrapper(String str) {
        try {
            int i10 = getLevel;
            int i11 = i10 + 53;
            AFVersionDeclaration = i11 % 128;
            if (i11 % 2 != 0) {
                this.afErrorLog = str;
                int i12 = 45 / 0;
            } else {
                this.afErrorLog = str;
            }
            AFVersionDeclaration = (i10 + 13) % 128;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean afInfoLog() {
        int i10 = (AFVersionDeclaration + 7) % 128;
        getLevel = i10;
        boolean z10 = this.afDebugLog;
        int i11 = i10 + 63;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 == 0) {
            return z10;
        }
        throw null;
    }

    public final void valueOf(String str, String str2) {
        getLevel = (AFVersionDeclaration + 21) % 128;
        AFInAppEventParameterName((String) null, str, str2);
        int i10 = getLevel + 63;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    public final synchronized void values() {
        AFInAppEventParameterName("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.afDebugLog = false;
        this.AFKeystoreWrapper = false;
        int i10 = AFVersionDeclaration + 91;
        getLevel = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 32 / 0;
        }
    }

    public final synchronized void AFKeystoreWrapper() {
        getLevel = (AFVersionDeclaration + 23) % 128;
        this.AFInAppEventParameterName.clear();
        this.values.clear();
        this.AFInAppEventType = 0;
        AFVersionDeclaration = (getLevel + 49) % 128;
    }

    public final void valueOf() {
        int i10 = (getLevel + 77) % 128;
        AFVersionDeclaration = i10;
        this.afInfoLog = false;
        int i11 = i10 + 35;
        getLevel = i11 % 128;
        if (i11 % 2 == 0) {
            throw null;
        }
    }

    public final void AFInAppEventParameterName(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        try {
            AFe1uSDK aFe1uSDK = new AFe1uSDK(values(str, packageManager, aFc1vSDK), aFc1vSDK);
            AFd1sSDK afDebugLog2 = aFc1vSDK.afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new Runnable(aFe1uSDK) {
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
            int i10 = AFVersionDeclaration + 21;
            getLevel = i10 % 128;
            if (i10 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
        }
    }

    @VisibleForTesting
    private Map<String, Object> values(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        int i10 = getLevel + 103;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 == 0) {
            values(str, packageManager, aFc1vSDK.getLevel());
            Map<String, Object> AFLogger2 = AFLogger();
            AFVersionDeclaration = (getLevel + 43) % 128;
            return AFLogger2;
        }
        values(str, packageManager, aFc1vSDK.getLevel());
        AFLogger();
        throw null;
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        try {
            this.AFInAppEventParameterName.put("sdk_version", str);
            if (str2 != null) {
                getLevel = (AFVersionDeclaration + 53) % 128;
                if (str2.length() > 0) {
                    this.AFInAppEventParameterName.put("devkey", str2);
                }
            }
            if (str3 != null) {
                getLevel = (AFVersionDeclaration + 29) % 128;
                if (str3.length() > 0) {
                    AFVersionDeclaration = (getLevel + 29) % 128;
                    this.AFInAppEventParameterName.put("originalAppsFlyerId", str3);
                    AFVersionDeclaration = (getLevel + 111) % 128;
                }
            }
            if (str4 != null) {
                if (str4.length() > 0) {
                    this.AFInAppEventParameterName.put("uid", str4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void AFInAppEventParameterName(String str, String str2) {
        AFVersionDeclaration = (getLevel + 5) % 128;
        AFInAppEventParameterName("server_request", str, str2);
        int i10 = getLevel + 41;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void AFInAppEventParameterName(java.lang.String r4, java.lang.String r5, java.lang.String... r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = getLevel     // Catch:{ all -> 0x00af }
            int r0 = r0 + 75
            int r0 = r0 % 128
            AFVersionDeclaration = r0     // Catch:{ all -> 0x00af }
            boolean r0 = r3.afRDLog()     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x00b3
            int r0 = AFVersionDeclaration     // Catch:{ all -> 0x00af }
            int r0 = r0 + 39
            int r0 = r0 % 128
            getLevel = r0     // Catch:{ all -> 0x00af }
            int r0 = r3.AFInAppEventType     // Catch:{ all -> 0x00af }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0020
            goto L_0x00b3
        L_0x0020:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b1 }
            java.lang.String r2 = ", "
            java.lang.String r6 = android.text.TextUtils.join(r2, r6)     // Catch:{ all -> 0x00b1 }
            if (r4 == 0) goto L_0x0061
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r2.<init>()     // Catch:{ all -> 0x00b1 }
            r2.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = " "
            r2.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b1 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00b1 }
            r2.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = " _/AppsFlyer_6.10.2 ["
            r2.append(r0)     // Catch:{ all -> 0x00b1 }
            r2.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "] "
            r2.append(r4)     // Catch:{ all -> 0x00b1 }
            r2.append(r5)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = " "
            r2.append(r4)     // Catch:{ all -> 0x00b1 }
            r2.append(r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00b1 }
            goto L_0x008d
        L_0x0061:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r4.<init>()     // Catch:{ all -> 0x00b1 }
            r4.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b1 }
            long r0 = r0.getId()     // Catch:{ all -> 0x00b1 }
            r4.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = " "
            r4.append(r0)     // Catch:{ all -> 0x00b1 }
            r4.append(r5)     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = "/AppsFlyer_6.10.2 "
            r4.append(r5)     // Catch:{ all -> 0x00b1 }
            r4.append(r6)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b1 }
        L_0x008d:
            java.util.List<java.lang.String> r5 = r3.values     // Catch:{ all -> 0x00b1 }
            r5.add(r4)     // Catch:{ all -> 0x00b1 }
            int r5 = r3.AFInAppEventType     // Catch:{ all -> 0x00b1 }
            int r4 = r4.length()     // Catch:{ all -> 0x00b1 }
            int r4 = r4 << 1
            int r5 = r5 + r4
            r3.AFInAppEventType = r5     // Catch:{ all -> 0x00b1 }
            int r4 = getLevel     // Catch:{ all -> 0x00af }
            int r4 = r4 + 47
            int r5 = r4 % 128
            AFVersionDeclaration = r5     // Catch:{ all -> 0x00af }
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x00ab
            monitor-exit(r3)
            return
        L_0x00ab:
            r4 = 0
            throw r4     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x00af }
        L_0x00af:
            r4 = move-exception
            goto L_0x00b5
        L_0x00b1:
            monitor-exit(r3)
            return
        L_0x00b3:
            monitor-exit(r3)
            return
        L_0x00b5:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1tSDK.AFInAppEventParameterName(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    private synchronized void values(String str, String str2, String str3) {
        try {
            Map<String, Object> map = this.AFInAppEventParameterName;
            Object[] objArr = new Object[1];
            AFInAppEventType((ViewConfiguration.getFadingEdgeLength() >> 16) - 120, 146565612 - TextUtils.indexOf("", '0', 0), (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 57), 1891164645 - ExpandableListView.getPackedPositionChild(0), (short) (TextUtils.indexOf("", "") + 29), objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.AFInAppEventParameterName.put("model", Build.MODEL);
            this.AFInAppEventParameterName.put("platform", "Android");
            this.AFInAppEventParameterName.put("platform_version", Build.VERSION.RELEASE);
            if (str != null) {
                AFVersionDeclaration = (getLevel + 37) % 128;
                if (str.length() > 0) {
                    this.AFInAppEventParameterName.put("advertiserId", str);
                }
            }
            if (str2 != null) {
                getLevel = (AFVersionDeclaration + 11) % 128;
                if (str2.length() > 0) {
                    this.AFInAppEventParameterName.put("imei", str2);
                }
            }
            if (str3 != null) {
                AFVersionDeclaration = (getLevel + 57) % 128;
                if (str3.length() > 0) {
                    this.AFInAppEventParameterName.put("android_id", str3);
                }
            }
            int i10 = AFVersionDeclaration + 7;
            getLevel = i10 % 128;
            if (i10 % 2 == 0) {
                int i11 = 39 / 0;
            }
        } catch (Throwable unused) {
        }
    }

    public final void AFInAppEventType(String str, String... strArr) {
        int i10 = AFVersionDeclaration + 27;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        AFInAppEventParameterName("public_api_call", str, strArr);
        if (i11 != 0) {
            getLevel = (AFVersionDeclaration + 13) % 128;
            return;
        }
        throw null;
    }

    private static String[] AFInAppEventType(String str, StackTraceElement[] stackTraceElementArr) {
        int i10 = getLevel;
        int i11 = i10 + 85;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 != 0) {
            throw null;
        } else if (stackTraceElementArr == null) {
            AFVersionDeclaration = (i10 + 61) % 128;
            return new String[]{str};
        } else {
            int i12 = 1;
            String[] strArr = new String[(stackTraceElementArr.length + 1)];
            strArr[0] = str;
            while (i12 < stackTraceElementArr.length) {
                strArr[i12] = stackTraceElementArr[i12].toString();
                i12++;
                AFVersionDeclaration = (getLevel + 51) % 128;
            }
            return strArr;
        }
    }

    public final void AFKeystoreWrapper(String str, int i10, String str2) {
        int i11 = getLevel + 97;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 != 0) {
            String[] strArr = new String[3];
            strArr[1] = String.valueOf(i10);
            strArr[0] = str2;
            AFInAppEventParameterName("server_response", str, strArr);
        } else {
            AFInAppEventParameterName("server_response", str, String.valueOf(i10), str2);
        }
        getLevel = (AFVersionDeclaration + 55) % 128;
    }

    public final synchronized void AFInAppEventType() {
        try {
            int i10 = AFVersionDeclaration + 15;
            getLevel = i10 % 128;
            if (i10 % 2 == 0) {
                this.AFKeystoreWrapper = false;
            } else {
                this.AFKeystoreWrapper = false;
            }
            afErrorLog();
            int i11 = getLevel + 29;
            AFVersionDeclaration = i11 % 128;
            if (i11 % 2 != 0) {
                int i12 = 14 / 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void values(Throwable th) {
        String str;
        StackTraceElement[] stackTraceElementArr;
        int i10 = AFVersionDeclaration + 71;
        getLevel = i10 % 128;
        if (i10 % 2 != 0) {
            Throwable cause = th.getCause();
            String simpleName = th.getClass().getSimpleName();
            if (cause == null) {
                str = th.getMessage();
            } else {
                str = cause.getMessage();
                AFVersionDeclaration = (getLevel + 45) % 128;
            }
            if (cause == null) {
                AFVersionDeclaration = (getLevel + 115) % 128;
                stackTraceElementArr = th.getStackTrace();
            } else {
                stackTraceElementArr = cause.getStackTrace();
            }
            AFInAppEventParameterName("exception", simpleName, AFInAppEventType(str, stackTraceElementArr));
            return;
        }
        th.getCause();
        throw null;
    }

    private static void AFInAppEventType(int i10, int i11, byte b10, int i12, short s10, Object[] objArr) {
        String obj;
        synchronized (AFg1qSDK.valueOf) {
            try {
                StringBuilder sb2 = new StringBuilder();
                int i13 = AFLogger;
                int i14 = i10 + i13;
                int i15 = i14 == -1 ? 1 : 0;
                if (i15 != 0) {
                    byte[] bArr = afErrorLogForExcManagerOnly;
                    if (bArr != null) {
                        i14 = (byte) (bArr[afRDLog + i11] + i13);
                    } else {
                        i14 = (short) (AFLogger$LogLevel[afRDLog + i11] + i13);
                    }
                }
                if (i14 > 0) {
                    AFg1qSDK.values = ((i11 + i14) - 2) + afRDLog + i15;
                    char c10 = (char) (i12 + afWarnLog);
                    AFg1qSDK.AFKeystoreWrapper = c10;
                    sb2.append(c10);
                    AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                    AFg1qSDK.AFInAppEventParameterName = 1;
                    while (AFg1qSDK.AFInAppEventParameterName < i14) {
                        byte[] bArr2 = afErrorLogForExcManagerOnly;
                        if (bArr2 != null) {
                            int i16 = AFg1qSDK.values;
                            AFg1qSDK.values = i16 - 1;
                            AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((byte) (bArr2[i16] + s10)) ^ b10));
                        } else {
                            short[] sArr = AFLogger$LogLevel;
                            int i17 = AFg1qSDK.values;
                            AFg1qSDK.values = i17 - 1;
                            AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((short) (sArr[i17] + s10)) ^ b10));
                        }
                        sb2.append(AFg1qSDK.AFKeystoreWrapper);
                        AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                        AFg1qSDK.AFInAppEventParameterName++;
                    }
                }
                obj = sb2.toString();
            } finally {
            }
        }
        objArr[0] = obj;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0087 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void values(java.lang.String r6, android.content.pm.PackageManager r7, com.appsflyer.internal.AFe1nSDK r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = AFVersionDeclaration     // Catch:{ all -> 0x0031 }
            int r0 = r0 + 3
            int r0 = r0 % 128
            getLevel = r0     // Catch:{ all -> 0x0031 }
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r1)     // Catch:{ all -> 0x0031 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0031 }
            r3.clear()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0095 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0095 }
            r7.<init>(r2)     // Catch:{ all -> 0x0095 }
            java.util.Map r7 = com.appsflyer.internal.AFa1oSDK.AFInAppEventType(r7)     // Catch:{ all -> 0x0095 }
            r6.putAll(r7)     // Catch:{ all -> 0x0095 }
            int r6 = getLevel     // Catch:{ all -> 0x0031 }
            int r6 = r6 + 49
            int r6 = r6 % 128
            AFVersionDeclaration = r6     // Catch:{ all -> 0x0031 }
            goto L_0x0095
        L_0x0031:
            r6 = move-exception
            goto L_0x00a0
        L_0x0033:
            com.appsflyer.internal.AFb1xSDK r2 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "advertiserId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r8.AFInAppEventType     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = r2.afErrorLog     // Catch:{ all -> 0x0031 }
            r5.values((java.lang.String) r3, (java.lang.String) r8, (java.lang.String) r4)     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "6.10.2."
            r8.<init>(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = com.appsflyer.internal.AFb1xSDK.valueOf     // Catch:{ all -> 0x0031 }
            r8.append(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0031 }
            com.appsflyer.internal.AFc1vSDK r2 = r2.AFKeystoreWrapper()     // Catch:{ all -> 0x0031 }
            com.appsflyer.internal.AFe1nSDK r2 = r2.getLevel()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = r2.values     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0031 }
            r5.AFKeystoreWrapper(r8, r2, r3, r4)     // Catch:{ all -> 0x0031 }
            r8 = 0
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r6, r8)     // Catch:{ all -> 0x0087 }
            int r7 = r7.versionCode     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = "channel"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0087 }
            r5.AFInAppEventType(r6, r7, r8, r2)     // Catch:{ all -> 0x0087 }
        L_0x0087:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0031 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0031 }
            r6.<init>(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0031 }
            r0.set((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x0031 }
        L_0x0095:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = "launch_counter"
            java.lang.String r8 = r5.afErrorLog     // Catch:{ all -> 0x0031 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0031 }
            monitor-exit(r5)
            return
        L_0x00a0:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1tSDK.values(java.lang.String, android.content.pm.PackageManager, com.appsflyer.internal.AFe1nSDK):void");
    }
}
