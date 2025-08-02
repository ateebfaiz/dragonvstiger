package com.sensorsdata.analytics.android.sdk.exposure;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;

public class SAExposureProtocolImpl implements SAModuleProtocol {
    private boolean mEnable = false;
    private SAExposedProcess mExposedProcess;

    private void addExposureView(View view, SAExposureData sAExposureData) {
        SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.addExposureView(view, sAExposureData);
        }
    }

    private void init(SAExposureConfig sAExposureConfig) {
        if (sAExposureConfig == null) {
            sAExposureConfig = new SAExposureConfig(0.0f, 0.0d, true);
        }
        this.mExposedProcess = new SAExposedProcess(sAExposureConfig);
    }

    private void removeExposureView(View view, String str) {
        SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.removeExposureView(view, str);
        }
    }

    private void setExposureIdentifier(View view, String str) {
        SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.setExposureIdentifier(view, str);
        }
    }

    public String getModuleName() {
        return Modules.Exposure.MODULE_NAME;
    }

    public int getPriority() {
        return 5;
    }

    public void install(SAContextManager sAContextManager) {
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
        init(sAContextManager.getInternalConfigs().saConfigOptions.getExposureConfig());
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 427307917:
                if (str.equals(Modules.Exposure.METHOD_ADD_EXPOSURE_VIEW)) {
                    c10 = 0;
                    break;
                }
                break;
            case 984217328:
                if (str.equals(Modules.Exposure.METHOD_REMOVE_EXPOSURE_VIEW)) {
                    c10 = 1;
                    break;
                }
                break;
            case 1653096003:
                if (str.equals(Modules.Exposure.METHOD_UPDATE_EXPOSURE_PROPERTIES)) {
                    c10 = 2;
                    break;
                }
                break;
            case 1742638354:
                if (str.equals(Modules.Exposure.METHOD_SET_EXPOSURE_IDENTIFIER)) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                addExposureView(objArr[0], objArr[1]);
                break;
            case 1:
                if (objArr.length != 2) {
                    removeExposureView(objArr[0], (String) null);
                    break;
                } else {
                    removeExposureView(objArr[0], objArr[1]);
                    break;
                }
            case 2:
                this.mExposedProcess.updateExposureView(objArr[0], objArr[1]);
                break;
            case 3:
                setExposureIdentifier(objArr[0], objArr[1]);
                break;
        }
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
