package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.g  reason: invalid package */
final class g extends IStatusCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6872a;

    g(zzv zzv, TaskCompletionSource taskCompletionSource) {
        this.f6872a = taskCompletionSource;
    }

    public final void onResult(Status status) {
        if (status.getStatusCode() == 6) {
            this.f6872a.trySetException(ApiExceptionUtil.fromStatus(status));
        } else {
            TaskUtil.setResultOrApiException(status, this.f6872a);
        }
    }
}
