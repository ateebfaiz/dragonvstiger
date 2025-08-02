package com.sensorsdata.analytics.android.sdk.monitor;

import com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;

public class SensorsDataLifecycleMonitorManager {
    private static final SensorsDataLifecycleMonitorManager instance = new SensorsDataLifecycleMonitorManager();
    private final SensorsDataActivityLifecycleCallbacks mCallback = new SensorsDataActivityLifecycleCallbacks();

    private SensorsDataLifecycleMonitorManager() {
    }

    public static SensorsDataLifecycleMonitorManager getInstance() {
        return instance;
    }

    public void addActivityLifeCallback(SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.addActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void addCrashListener(SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        SensorsDataExceptionHandler.addExceptionListener(sAExceptionListener);
    }

    public SensorsDataActivityLifecycleCallbacks getCallback() {
        return this.mCallback;
    }

    public void removeActivityLifeCallback(SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.removeActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void removeCrashListener(SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        SensorsDataExceptionHandler.removeExceptionListener(sAExceptionListener);
    }
}
