package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(@NonNull Status status, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        setResultOrApiException(status, (Object) null, taskCompletionSource);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(@NonNull Task<Boolean> task) {
        return task.continueWith(new o0());
    }

    @KeepForSdk
    public static <ResultT> boolean trySetResultOrApiException(@NonNull Status status, @Nullable ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            return taskCompletionSource.trySetResult(resultt);
        }
        return taskCompletionSource.trySetException(new ApiException(status));
    }

    @KeepForSdk
    public static <TResult> void setResultOrApiException(@NonNull Status status, @Nullable TResult tresult, @NonNull TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(new ApiException(status));
        }
    }
}
