package com.google.android.gms.internal.auth;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class a extends zzj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6886a;

    a(b bVar, TaskCompletionSource taskCompletionSource) {
        this.f6886a = taskCompletionSource;
    }

    public final void zzb(Status status, Bundle bundle) {
        b.a(status, bundle, this.f6886a);
    }
}
