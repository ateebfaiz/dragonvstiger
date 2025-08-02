package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.b  reason: invalid package */
final class b extends zby {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6874a;

    b(zbaq zbaq, TaskCompletionSource taskCompletionSource) {
        this.f6874a = taskCompletionSource;
    }

    public final void zbb(Status status, AuthorizationResult authorizationResult) {
        if (status.isSuccess()) {
            this.f6874a.setResult(authorizationResult);
        } else {
            this.f6874a.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
