package com.sensorsdata.analytics.android.sdk.core.mediator.protocol;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;

public interface SAModuleProtocol {
    String getModuleName();

    int getPriority();

    void install(SAContextManager sAContextManager);

    <T> T invokeModuleFunction(String str, Object... objArr);

    boolean isEnable();

    void setModuleState(boolean z10);
}
