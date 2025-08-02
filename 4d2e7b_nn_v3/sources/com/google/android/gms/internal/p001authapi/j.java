package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.j  reason: invalid package */
final class j extends zbae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6880a;

    j(zbbg zbbg, TaskCompletionSource taskCompletionSource) {
        this.f6880a = taskCompletionSource;
    }

    public final void zbb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f6880a);
    }
}
