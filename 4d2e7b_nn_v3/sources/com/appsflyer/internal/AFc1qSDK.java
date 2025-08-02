package com.appsflyer.internal;

import android.os.Build;
import android.view.ViewConfiguration;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.pdns.DNSResolver;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1oSDK;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.zing.zalo.zalosdk.common.Constant;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.d;
import org.json.JSONObject;

public final class AFc1qSDK implements AFc1nSDK {
    private static int[] AFLogger = {84034794, 1147463978, 1355501688, -1498289662, 1398696191, -692224148, 74284621, 393338626, 55061909, -312637553, 1399769626, -1380028196, -1350300435, 384163972, -248694641, -1057661601, -1354286904, -696761256};
    private static int AFVersionDeclaration = 0;
    private static int afErrorLogForExcManagerOnly = 1;
    private final Lazy AFInAppEventParameterName = i.b(new Function0<AFe1nSDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: valueOf */
        public final AFe1nSDK invoke() {
            AFe1nSDK level = AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventParameterName).getLevel();
            m.e(level, "");
            return level;
        }
    });
    private final Lazy AFInAppEventType = i.b(new Function0<AFc1zSDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: AFInAppEventType */
        public final AFc1zSDK invoke() {
            AFc1zSDK values = AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventParameterName).values();
            m.e(values, "");
            return values;
        }
    });
    private final Lazy AFKeystoreWrapper = i.b(new Function0<AFb1rSDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventType;

        {
            this.AFInAppEventType = r1;
        }

        /* renamed from: valueOf */
        public final AFb1rSDK invoke() {
            AFb1rSDK afRDLog = AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventType).afRDLog();
            m.e(afRDLog, "");
            return afRDLog;
        }
    });
    private final Lazy afDebugLog = i.b(new Function0<ExecutorService>(this) {
        private /* synthetic */ AFc1qSDK values;

        {
            this.values = r1;
        }

        /* renamed from: valueOf */
        public final ExecutorService invoke() {
            ExecutorService AFKeystoreWrapper = AFc1qSDK.AFKeystoreWrapper(this.values).AFKeystoreWrapper();
            m.e(AFKeystoreWrapper, "");
            return AFKeystoreWrapper;
        }
    });
    private final String afErrorLog = "6.10.2";
    private final Lazy afInfoLog = i.b(new Function0<AFa1bSDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: AFInAppEventType */
        public final AFa1bSDK invoke() {
            AFc1sSDK AFLogger$LogLevel = AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventParameterName).AFLogger$LogLevel();
            m.e(AFLogger$LogLevel, "");
            return new AFa1bSDK(AFLogger$LogLevel);
        }
    });
    private final Lazy afRDLog = i.b(new Function0<AFa1cSDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventType;

        {
            this.AFInAppEventType = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final AFa1cSDK invoke() {
            return new AFa1cSDK(this.AFInAppEventType.AFKeystoreWrapper());
        }
    });
    private AFc1vSDK valueOf;
    private final Lazy values = i.b(new Function0<AFc1ySDK>(this) {
        private /* synthetic */ AFc1qSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: AFKeystoreWrapper */
        public final AFc1ySDK invoke() {
            AFc1ySDK afInfoLog = AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventParameterName).afInfoLog();
            m.e(afInfoLog, "");
            return afInfoLog;
        }
    });

    public AFc1qSDK(AFc1vSDK aFc1vSDK) {
        m.f(aFc1vSDK, "");
        this.valueOf = aFc1vSDK;
    }

    private final AFb1rSDK AFInAppEventParameterName() {
        int i10 = AFVersionDeclaration + 77;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 != 0) {
            return (AFb1rSDK) this.AFKeystoreWrapper.getValue();
        }
        int i11 = 38 / 0;
        return (AFb1rSDK) this.AFKeystoreWrapper.getValue();
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventType(AFc1qSDK aFc1qSDK) {
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 67) % 128;
        m.f(aFc1qSDK, "");
        aFc1qSDK.AFLogger$LogLevel();
        int i10 = afErrorLogForExcManagerOnly + 67;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    public static final /* synthetic */ AFc1vSDK AFKeystoreWrapper(AFc1qSDK aFc1qSDK) {
        int i10 = AFVersionDeclaration;
        afErrorLogForExcManagerOnly = (i10 + 29) % 128;
        AFc1vSDK aFc1vSDK = aFc1qSDK.valueOf;
        int i11 = i10 + 35;
        afErrorLogForExcManagerOnly = i11 % 128;
        if (i11 % 2 != 0) {
            return aFc1vSDK;
        }
        throw null;
    }

    private final AFe1nSDK AFLogger() {
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
        AFe1nSDK aFe1nSDK = (AFe1nSDK) this.AFInAppEventParameterName.getValue();
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 43) % 128;
        return aFe1nSDK;
    }

    private final synchronized void AFLogger$LogLevel() {
        long j10;
        try {
            int i10 = afErrorLogForExcManagerOnly + 39;
            AFVersionDeclaration = i10 % 128;
            String str = null;
            if (i10 % 2 == 0) {
                AFb1qSDK afWarnLog = afWarnLog();
                if (afWarnLog != null) {
                    j10 = afWarnLog.valueOf;
                } else {
                    j10 = -1;
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                try {
                    AFb1qSDK afWarnLog2 = afWarnLog();
                    if (afWarnLog2 != null) {
                        int i11 = afErrorLogForExcManagerOnly + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        AFVersionDeclaration = i11 % 128;
                        if (i11 % 2 == 0) {
                            str = afWarnLog2.values;
                        } else {
                            throw null;
                        }
                    }
                    if (str == null) {
                        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 23) % 128;
                        str = "";
                    }
                } catch (NullPointerException unused) {
                    str = "NOT_DETECTED";
                }
                if (j10 < currentTimeMillis) {
                    m.f("TTL is already passed", "");
                    AFLogger.afRDLog("[Exception Manager]: ".concat("TTL is already passed"));
                    afInfoLog().valueOf("af_send_exc_to_server_window");
                    AFKeystoreWrapper().values();
                } else if (AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(str) == -1 || AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(str) > AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(afErrorLog())) {
                    afInfoLog().valueOf("af_send_exc_to_server_window");
                    AFKeystoreWrapper().values();
                } else {
                    AFKeystoreWrapper().AFInAppEventType(afErrorLog());
                }
            } else {
                afWarnLog();
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void AFVersionDeclaration() {
        AFb1qSDK aFb1qSDK;
        int i10 = AFVersionDeclaration + 59;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 == 0) {
            aFb1qSDK = afWarnLog();
            int i11 = 66 / 0;
            if (aFb1qSDK == null) {
                return;
            }
        } else {
            aFb1qSDK = afWarnLog();
            if (aFb1qSDK == null) {
                return;
            }
        }
        if (!AFKeystoreWrapper(aFb1qSDK)) {
            m.f("skipping", "");
            AFLogger.afRDLog("[Exception Manager]: ".concat("skipping"));
            AFVersionDeclaration = (afErrorLogForExcManagerOnly + 91) % 128;
            return;
        }
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 47) % 128;
        String str = AFLogger().values;
        if (str != null) {
            String jSONObject = new JSONObject(values((Map<String, ? extends Object>) AFInAppEventType(aFb1qSDK), AFKeystoreWrapper().AFKeystoreWrapper())).toString();
            m.e(jSONObject, "");
            m.e(str, "");
            values(jSONObject, str);
        }
    }

    private final AFc1zSDK afDebugLog() {
        int i10 = AFVersionDeclaration + 69;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 != 0) {
            return (AFc1zSDK) this.AFInAppEventType.getValue();
        }
        int i11 = 5 / 0;
        return (AFc1zSDK) this.AFInAppEventType.getValue();
    }

    private String afErrorLog() {
        int i10 = AFVersionDeclaration + 119;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 != 0) {
            return this.afErrorLog;
        }
        int i11 = 25 / 0;
        return this.afErrorLog;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void afErrorLogForExcManagerOnly() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.appsflyer.internal.AFb1qSDK r0 = r7.afWarnLog()     // Catch:{ all -> 0x002a }
            r1 = 0
            if (r0 == 0) goto L_0x0067
            int r2 = afErrorLogForExcManagerOnly     // Catch:{ all -> 0x002a }
            int r3 = r2 + 25
            int r4 = r3 % 128
            AFVersionDeclaration = r4     // Catch:{ all -> 0x002a }
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0064
            int r1 = r0.AFInAppEventType     // Catch:{ all -> 0x002a }
            r3 = -1
            if (r1 != r3) goto L_0x002c
            int r2 = r2 + 125
            int r2 = r2 % 128
            AFVersionDeclaration = r2     // Catch:{ all -> 0x002a }
            com.appsflyer.internal.AFc1ySDK r0 = r7.afInfoLog()     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.valueOf(r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r7)
            return
        L_0x002a:
            r0 = move-exception
            goto L_0x0078
        L_0x002c:
            com.appsflyer.internal.AFc1ySDK r1 = r7.afInfoLog()     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "af_send_exc_to_server_window"
            r3 = -1
            long r1 = r1.AFInAppEventParameterName(r2, r3)     // Catch:{ all -> 0x002a }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0062
            int r1 = AFVersionDeclaration     // Catch:{ all -> 0x002a }
            int r1 = r1 + 101
            int r1 = r1 % 128
            afErrorLogForExcManagerOnly = r1     // Catch:{ all -> 0x002a }
            int r1 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x002a }
            int r0 = r0.AFInAppEventType     // Catch:{ all -> 0x002a }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002a }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ all -> 0x002a }
            long r5 = (long) r0     // Catch:{ all -> 0x002a }
            long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x002a }
            long r2 = r2 + r4
            com.appsflyer.internal.AFc1ySDK r0 = r7.afInfoLog()     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "af_send_exc_to_server_window"
            r0.AFInAppEventType((java.lang.String) r4, (long) r2)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "af_send_exc_min"
            r0.AFKeystoreWrapper(r2, r1)     // Catch:{ all -> 0x002a }
        L_0x0062:
            monitor-exit(r7)
            return
        L_0x0064:
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002a }
        L_0x0067:
            int r0 = AFVersionDeclaration     // Catch:{ all -> 0x002a }
            int r0 = r0 + 111
            int r2 = r0 % 128
            afErrorLogForExcManagerOnly = r2     // Catch:{ all -> 0x002a }
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0075
            monitor-exit(r7)
            return
        L_0x0075:
            throw r1     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002a }
        L_0x0078:
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly():void");
    }

    private final AFc1ySDK afInfoLog() {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 121) % 128;
        AFc1ySDK aFc1ySDK = (AFc1ySDK) this.values.getValue();
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 81) % 128;
        return aFc1ySDK;
    }

    private final ExecutorService afRDLog() {
        int i10 = afErrorLogForExcManagerOnly + 79;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 == 0) {
            return (ExecutorService) this.afDebugLog.getValue();
        }
        ExecutorService executorService = (ExecutorService) this.afDebugLog.getValue();
        throw null;
    }

    private final AFb1qSDK afWarnLog() {
        AFb1mSDK aFb1mSDK;
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 13) % 128;
        AFb1iSDK aFb1iSDK = AFInAppEventParameterName().AFInAppEventParameterName.valueOf;
        if (aFb1iSDK == null || (aFb1mSDK = aFb1iSDK.AFInAppEventType) == null) {
            return null;
        }
        int i10 = AFVersionDeclaration + DNSResolver.GOBACK_LOCAL;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
        AFb1qSDK aFb1qSDK = aFb1mSDK.AFKeystoreWrapper;
        if (i11 == 0) {
            int i12 = 77 / 0;
        }
        return aFb1qSDK;
    }

    private AFc1oSDK getLevel() {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 93) % 128;
        AFc1oSDK aFc1oSDK = (AFc1oSDK) this.afRDLog.getValue();
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 43) % 128;
        return aFc1oSDK;
    }

    public final void valueOf(Throwable th, String str) {
        int i10 = AFVersionDeclaration + 1;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 != 0) {
            m.f(th, "");
            m.f(str, "");
            afRDLog().execute(new m(this, th, str));
            int i11 = AFVersionDeclaration + 93;
            afErrorLogForExcManagerOnly = i11 % 128;
            if (i11 % 2 == 0) {
                throw null;
            }
            return;
        }
        m.f(th, "");
        m.f(str, "");
        afRDLog().execute(new m(this, th, str));
        throw null;
    }

    public final void values() {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 113) % 128;
        afRDLog().execute(new l(this));
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 71) % 128;
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventParameterName(AFc1qSDK aFc1qSDK, Throwable th, String str) {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 51) % 128;
        m.f(aFc1qSDK, "");
        m.f(th, "");
        m.f(str, "");
        AFb1qSDK afWarnLog = aFc1qSDK.afWarnLog();
        if (afWarnLog == null) {
            AFVersionDeclaration = (afErrorLogForExcManagerOnly + 43) % 128;
        } else if (aFc1qSDK.AFInAppEventParameterName(afWarnLog)) {
            afErrorLogForExcManagerOnly = (AFVersionDeclaration + 41) % 128;
            aFc1qSDK.AFKeystoreWrapper().values(th, str);
        }
    }

    /* access modifiers changed from: private */
    public static final void values(AFc1qSDK aFc1qSDK) {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 87) % 128;
        m.f(aFc1qSDK, "");
        aFc1qSDK.afErrorLogForExcManagerOnly();
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 53) % 128;
    }

    public final AFc1wSDK AFKeystoreWrapper() {
        int i10 = afErrorLogForExcManagerOnly + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 == 0) {
            AFc1wSDK aFc1wSDK = (AFc1wSDK) this.afInfoLog.getValue();
            int i11 = AFVersionDeclaration + 99;
            afErrorLogForExcManagerOnly = i11 % 128;
            if (i11 % 2 != 0) {
                return aFc1wSDK;
            }
            throw null;
        }
        AFc1wSDK aFc1wSDK2 = (AFc1wSDK) this.afInfoLog.getValue();
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (AFKeystoreWrapper().AFInAppEventParameterName() < r0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (AFKeystoreWrapper().AFInAppEventParameterName() < r0) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFKeystoreWrapper(com.appsflyer.internal.AFb1qSDK r11) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1ySDK r2 = r10.afInfoLog()
            java.lang.String r3 = "af_send_exc_to_server_window"
            r4 = -1
            long r2 = r2.AFInAppEventParameterName(r3, r4)
            long r6 = r11.valueOf
            r8 = 1000(0x3e8, double:4.94E-321)
            long r8 = r0 / r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r7 = 0
            if (r6 >= 0) goto L_0x0024
            int r11 = AFVersionDeclaration
            int r11 = r11 + 37
            int r11 = r11 % 128
            afErrorLogForExcManagerOnly = r11
            return r7
        L_0x0024:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0076
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x002d
            goto L_0x0076
        L_0x002d:
            com.appsflyer.internal.AFc1ySDK r0 = r10.afInfoLog()
            java.lang.String r1 = "af_send_exc_min"
            r2 = -1
            int r0 = r0.AFInAppEventType((java.lang.String) r1, (int) r2)
            if (r0 == r2) goto L_0x0076
            int r1 = afErrorLogForExcManagerOnly
            int r1 = r1 + 77
            int r2 = r1 % 128
            AFVersionDeclaration = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0054
            com.appsflyer.internal.AFc1wSDK r1 = r10.AFKeystoreWrapper()
            int r1 = r1.AFInAppEventParameterName()
            r2 = 46
            int r2 = r2 / r7
            if (r1 >= r0) goto L_0x005f
            goto L_0x0076
        L_0x0054:
            com.appsflyer.internal.AFc1wSDK r1 = r10.AFKeystoreWrapper()
            int r1 = r1.AFInAppEventParameterName()
            if (r1 >= r0) goto L_0x005f
            goto L_0x0076
        L_0x005f:
            java.lang.String r11 = r11.values
            java.lang.String r0 = ""
            kotlin.jvm.internal.m.e(r11, r0)
            int r11 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.lang.String) r11)
            java.lang.String r0 = r10.afErrorLog()
            int r0 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.lang.String) r0)
            if (r11 != r0) goto L_0x0076
            r11 = 1
            return r11
        L_0x0076:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFKeystoreWrapper(com.appsflyer.internal.AFb1qSDK):boolean");
    }

    public final void AFInAppEventType() {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 41) % 128;
        afRDLog().execute(new k(this));
        int i10 = afErrorLogForExcManagerOnly + 111;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 73 / 0;
        }
    }

    public final void valueOf() {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 53) % 128;
        afRDLog().execute(new n(this));
        int i10 = AFVersionDeclaration + 23;
        afErrorLogForExcManagerOnly = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    private final Map<String, String> AFInAppEventType(AFb1qSDK aFb1qSDK) {
        Object[] objArr = new Object[1];
        AFInAppEventParameterName(new int[]{1263239055, -682377407, 82681553, 1636572451}, (ViewConfiguration.getEdgeSlop() >> 16) + 5, objArr);
        Map<String, String> i10 = i0.i(t.a(((String) objArr[0]).intern(), Build.BRAND), t.a("model", Build.MODEL), t.a(Constant.PARAM_APP_ID, afDebugLog().AFKeystoreWrapper.AFKeystoreWrapper.getPackageName()), t.a("p_ex", new AFb1vSDK().AFKeystoreWrapper()), t.a("api", String.valueOf(Build.VERSION.SDK_INT)), t.a("sdk", afErrorLog()), t.a("uid", AFb1wSDK.AFKeystoreWrapper(new WeakReference(afDebugLog().AFKeystoreWrapper.AFKeystoreWrapper))), t.a("exc_config", aFb1qSDK.AFInAppEventType()));
        int i11 = AFVersionDeclaration + 45;
        afErrorLogForExcManagerOnly = i11 % 128;
        if (i11 % 2 != 0) {
            return i10;
        }
        throw null;
    }

    private static Map<String, Object> values(Map<String, ? extends Object> map, List<AFc1uSDK> list) {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 89) % 128;
        Map<String, Object> i10 = i0.i(t.a("deviceInfo", map), t.a("excs", AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(list)));
        int i11 = afErrorLogForExcManagerOnly + 83;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 != 0) {
            int i12 = 38 / 0;
        }
        return i10;
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventParameterName(AFc1qSDK aFc1qSDK) {
        afErrorLogForExcManagerOnly = (AFVersionDeclaration + 23) % 128;
        m.f(aFc1qSDK, "");
        aFc1qSDK.AFVersionDeclaration();
        int i10 = afErrorLogForExcManagerOnly + 95;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 47 / 0;
        }
    }

    @WorkerThread
    private final void values(String str, String str2) {
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 117) % 128;
        byte[] bytes = str.getBytes(d.f797b);
        m.e(bytes, "");
        getLevel().values(bytes, i0.d(t.a("Authorization", AFb1ySDK.AFKeystoreWrapper(str, str2))), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        AFVersionDeclaration = (afErrorLogForExcManagerOnly + 111) % 128;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        if (r2 < r0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r2 < r0) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFInAppEventParameterName(com.appsflyer.internal.AFb1qSDK r11) {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1ySDK r2 = r10.afInfoLog()
            java.lang.String r3 = "af_send_exc_to_server_window"
            r4 = -1
            long r2 = r2.AFInAppEventParameterName(r3, r4)
            long r6 = r11.valueOf
            r8 = 1000(0x3e8, double:4.94E-321)
            long r8 = r0 / r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r7 = 0
            if (r6 < 0) goto L_0x005d
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x005d
            int r4 = afErrorLogForExcManagerOnly
            int r4 = r4 + 15
            int r5 = r4 % 128
            AFVersionDeclaration = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0033
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r1 = 85
            int r1 = r1 / r7
            if (r0 >= 0) goto L_0x0038
            goto L_0x005d
        L_0x0033:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0038
            goto L_0x005d
        L_0x0038:
            java.lang.String r11 = r11.values
            java.lang.String r0 = ""
            kotlin.jvm.internal.m.e(r11, r0)
            int r11 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.lang.String) r11)
            java.lang.String r0 = r10.afErrorLog()
            int r0 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.lang.String) r0)
            if (r11 != r0) goto L_0x005d
            int r11 = afErrorLogForExcManagerOnly
            int r11 = r11 + 101
            int r0 = r11 % 128
            AFVersionDeclaration = r0
            int r11 = r11 % 2
            if (r11 != 0) goto L_0x005b
            r11 = 1
            return r11
        L_0x005b:
            r11 = 0
            throw r11
        L_0x005d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFInAppEventParameterName(com.appsflyer.internal.AFb1qSDK):boolean");
    }

    private static void AFInAppEventParameterName(int[] iArr, int i10, Object[] objArr) {
        String str;
        synchronized (AFg1mSDK.AFKeystoreWrapper) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[(iArr.length << 1)];
                int[] iArr2 = (int[]) AFLogger.clone();
                AFg1mSDK.valueOf = 0;
                while (true) {
                    int i11 = AFg1mSDK.valueOf;
                    if (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        char c10 = (char) (i12 >> 16);
                        cArr[0] = c10;
                        char c11 = (char) i12;
                        cArr[1] = c11;
                        char c12 = (char) (iArr[i11 + 1] >> 16);
                        cArr[2] = c12;
                        char c13 = (char) iArr[i11 + 1];
                        cArr[3] = c13;
                        AFg1mSDK.AFInAppEventParameterName = (c10 << 16) + c11;
                        AFg1mSDK.values = (c12 << 16) + c13;
                        AFg1mSDK.AFInAppEventParameterName(iArr2);
                        for (int i13 = 0; i13 < 16; i13++) {
                            int i14 = AFg1mSDK.AFInAppEventParameterName ^ iArr2[i13];
                            AFg1mSDK.AFInAppEventParameterName = i14;
                            AFg1mSDK.values = AFg1mSDK.AFInAppEventType(i14) ^ AFg1mSDK.values;
                            int i15 = AFg1mSDK.AFInAppEventParameterName;
                            AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                            AFg1mSDK.values = i15;
                        }
                        int i16 = AFg1mSDK.AFInAppEventParameterName;
                        AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                        AFg1mSDK.values = i16;
                        AFg1mSDK.values = i16 ^ iArr2[16];
                        AFg1mSDK.AFInAppEventParameterName ^= iArr2[17];
                        int i17 = AFg1mSDK.valueOf;
                        int i18 = AFg1mSDK.AFInAppEventParameterName;
                        cArr[0] = (char) (i18 >>> 16);
                        cArr[1] = (char) i18;
                        int i19 = AFg1mSDK.values;
                        cArr[2] = (char) (i19 >>> 16);
                        cArr[3] = (char) i19;
                        AFg1mSDK.AFInAppEventParameterName(iArr2);
                        int i20 = AFg1mSDK.valueOf;
                        cArr2[i20 << 1] = cArr[0];
                        cArr2[(i20 << 1) + 1] = cArr[1];
                        cArr2[(i20 << 1) + 2] = cArr[2];
                        cArr2[(i20 << 1) + 3] = cArr[3];
                        AFg1mSDK.valueOf = i20 + 2;
                    } else {
                        str = new String(cArr2, 0, i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str;
    }
}
