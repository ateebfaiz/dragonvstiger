package com.sensorsdata.analytics.android.sdk.core;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.TrackTaskManager;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;

public class SACoreHelper {
    private static final String TAG = "SA.EventManager";
    private static volatile SACoreHelper mSingleton;

    private SACoreHelper() {
    }

    public static SACoreHelper getInstance() {
        if (mSingleton == null) {
            synchronized (SACoreHelper.class) {
                try {
                    if (mSingleton == null) {
                        mSingleton = new SACoreHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mSingleton;
    }

    public void trackEvent(InputData inputData) {
        try {
            SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(inputData);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void trackQueueEvent(Runnable runnable) {
        try {
            TrackTaskManager.getInstance().addTrackEventTask(runnable);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
