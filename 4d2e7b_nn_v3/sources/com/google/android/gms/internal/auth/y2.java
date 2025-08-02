package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

final class y2 extends IStatusCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f7019a;

    y2(b bVar, TaskCompletionSource taskCompletionSource) {
        this.f7019a = taskCompletionSource;
    }

    public final void onResult(Status status) {
        b.a(status, (Object) null, this.f7019a);
    }
}
