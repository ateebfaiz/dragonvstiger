package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.d  reason: invalid package */
final class d extends zzd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6870a;

    d(zzr zzr, TaskCompletionSource taskCompletionSource) {
        this.f6870a = taskCompletionSource;
    }

    public final void zzb(Status status, int i10) {
        TaskUtil.setResultOrApiException(status, Integer.valueOf(i10), this.f6870a);
    }
}
