package com.sensorsdata.analytics.android.sdk.visual.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil;

@SuppressLint({"NewApi"})
public class AppStateManager implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        ViewTreeStatusObservable.getInstance().clearWebViewCache();
        ViewUtil.clear();
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }
}
