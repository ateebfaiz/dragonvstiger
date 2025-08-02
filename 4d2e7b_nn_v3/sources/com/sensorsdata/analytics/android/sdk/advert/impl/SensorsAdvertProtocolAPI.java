package com.sensorsdata.analytics.android.sdk.advert.impl;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;

public class SensorsAdvertProtocolAPI implements SAModuleProtocol {
    private SAAdvertProtocolImpl mAdvertProtocolImpl;
    private boolean mEnable = false;

    public String getModuleName() {
        return Modules.Advert.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        this.mAdvertProtocolImpl = new SAAdvertProtocolImpl(sAContextManager);
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return this.mAdvertProtocolImpl.invokeModuleFunction(str, objArr);
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setModuleState(boolean z10) {
        if (this.mEnable != z10) {
            if (z10) {
                this.mAdvertProtocolImpl.delayInitTask();
                this.mAdvertProtocolImpl.registerLifeCallback();
                this.mAdvertProtocolImpl.registerPropertyPlugin();
                this.mAdvertProtocolImpl.delayExecution();
            } else {
                this.mAdvertProtocolImpl.unregisterLifecycleCallback();
                this.mAdvertProtocolImpl.unregisterPropertyPlugin();
            }
            this.mEnable = z10;
        }
    }
}
