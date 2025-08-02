package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.e  reason: invalid package */
final class e extends zbak {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6876a;

    e(zbaw zbaw, TaskCompletionSource taskCompletionSource) {
        this.f6876a = taskCompletionSource;
    }

    public final void zbb(Status status, SavePasswordResult savePasswordResult) {
        TaskUtil.setResultOrApiException(status, savePasswordResult, this.f6876a);
    }
}
