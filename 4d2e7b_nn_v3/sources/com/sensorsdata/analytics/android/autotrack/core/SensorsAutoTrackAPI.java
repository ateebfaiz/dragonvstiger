package com.sensorsdata.analytics.android.autotrack.core;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;

public class SensorsAutoTrackAPI implements SAModuleProtocol {
    private AutoTrackContextHelper mAutoTrackHelper;
    private boolean mEnable = false;

    public String getModuleName() {
        return Modules.AutoTrack.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        try {
            this.mAutoTrackHelper = new AutoTrackContextHelper(sAContextManager);
            setModuleState(!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return this.mAutoTrackHelper.invokeModuleFunction(str, objArr);
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setModuleState(boolean z10) {
        if (this.mEnable != z10) {
            this.mEnable = z10;
        }
    }
}
