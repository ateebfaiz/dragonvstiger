package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class AFc1tSDK implements AFc1vSDK {
    private ExecutorService AFInAppEventParameterName;
    private ExecutorService AFInAppEventType;
    public final AFc1sSDK AFKeystoreWrapper = new AFc1sSDK();
    private PurchaseHandler AFLogger;
    private AFd1sSDK AFLogger$LogLevel;
    private AFf1jSDK AFVersionDeclaration;
    private AFb1bSDK AppsFlyer2dXConversionCallback;
    private ScheduledExecutorService afDebugLog;
    private AFc1zSDK afErrorLog;
    private AFb1sSDK afErrorLogForExcManagerOnly;
    private AFb1rSDK afInfoLog;
    private CreateOneLinkHttpTask afRDLog;
    private AFe1jSDK afWarnLog;
    private AFe1nSDK getLevel;
    private AFc1qSDK init;
    private AFf1uSDK onAppOpenAttributionNative;
    private AFa1hSDK onDeepLinkingNative;
    private AFd1wSDK onInstallConversionDataLoadedNative;
    private AFb1zSDK onInstallConversionFailureNative;
    private AFa1tSDK onResponseNative;
    private final int valueOf = ((int) TimeUnit.SECONDS.toMillis(30));
    public AFb1dSDK values;

    static class AFa1xSDK implements ThreadFactory {
        private static final AtomicInteger AFInAppEventParameterName = new AtomicInteger();
        private final AtomicInteger valueOf = new AtomicInteger();

        public AFa1xSDK() {
            AFInAppEventParameterName.incrementAndGet();
        }

        public final Thread newThread(Runnable runnable) {
            int i10 = AFInAppEventParameterName.get();
            int incrementAndGet = this.valueOf.incrementAndGet();
            StringBuilder sb2 = new StringBuilder("queue-");
            sb2.append(i10);
            sb2.append("-");
            sb2.append(incrementAndGet);
            return new Thread(runnable, sb2.toString());
        }
    }

    @NonNull
    private synchronized CreateOneLinkHttpTask onResponseErrorNative() {
        try {
            if (this.afRDLog == null) {
                this.afRDLog = new CreateOneLinkHttpTask(new AFc1fSDK(this.valueOf), AFKeystoreWrapper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afRDLog;
    }

    /* access modifiers changed from: private */
    @NonNull
    /* renamed from: onResponseNative */
    public synchronized AFc1qSDK onConversionDataSuccess() {
        try {
            if (this.init == null) {
                this.init = new AFc1qSDK(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.init;
    }

    @NonNull
    public final synchronized ScheduledExecutorService AFInAppEventParameterName() {
        try {
            if (this.afDebugLog == null) {
                this.afDebugLog = Executors.newScheduledThreadPool(2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afDebugLog;
    }

    @NonNull
    public final AFc1kSDK AFInAppEventType() {
        return new AFc1kSDK(onResponseErrorNative(), values(), AppsFlyerProperties.getInstance(), init());
    }

    @NonNull
    public final synchronized ExecutorService AFKeystoreWrapper() {
        try {
            if (this.AFInAppEventParameterName == null) {
                this.AFInAppEventParameterName = Executors.newCachedThreadPool();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFInAppEventParameterName;
    }

    @NonNull
    public final synchronized AFe1jSDK AFLogger() {
        try {
            if (this.afWarnLog == null) {
                this.afWarnLog = new AFe1jSDK(afInfoLog());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afWarnLog;
    }

    @NonNull
    public final synchronized AFc1sSDK AFLogger$LogLevel() {
        return this.AFKeystoreWrapper;
    }

    @NonNull
    public final synchronized AFf1jSDK AFVersionDeclaration() {
        try {
            if (this.AFVersionDeclaration == null) {
                this.AFVersionDeclaration = new AFf1jSDK();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFVersionDeclaration;
    }

    @NonNull
    public final AFf1uSDK AppsFlyer2dXConversionCallback() {
        if (this.onAppOpenAttributionNative == null) {
            this.onAppOpenAttributionNative = new AFf1sSDK();
        }
        return this.onAppOpenAttributionNative;
    }

    @NonNull
    public final synchronized AFd1sSDK afDebugLog() {
        try {
            if (this.AFLogger$LogLevel == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() {
                    /* access modifiers changed from: private */
                    /* renamed from: AFKeystoreWrapper */
                    public boolean offer(Runnable runnable) {
                        if (isEmpty()) {
                            return super.offer(runnable);
                        }
                        return false;
                    }
                }, new AFa1xSDK());
                threadPoolExecutor.setRejectedExecutionHandler(new o());
                this.AFLogger$LogLevel = new AFd1sSDK(threadPoolExecutor);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFLogger$LogLevel;
    }

    @NonNull
    public final synchronized PurchaseHandler afErrorLog() {
        try {
            if (this.AFLogger == null) {
                this.AFLogger = new PurchaseHandler(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFLogger;
    }

    @NonNull
    public final synchronized AFb1sSDK afErrorLogForExcManagerOnly() {
        try {
            if (this.afErrorLogForExcManagerOnly == null) {
                this.afErrorLogForExcManagerOnly = new AFb1tSDK();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @NonNull
    public final AFc1ySDK afInfoLog() {
        Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
        if (context != null) {
            return new AFc1xSDK(AFb1xSDK.AFKeystoreWrapper(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    @NonNull
    public final synchronized AFb1rSDK afRDLog() {
        try {
            if (this.afInfoLog == null) {
                AFe1qSDK aFe1qSDK = new AFe1qSDK(afInfoLog());
                this.afInfoLog = new AFb1rSDK(new AFe1ySDK(), values(), getLevel(), aFe1qSDK, new AFc1kSDK(onResponseErrorNative(), values(), AppsFlyerProperties.getInstance(), init()), new AFe1sSDK(values(), aFe1qSDK), afDebugLog());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afInfoLog;
    }

    @NonNull
    public final synchronized AFb1zSDK afWarnLog() {
        try {
            if (this.onInstallConversionFailureNative == null) {
                this.onInstallConversionFailureNative = new AFc1lSDK(AFLogger$LogLevel());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onInstallConversionFailureNative;
    }

    @NonNull
    public final synchronized AFe1nSDK getLevel() {
        try {
            if (this.getLevel == null) {
                this.getLevel = new AFe1nSDK(AFLogger$LogLevel(), new AFe1pSDK());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.getLevel;
    }

    @NonNull
    public final synchronized AFd1wSDK init() {
        try {
            if (this.onInstallConversionDataLoadedNative == null) {
                this.onInstallConversionDataLoadedNative = new AFd1wSDK(values(), afInfoLog());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onInstallConversionDataLoadedNative;
    }

    @NonNull
    public final AFb1bSDK onAppOpenAttributionNative() {
        if (this.AppsFlyer2dXConversionCallback == null) {
            this.AppsFlyer2dXConversionCallback = new AFa1wSDK();
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    @NonNull
    public final AFb1dSDK onAttributionFailureNative() {
        if (this.values == null) {
            this.values = new AFb1gSDK(valueOf(), onInstallConversionDataLoadedNative());
        }
        return this.values;
    }

    @NonNull
    public final synchronized AFa1tSDK onInstallConversionDataLoadedNative() {
        try {
            if (this.onResponseNative == null) {
                this.onResponseNative = new AFa1tSDK();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.onResponseNative;
    }

    @NonNull
    public final AFa1hSDK onInstallConversionFailureNative() {
        if (this.onDeepLinkingNative == null) {
            this.onDeepLinkingNative = new AFa1hSDK();
        }
        return this.onDeepLinkingNative;
    }

    @NonNull
    public final synchronized ExecutorService valueOf() {
        try {
            if (this.AFInAppEventType == null) {
                this.AFInAppEventType = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AFInAppEventType;
    }

    @NonNull
    public final synchronized AFc1zSDK values() {
        try {
            if (this.afErrorLog == null) {
                AFc1sSDK AFLogger$LogLevel2 = AFLogger$LogLevel();
                Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
                if (context != null) {
                    this.afErrorLog = new AFc1zSDK(AFLogger$LogLevel2, new AFc1xSDK(AFb1xSDK.AFKeystoreWrapper(context)));
                } else {
                    throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afErrorLog;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void AFInAppEventParameterName(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e10) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e10);
            Thread.currentThread().interrupt();
        }
    }
}
