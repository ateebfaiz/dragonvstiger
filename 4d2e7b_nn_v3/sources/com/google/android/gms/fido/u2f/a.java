package com.google.android.gms.fido.u2f;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzt;
import com.google.android.gms.internal.fido.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

final class a extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6866a;

    a(U2fApiClient u2fApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6866a = taskCompletionSource;
    }

    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, new zzt(pendingIntent), this.f6866a);
    }
}
