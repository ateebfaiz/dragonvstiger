package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.e  reason: invalid package */
final class e extends zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6871a;

    e(zzr zzr, TaskCompletionSource taskCompletionSource) {
        this.f6871a = taskCompletionSource;
    }

    public final void zzb(Status status, boolean z10) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z10), this.f6871a);
    }
}
