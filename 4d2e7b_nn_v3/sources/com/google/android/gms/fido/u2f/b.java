package com.google.android.gms.fido.u2f;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzt;
import com.google.android.gms.internal.fido.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

final class b extends zzu {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6867a;

    b(U2fApiClient u2fApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6867a = taskCompletionSource;
    }

    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, new zzt(pendingIntent), this.f6867a);
    }
}
