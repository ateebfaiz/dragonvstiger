package com.sensorsdata.analytics.android.sdk.advert.monitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertMarketHelper;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;

public class SensorsDataAdvertActivityLifeCallback implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private SAConfigOptions mOptions;

    public SensorsDataAdvertActivityLifeCallback(SAConfigOptions sAConfigOptions) {
        this.mOptions = sAConfigOptions;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            SAAdvertMarketHelper.handleAdMarket(activity, this.mOptions.getAdvertConfig());
            DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        try {
            SAAdvertMarketHelper.handleAdMarket(activity, this.mOptions.getAdvertConfig());
            DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }
}
