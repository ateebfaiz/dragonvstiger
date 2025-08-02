package com.sensorsdata.analytics.android.sdk.push.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;

public class PushLifecycleCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        PushProcess.getInstance().onNotificationClick(activity, activity.getIntent());
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        PushProcess.getInstance().onNotificationClick(activity, activity.getIntent());
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }
}
