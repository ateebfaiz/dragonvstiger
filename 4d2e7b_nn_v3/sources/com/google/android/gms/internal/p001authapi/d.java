package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.d  reason: invalid package */
final class d extends zbai {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6875a;

    d(zbaw zbaw, TaskCompletionSource taskCompletionSource) {
        this.f6875a = taskCompletionSource;
    }

    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) {
        if (status.isSuccess()) {
            this.f6875a.setResult(saveAccountLinkingTokenResult);
        } else {
            this.f6875a.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
