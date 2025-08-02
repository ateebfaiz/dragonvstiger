package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class a3 extends zzl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6894a;

    a3(b bVar, TaskCompletionSource taskCompletionSource) {
        this.f6894a = taskCompletionSource;
    }

    public final void zzb(Status status, AccountChangeEventsResponse accountChangeEventsResponse) {
        b.a(status, accountChangeEventsResponse, this.f6894a);
    }
}
