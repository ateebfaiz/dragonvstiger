package com.sensorsdata.analytics.android.sdk.visual.impl;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;

public class SAVisualProtocolAPI implements SAModuleProtocol {
    private static final String TAG = "SA.SAVisualProtocolImpl";
    private boolean mEnable = false;
    private SAContextManager mSAContextManager;
    private VisualProtocolImpl mVisualImpl;

    public String getModuleName() {
        return Modules.Visual.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mVisualImpl = new VisualProtocolImpl(sAContextManager);
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return this.mVisualImpl.invokeModuleFunction(str, objArr);
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setModuleState(boolean z10) {
        if (this.mEnable != z10) {
            this.mEnable = z10;
        }
        if (z10 && this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
            VisualPropertiesManager.getInstance().requestVisualConfig(this.mSAContextManager);
        }
    }
}
