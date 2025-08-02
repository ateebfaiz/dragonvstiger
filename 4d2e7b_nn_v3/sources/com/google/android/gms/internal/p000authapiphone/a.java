package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.a  reason: invalid package */
final class a extends zzi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6868a;

    a(zzab zzab, TaskCompletionSource taskCompletionSource) {
        this.f6868a = taskCompletionSource;
    }

    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.f6868a);
    }
}
