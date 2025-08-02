package com.sensorsdata.analytics.android.sdk.push.core;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;

public class PushProtocolImp implements SAModuleProtocol {
    private boolean mEnable = false;

    public String getModuleName() {
        return Modules.Push.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        if (sAContextManager.getInternalConfigs().saConfigOptions.isEnableTrackPush()) {
            SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(new PushLifecycleCallbacks());
        }
        setModuleState(!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK());
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return null;
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
