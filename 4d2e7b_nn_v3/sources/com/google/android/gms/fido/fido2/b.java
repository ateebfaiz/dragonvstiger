package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzq;
import com.google.android.gms.tasks.TaskCompletionSource;

final class b extends zzq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6856a;

    b(Fido2ApiClient fido2ApiClient, TaskCompletionSource taskCompletionSource) {
        this.f6856a = taskCompletionSource;
    }

    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.f6856a);
    }
}
