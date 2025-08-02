package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.h  reason: invalid package */
final class h extends IStatusCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6878a;

    h(zbbg zbbg, TaskCompletionSource taskCompletionSource) {
        this.f6878a = taskCompletionSource;
    }

    public final void onResult(Status status) {
        TaskUtil.setResultOrApiException(status, this.f6878a);
    }
}
