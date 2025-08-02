package com.google.android.gms.common.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    @NonNull
    protected final String zza;
    @NonNull
    protected final Object zzb;
    @Nullable
    private Object zzd = null;

    protected GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f10) {
        return new d(str, f10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = zza(r4.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0030, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0031, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0034, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001b */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzd
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = zzc
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = r4.zza     // Catch:{ SecurityException -> 0x001b }
            java.lang.Object r1 = r4.zza(r1)     // Catch:{ SecurityException -> 0x001b }
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x0019:
            r1 = move-exception
            goto L_0x0031
        L_0x001b:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x002c }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x002c }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0019 }
            android.os.StrictMode.setThreadPolicy(r0)
            return r3
        L_0x002c:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x0019 }
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0031:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x0035:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0038:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.get():java.lang.Object");
    }

    @InlineMe(replacement = "this.get()")
    @NonNull
    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @com.google.android.gms.common.annotation.KeepForSdk
    @com.google.android.gms.common.util.VisibleForTesting
    public void override(@androidx.annotation.NonNull T r3) {
        /*
            r2 = this;
            java.lang.String r0 = "GservicesValue"
            java.lang.String r1 = "GservicesValue.override(): test should probably call initForTests() first"
            android.util.Log.w(r0, r1)
            r2.zzd = r3
            java.lang.Object r3 = zzc
            monitor-enter(r3)
            monitor-enter(r3)     // Catch:{ all -> 0x0010 }
            monitor-exit(r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r0 = move-exception
            goto L_0x0015
        L_0x0012:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0012 }
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0015:
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.override(java.lang.Object):void");
    }

    @KeepForSdk
    @VisibleForTesting
    public void resetOverride() {
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract Object zza(@NonNull String str);

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        return new c(str, num);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l10) {
        return new b(str, l10);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        return new e(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@NonNull String str, boolean z10) {
        return new a(str, Boolean.valueOf(z10));
    }
}
