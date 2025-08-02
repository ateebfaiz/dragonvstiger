package com.appsflyer.internal;

import android.net.TrafficStats;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AFd1pSDK<Result> implements Comparable<AFd1pSDK<?>>, Callable<AFd1tSDK> {
    private static final AtomicInteger afErrorLog = new AtomicInteger();
    public volatile int AFInAppEventParameterName;
    @NonNull
    public final AFd1rSDK AFInAppEventType;
    @NonNull
    public final Set<AFd1rSDK> AFKeystoreWrapper = new HashSet();
    private long AFLogger;
    private boolean AFLogger$LogLevel;
    private final int afDebugLog;
    @Nullable
    private Throwable afInfoLog;
    private final String afRDLog;
    @Nullable
    public AFd1tSDK valueOf;
    @NonNull
    public final Set<AFd1rSDK> values;

    public AFd1pSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @Nullable String str) {
        HashSet hashSet = new HashSet();
        this.values = hashSet;
        int incrementAndGet = afErrorLog.incrementAndGet();
        this.afDebugLog = incrementAndGet;
        this.AFLogger$LogLevel = false;
        this.AFInAppEventParameterName = 0;
        this.AFInAppEventType = aFd1rSDK;
        Collections.addAll(hashSet, aFd1rSDKArr);
        if (str != null) {
            this.afRDLog = str;
        } else {
            this.afRDLog = String.valueOf(incrementAndGet);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void AFInAppEventParameterName(Throwable th) {
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @NonNull
    public abstract AFd1tSDK AFInAppEventType() throws Exception;

    /* renamed from: AFKeystoreWrapper */
    public final int compareTo(AFd1pSDK<?> aFd1pSDK) {
        int i10 = this.AFInAppEventType.AppsFlyer2dXConversionCallback - aFd1pSDK.AFInAppEventType.AppsFlyer2dXConversionCallback;
        if (i10 != 0) {
            return i10;
        }
        if (this.afRDLog.equals(aFd1pSDK.afRDLog)) {
            return 0;
        }
        return this.afDebugLog - aFd1pSDK.afDebugLog;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract boolean AFKeystoreWrapper();

    /* renamed from: afDebugLog */
    public final AFd1tSDK call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        this.valueOf = null;
        this.afInfoLog = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.AFInAppEventParameterName++;
        try {
            AFd1tSDK AFInAppEventType2 = AFInAppEventType();
            this.valueOf = AFInAppEventType2;
            this.AFLogger = System.currentTimeMillis() - currentTimeMillis;
            values();
            return AFInAppEventType2;
        } catch (Throwable th) {
            this.AFLogger = System.currentTimeMillis() - currentTimeMillis;
            values();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean afErrorLog() {
        return this.AFLogger$LogLevel;
    }

    @Nullable
    public final Throwable afInfoLog() {
        return this.afInfoLog;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1pSDK aFd1pSDK = (AFd1pSDK) obj;
        if (this.AFInAppEventType != aFd1pSDK.AFInAppEventType) {
            return false;
        }
        return this.afRDLog.equals(aFd1pSDK.afRDLog);
    }

    public final int hashCode() {
        return (this.AFInAppEventType.hashCode() * 31) + this.afRDLog.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.AFInAppEventType);
        sb2.append("-");
        sb2.append(this.afRDLog);
        String obj = sb2.toString();
        if (String.valueOf(this.afDebugLog).equals(this.afRDLog)) {
            return obj;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("-");
        sb3.append(this.afDebugLog);
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public abstract long valueOf();

    /* access modifiers changed from: protected */
    @WorkerThread
    public void values() {
    }

    @CallSuper
    @WorkerThread
    public void AFInAppEventParameterName() {
        this.AFLogger$LogLevel = true;
    }
}
