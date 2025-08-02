package com.appsflyer.internal;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class o implements RejectedExecutionHandler {
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AFc1tSDK.AFInAppEventParameterName(runnable, threadPoolExecutor);
    }
}
