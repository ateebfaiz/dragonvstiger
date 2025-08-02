package com.sensorsdata.analytics.android.sdk.core.business;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;

public class DefaultAppState implements AppStateTools.AppState {
    private boolean mIsResumeScreenOrientation = false;
    private final SensorsDataAPI mSensorsDataInstance;
    private boolean resumeFromBackground = false;

    public DefaultAppState(SensorsDataAPI sensorsDataAPI) {
        this.mSensorsDataInstance = sensorsDataAPI;
    }

    public void onBackground() {
        try {
            if (this.mSensorsDataInstance.getSAContextManager().getOrientationDetector() == null || !this.mSensorsDataInstance.getSAContextManager().getOrientationDetector().isEnableState()) {
                this.mIsResumeScreenOrientation = false;
            } else {
                this.mSensorsDataInstance.stopTrackScreenOrientation();
                this.mIsResumeScreenOrientation = true;
            }
            this.mSensorsDataInstance.getSAContextManager().getRemoteManager().resetPullSDKConfigTimer();
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_STOP_HEATMAP_SERVICE, new Object[0]);
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_STOP_VISUAL_SERVICE, new Object[0]);
            EventTimerManager.getInstance().appEnterBackground();
            this.mSensorsDataInstance.clearLastScreenUrl();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onForeground() {
        try {
            EventTimerManager.getInstance().appBecomeActive();
            if (this.resumeFromBackground) {
                this.mSensorsDataInstance.getSAContextManager().getRemoteManager().applySDKConfigFromCache();
                if (this.mIsResumeScreenOrientation) {
                    this.mSensorsDataInstance.resumeTrackScreenOrientation();
                }
                try {
                    SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_RESUME_HEATMAP_SERVICE, new Object[0]);
                    SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_RESUME_VISUAL_SERVICE, new Object[0]);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
            this.mSensorsDataInstance.getSAContextManager().getRemoteManager().pullSDKConfigFromServer();
            this.resumeFromBackground = true;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
