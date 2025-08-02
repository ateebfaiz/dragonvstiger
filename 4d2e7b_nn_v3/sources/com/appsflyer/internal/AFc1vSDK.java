package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public interface AFc1vSDK {
    @NonNull
    ScheduledExecutorService AFInAppEventParameterName();

    @NonNull
    AFc1kSDK AFInAppEventType();

    @NonNull
    ExecutorService AFKeystoreWrapper();

    @NonNull
    AFe1jSDK AFLogger();

    @NonNull
    AFc1sSDK AFLogger$LogLevel();

    @NonNull
    AFf1jSDK AFVersionDeclaration();

    @NonNull
    AFf1uSDK AppsFlyer2dXConversionCallback();

    @NonNull
    AFd1sSDK afDebugLog();

    @NonNull
    PurchaseHandler afErrorLog();

    @NonNull
    AFb1sSDK afErrorLogForExcManagerOnly();

    @NonNull
    AFc1ySDK afInfoLog();

    @NonNull
    AFb1rSDK afRDLog();

    @NonNull
    AFb1zSDK afWarnLog();

    @NonNull
    AFe1nSDK getLevel();

    @NonNull
    AFd1wSDK init();

    @NonNull
    AFb1bSDK onAppOpenAttributionNative();

    @NonNull
    AFb1dSDK onAttributionFailureNative();

    @NonNull
    AFc1nSDK onConversionDataSuccess();

    @NonNull
    AFa1tSDK onInstallConversionDataLoadedNative();

    @NonNull
    AFa1hSDK onInstallConversionFailureNative();

    @NonNull
    AFc1zSDK values();
}
