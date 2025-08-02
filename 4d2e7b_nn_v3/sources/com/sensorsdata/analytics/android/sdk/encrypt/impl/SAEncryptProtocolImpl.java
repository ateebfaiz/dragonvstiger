package com.sensorsdata.analytics.android.sdk.encrypt.impl;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;

public class SAEncryptProtocolImpl implements SAModuleProtocol {
    private boolean mEnable = false;
    private SAEncryptAPIImpl mEncryptAPIImpl;

    public String getModuleName() {
        return Modules.Encrypt.MODULE_NAME;
    }

    public int getPriority() {
        return 6;
    }

    public void install(SAContextManager sAContextManager) {
        this.mEncryptAPIImpl = new SAEncryptAPIImpl(sAContextManager);
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return this.mEncryptAPIImpl.invokeModuleFunction(str, objArr);
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
