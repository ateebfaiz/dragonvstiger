package com.google.android.gms.internal.auth;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class x2 extends zzn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f7018a;

    x2(b bVar, TaskCompletionSource taskCompletionSource) {
        this.f7018a = taskCompletionSource;
    }

    public final void zzb(Status status, Bundle bundle) {
        b.a(status, bundle, this.f7018a);
    }
}
