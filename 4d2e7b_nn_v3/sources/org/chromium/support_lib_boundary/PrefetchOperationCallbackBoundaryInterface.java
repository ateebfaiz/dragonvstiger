package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

public interface PrefetchOperationCallbackBoundaryInterface {
    void onFailure(InvocationHandler invocationHandler);

    void onSuccess();
}
