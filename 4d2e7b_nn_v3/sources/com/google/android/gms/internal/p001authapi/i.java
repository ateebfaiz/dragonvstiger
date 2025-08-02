package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.i  reason: invalid package */
final class i extends zbag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6879a;

    i(zbbg zbbg, TaskCompletionSource taskCompletionSource) {
        this.f6879a = taskCompletionSource;
    }

    public final void zbb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f6879a);
    }
}
