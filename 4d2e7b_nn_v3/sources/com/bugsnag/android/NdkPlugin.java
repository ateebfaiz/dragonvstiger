package com.bugsnag.android;

import com.bugsnag.android.ndk.NativeBridge;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class NdkPlugin implements i3 {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOAD_ERR_MSG = "Native library could not be linked. Bugsnag will not report NDK errors. See https://docs.bugsnag.com/platforms/android/ndk-link-errors";
    private z client;
    private final r2 libraryLoader = new r2();
    private NativeBridge nativeBridge;
    private final AtomicBoolean oneTimeSetupPerformed = new AtomicBoolean(false);

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final native void disableCrashReporting();

    private final native void enableCrashReporting();

    private final native String getBinaryArch();

    private final NativeBridge initNativeBridge(z zVar) {
        NativeBridge nativeBridge2 = new NativeBridge(zVar.f19183z);
        zVar.d(nativeBridge2);
        zVar.X();
        return nativeBridge2;
    }

    private final void performOneTimeSetup(z zVar) {
        this.libraryLoader.c("bugsnag-ndk", zVar, new b3());
        if (this.libraryLoader.a()) {
            zVar.S(getBinaryArch());
            this.nativeBridge = initNativeBridge(zVar);
            return;
        }
        zVar.f19174q.a(LOAD_ERR_MSG);
    }

    /* access modifiers changed from: private */
    /* renamed from: performOneTimeSetup$lambda-0  reason: not valid java name */
    public static final boolean m169performOneTimeSetup$lambda0(o1 o1Var) {
        k1 k1Var = (k1) o1Var.h().get(0);
        o1Var.b("LinkError", "errorClass", k1Var.b());
        o1Var.b("LinkError", "errorMessage", k1Var.c());
        k1Var.g("NdkLinkError");
        k1Var.h(LOAD_ERR_MSG);
        return true;
    }

    public final Map<String, Integer> getCurrentCallbackSetCounts() {
        Map<String, Integer> map;
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 == null) {
            map = null;
        } else {
            map = nativeBridge2.getCurrentCallbackSetCounts();
        }
        if (map == null) {
            return i0.f();
        }
        return map;
    }

    public final Map<String, Boolean> getCurrentNativeApiCallUsage() {
        Map<String, Boolean> map;
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 == null) {
            map = null;
        } else {
            map = nativeBridge2.getCurrentNativeApiCallUsage();
        }
        if (map == null) {
            return i0.f();
        }
        return map;
    }

    public final NativeBridge getNativeBridge() {
        return this.nativeBridge;
    }

    public final long getSignalUnwindStackFunction() {
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 == null) {
            return 0;
        }
        return nativeBridge2.getSignalUnwindStackFunction();
    }

    public final void initCallbackCounts(Map<String, Integer> map) {
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 != null) {
            nativeBridge2.initCallbackCounts(map);
        }
    }

    public void load(z zVar) {
        this.client = zVar;
        if (!this.oneTimeSetupPerformed.getAndSet(true)) {
            performOneTimeSetup(zVar);
        }
        if (this.libraryLoader.a()) {
            enableCrashReporting();
            zVar.f19174q.f("Initialised NDK Plugin");
        }
    }

    public final void notifyAddCallback(String str) {
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 != null) {
            nativeBridge2.notifyAddCallback(str);
        }
    }

    public final void notifyRemoveCallback(String str) {
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 != null) {
            nativeBridge2.notifyRemoveCallback(str);
        }
    }

    public final void setInternalMetricsEnabled(boolean z10) {
        NativeBridge nativeBridge2 = this.nativeBridge;
        if (nativeBridge2 != null) {
            nativeBridge2.setInternalMetricsEnabled(z10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        tb.c.a(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        tb.c.a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setStaticData(java.util.Map<java.lang.String, ? extends java.lang.Object> r4) {
        /*
            r3 = this;
            java.io.StringWriter r0 = new java.io.StringWriter
            r0.<init>()
            com.bugsnag.android.k2 r1 = new com.bugsnag.android.k2     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            r1.P(r4)     // Catch:{ all -> 0x0025 }
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0025 }
            r4 = 0
            tb.c.a(r1, r4)     // Catch:{ all -> 0x0023 }
            tb.c.a(r0, r4)
            java.lang.String r4 = r0.toString()
            com.bugsnag.android.ndk.NativeBridge r0 = r3.nativeBridge
            if (r0 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r0.setStaticJsonData(r4)
        L_0x0022:
            return
        L_0x0023:
            r4 = move-exception
            goto L_0x002c
        L_0x0025:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r2 = move-exception
            tb.c.a(r1, r4)     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x002c:
            throw r4     // Catch:{ all -> 0x002d }
        L_0x002d:
            r1 = move-exception
            tb.c.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.NdkPlugin.setStaticData(java.util.Map):void");
    }

    public void unload() {
        z zVar;
        if (this.libraryLoader.a()) {
            disableCrashReporting();
            NativeBridge nativeBridge2 = this.nativeBridge;
            if (nativeBridge2 != null && (zVar = this.client) != null) {
                zVar.O(nativeBridge2);
            }
        }
    }
}
