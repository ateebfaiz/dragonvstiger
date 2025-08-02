package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzl;
import com.google.android.gms.tasks.TaskCompletionSource;

final class f extends zzl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6860a;

    f(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6860a = taskCompletionSource;
    }

    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f6860a);
    }
}
