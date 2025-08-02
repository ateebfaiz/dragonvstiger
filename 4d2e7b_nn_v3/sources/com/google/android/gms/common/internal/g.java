package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class g implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PendingResult f6788a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6789b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PendingResultUtil.ResultConverter f6790c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zas f6791d;

    g(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zas) {
        this.f6788a = pendingResult;
        this.f6789b = taskCompletionSource;
        this.f6790c = resultConverter;
        this.f6791d = zas;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.f6789b.setResult(this.f6790c.convert(this.f6788a.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f6789b.setException(ApiExceptionUtil.fromStatus(status));
    }
}
