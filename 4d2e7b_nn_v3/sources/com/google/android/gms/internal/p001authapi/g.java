package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.g  reason: invalid package */
final class g extends zbab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6877a;

    g(zbbg zbbg, TaskCompletionSource taskCompletionSource) {
        this.f6877a = taskCompletionSource;
    }

    public final void zbb(Status status, BeginSignInResult beginSignInResult) {
        TaskUtil.setResultOrApiException(status, beginSignInResult, this.f6877a);
    }
}
