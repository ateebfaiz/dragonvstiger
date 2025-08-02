package com.sensorsdata.analytics.android.webview.impl;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;

public class SensorsWebViewAPI implements SAModuleProtocol {
    private boolean mEnable = false;
    private SAWebViewProtocolImpl mWebViewProtocolImpl;

    public String getModuleName() {
        return Modules.WebView.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        this.mWebViewProtocolImpl = new SAWebViewProtocolImpl(sAContextManager);
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        return this.mWebViewProtocolImpl.invokeModuleFunction(str, objArr);
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
