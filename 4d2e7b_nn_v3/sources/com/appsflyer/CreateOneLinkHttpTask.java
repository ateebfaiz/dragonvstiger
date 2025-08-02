package com.appsflyer;

import androidx.annotation.WorkerThread;
import com.appsflyer.internal.AFc1fSDK;
import java.util.concurrent.ExecutorService;

@Deprecated
public final class CreateOneLinkHttpTask {
    public final AFc1fSDK AFInAppEventParameterName;
    public final ExecutorService valueOf;

    @Deprecated
    public interface ResponseListener {
        @WorkerThread
        void onResponse(String str);

        @WorkerThread
        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask() {
    }

    public CreateOneLinkHttpTask(AFc1fSDK aFc1fSDK, ExecutorService executorService) {
        this.AFInAppEventParameterName = aFc1fSDK;
        this.valueOf = executorService;
    }
}
